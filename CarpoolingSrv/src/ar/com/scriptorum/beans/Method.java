package ar.com.scriptorum.beans;

import japa.parser.ast.body.Parameter;

import java.util.List;
import java.util.Set;

public interface Method {
    
    public String getName();
    public String getMd5();
    public Integer getLines();
    public List<Parameter> getParameters();
    public Integer getCountParameters();
    public String getBody();
    public Set<Keywords> getKeywords();
    public void setKeywords(Set<Keywords> keywords);

}
