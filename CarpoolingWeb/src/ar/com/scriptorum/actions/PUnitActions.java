package ar.com.scriptorum.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import ar.com.scriptorum.beans.Method;
import ar.com.scriptorum.beans.PUnit;
import ar.com.scriptorum.dao.PUnitDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class PUnitActions extends SpringActionSupport implements ModelDriven<PUnit> {

	private List<PUnit> punitList = new ArrayList<PUnit>();
	private List<Method> pmethods = new ArrayList<Method>();
	
	PUnit punit = new PUnit();	
	/**
	 * dao reference taken from spring's inherited context
	 */
	private PUnitDao punitDao = (PUnitDao) context.getBean("punitDao");
	
	private String column;
	
	public String getColumn() { 
	    return column;
	}
	
	public void setColumn(String column){
	    this.column=column;
	}

    private static Map<String,DirectionableComparator<PUnit>> comparators = new HashMap<String, DirectionableComparator<PUnit>>();

    static { 
        comparators.put("byName", new ByName());
        comparators.put("byLine", new ByLine());
    }
	public String saveOrUpdate() {	
	    
		punitDao.saveOrUpdate(punit);
		return SUCCESS;
	}

	public String edit() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("usuario"));
		punit = punitDao.findById(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	public String delete(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		PUnit toBeDeleted = punitDao.findById(Long.parseLong(request.getParameter("id")));
		punitDao.delete(toBeDeleted);
		return SUCCESS;
	}

	@Override
	public PUnit getModel() {
		return punit;
	}

	public PUnit getPunit() {
		return punit;
	}

	public void setPUnit(PUnit punit) {
		this.punit = punit;
	}

	public List<PUnit> getPunitList() {
		return punitList;
	}

	public void setPunitList(List<PUnit> punitList) {
		this.punitList = punitList;
	}

	public String list() {
	    punitList = punitDao.findAll();
		return SUCCESS;
	}

    public String sort() {
        list();
        Collections.sort(punitList, comparators.get(getColumn()).direction(getSortDirection()));
        return SUCCESS;
    }
    
    public String showPMethods() {
        punit = punitDao.findById(Long.parseLong(getHttpServletRequest().getParameter("id")));
        pmethods = Arrays.asList(punit.getMethods().toArray(new Method[]{}));
        return SUCCESS;
    }

    public List<Method> getPmethods() {
        return pmethods;
    }

    public void setPmethods(List<Method> pmethods) {
        this.pmethods = pmethods;
    }

    public void setPunit(PUnit punit) {
        this.punit = punit;
    }


}