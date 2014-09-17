package ar.com.scriptorum.beans;

import java.util.Set;


public class PUnit implements Unit, PersistentEntity, Comparable<PUnit> {

    private static final long serialVersionUID = 1L;
    private long id;
    private String modifiedOn;
    private Set<? extends PMethod> methods;
    private PName pName;
    private String module;
    private String modifiedBy;
    private Integer nLines;
    private String md5;
    private String creation;
    private CycloInfo cycloInfo;
    
    public void setpName(PName pName) {
        this.pName = pName;
    }
    public PName getpName() {
        return pName;
    }
    public void setPName(PName pName) {
        this.pName = pName;
    }
    public PName getPName() {
        return pName;
    }

    public Integer getNLines() {
        return nLines;
    }
    public void setNLines(Integer nLines) {
        this.nLines = nLines;
    }
    public Integer getnLines() {
        return nLines;
    }
    public void setnLines(Integer nLines) {
        this.nLines = nLines;
    }
    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
    public void setMethods(Set<? extends PMethod> methods) {
        this.methods = methods;
    }

    public void setModule(String module) {
        this.module = module;
    }
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
    
    @Override
    public long getId() {
        return id;
    }
    @Override
    public void setId(long id) {
        this.id = id;
    }
    
    @Override
    public String getModifiedBy() {
        return modifiedBy;
    }
    @Override
    public String getModule() {
        return module;
    }
    @Override
    public String getName() {
        return getPName().getName();
    }
    public Set<? extends PMethod> getMethods() {
        return methods;
    }
    @Override
    public String getModifiedOn() {
        return modifiedOn;
    }
    public String getMd5() {
        return md5;
    }
    public void setMd5(String md5) {
        this.md5 = md5;
    }
    @Override
    public String getCreation() {
        return creation;
    }
    
    public CycloInfo getCycloInfo() {
        return cycloInfo;
    }
    
    public String getComplexity() {
        StringBuffer result = new StringBuffer();
        for (PMethod m : this.getMethods()) {
            int complexity = 0;
            for (Keywords k : m.getKeywords()) {
                complexity += k.getIfKeyword() + k.getElseKeyword() + k.getSwitchKeyword() + k.getCaseKeyword() + k.getNewKeyword() + k.getAutowiredKeyword();
            }
            result.append(m.getName()+ " " + complexity + " ");
        }
        return result.toString();
    }
    
    @Override
    public int compareTo(PUnit o) {
        
        return 0;
    }

}
