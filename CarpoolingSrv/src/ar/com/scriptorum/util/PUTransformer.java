package ar.com.scriptorum.util;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.scriptorum.beans.CUnit;
import ar.com.scriptorum.beans.PMethod;
import ar.com.scriptorum.beans.PName;
import ar.com.scriptorum.beans.PUnit;
import ar.com.scriptorum.beans.UMethod;
import ar.com.scriptorum.beans.Unit;
import ar.com.scriptorum.dao.KeywordsDao;
import ar.com.scriptorum.dao.PMethodDao;
import ar.com.scriptorum.dao.PNameDao;
import ar.com.scriptorum.dao.PUnitDao;

public class PUTransformer {

    @Autowired
    PUnitDao punitDao;
    @Autowired
    PMethodDao pmethodDao;
    @Autowired
    PNameDao pnameDao;
    @Autowired
    KeywordsDao keywordsDao;

    public PUnit asPUnit(CUnit unit) {

        // find pName
        PName pName = pnameDao.findUnique("name", unit.getName());
        if (pName == null) {
            pName = pnameDao.findUnique("creation", unit.getCreation());
            if (pName != null) {
                // file changed its name!
                pName.setName(unit.getName());
            } else { // new file
                pName = newPName(unit);
            }
        }

        // find punits
        PUnit punit = punitDao.findUnique("pName", pName);
        if (punit == null) {
            // new punit needed
            punit = new PUnit();
        }
        punit.setPName(pName);
        punit.setModifiedBy(unit.getModifiedBy());
        punit.setModifiedOn(unit.getModifiedOn());
        punit.setModule(unit.getModule());
        punit.setNLines(unit.getNLines());
        punit.setMd5(unit.getMd5());
        try { 
                evalPMethodSet(punit, unit.getMethods());
                punitDao.saveOrUpdate(punit);
        }catch(Throwable t) {
            t.printStackTrace();
        }
        
        return punit;

    }

    private PName newPName(Unit unit) {
        System.out.println(new Date());
        PName pName = new PName();
        pName.setName(unit.getName());
        pName.setCreation(unit.getCreation());
        try { 
            pnameDao.saveOrUpdate(pName);
        }catch(Exception e) {
            e.printStackTrace();
        }
            
        return pName;
    }

    private void evalPMethodSet(PUnit pUnit, Map<String, ? extends UMethod> methods) {

        if (nullOrEmptySet(pUnit,  methods))
            return;
        else
            updateNonEmptySet(pUnit, methods);

    }

    @SuppressWarnings("unchecked")
    private void updateNonEmptySet(PUnit pUnit, Map<String, ? extends UMethod> newest) {

        for (PMethod p : (Set<PMethod>) pUnit.getMethods()) {
            UMethod n = newest.get(p.getName());
            if (n != null) {
                // method already exists
                if (!p.getMd5().equals(n.getMd5())) {
                    // incoming changes.. first update
                    p.setCountParameters(n.getCountParameters());
                    p.setLines(n.getLines());
                    p.setMd5(n.getMd5());
                    p.setParameters(n.getParameters());
                    p.setKeywords(new KeywordUtils().addDifferent(p.getKeywords(), n.getKeywords()));
                } else {
                    // do nothing as their md5 remains the same
                }
                // then remove the "newest" (not so newest) found
                newest.remove(p.getName());
            } else {
                // the method has been removed in the new version. do the same on both sides of the 
                // relationship to let delete orphans do its work
                pUnit.getMethods().remove(p);
                p.setpUnit(null);
            }
        }
        if (newest.size() > 0) {
            // there are more methods remaining there... add them one by one
            for (UMethod n : newest.values()) {
                PMethod p = new PMethod();
                p.setCountParameters(n.getCountParameters());
                p.setLines(n.getLines());
                p.setMd5(n.getMd5());
                p.setParameters(n.getParameters());
                p.setKeywords(n.getKeywords());
                // add references from each other
                p.setpUnit(pUnit);
                ((Set<PMethod>)pUnit.getMethods()).add(p);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private Boolean nullOrEmptySet(PUnit pUnit, Map<String, ? extends UMethod> methods) {

        // no mehods associated then associate new set and return

        Set<PMethod> set = null;
        if (pUnit.getMethods() == null)
            set = new HashSet<PMethod>();
        else if (!pUnit.getMethods().isEmpty())
            return Boolean.FALSE;
        else
            set = (Set<PMethod>) pUnit.getMethods();

        for (UMethod m : methods.values()) {
            PMethod p = new PMethod();
            p.setCountParameters(m.getCountParameters());
            p.setLines(m.getLines());
            p.setName(m.getName());
            p.setMd5(m.getMd5());
            p.setParameters(m.getParameters());
            p.setpUnit(pUnit);
            p.setKeywords(new KeywordUtils().addDifferent(p.getKeywords(), m.getKeywords()));
            set.add(p);
        }
        pUnit.setMethods(set);
        return Boolean.TRUE;
    }
}
