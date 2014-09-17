package ar.com.scriptorum.beans;

import java.util.Date;

public class Keywords implements PersistentEntity, Comparable<Keywords> {

    private static final long serialVersionUID = 1L;
    private int ifKeyword;
    private int elseKeyword;
    private int switchKeyword;
    private int caseKeyword;
    private int autowiredKeyword;
    private int newKeyword;
    private Date builtOn;
    private PMethod pMethod;
    private long id;
    private String name;
    
    public int getIfKeyword() {
        return ifKeyword;
    }
    public void setIfKeyword(int ifKeyword) {
        this.ifKeyword = ifKeyword;
    }
    public int getElseKeyword() {
        return elseKeyword;
    }
    public void setElseKeyword(int elseKeyword) {
        this.elseKeyword = elseKeyword;
    }
    public int getSwitchKeyword() {
        return switchKeyword;
    }
    public void setSwitchKeyword(int switchKeyword) {
        this.switchKeyword = switchKeyword;
    }
    public int getCaseKeyword() {
        return caseKeyword;
    }
    public void setCaseKeyword(int caseKeyword) {
        this.caseKeyword = caseKeyword;
    }
    public int getAutowiredKeyword() {
        return autowiredKeyword;
    }
    public void setAutowiredKeyword(int autowiredKeyword) {
        this.autowiredKeyword = autowiredKeyword;
    }
    public int getNewKeyword() {
        return newKeyword;
    }
    public void setNewKeyword(int newKeyword) {
        this.newKeyword = newKeyword;
    }
    @Override
    public long getId() {
        return this.id;
    }
    @Override
    public void setId(long id) {
        this.id = id;
    }
    public Date getBuiltOn() {
        return builtOn;
    }
    public void setBuiltOn(Date builtOn) {
        this.builtOn = builtOn;
    }
    public PMethod getpMethod() {
        return pMethod;
    }
    public void setpMethod(PMethod pMethod) {
        this.pMethod = pMethod;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public int compareTo(Keywords o) {
        return 0;
    }
}
