package ar.com.scriptorum.beans;

import japa.parser.ast.body.Parameter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PMethod implements PersistentEntity, Method {
    private static final long serialVersionUID = 1L;
    private long id;
    private String name;
    private String md5;
    private String body;
    private Integer lines;
    private List<Parameter> parameters;
    private Integer countParameters;
    private PUnit pUnit;
    private Set<Keywords> keywords;

    public PUnit getpUnit() {
        return pUnit;
    }

    public void setpUnit(PUnit pUnit) {
        this.pUnit = pUnit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLines(Integer lines) {
        this.lines = lines;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public void setCountParameters(Integer countParameters) {
        this.countParameters = countParameters;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getLines() {
        return lines;
    }

    @Override
    public List<Parameter> getParameters() {
        return parameters;
    }

    @Override
    public Integer getCountParameters() {
        return countParameters;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @Override
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Set<Keywords> getKeywords() {
        if(keywords==null)
            keywords = new HashSet<Keywords>();
        return keywords;
    }

    public void setKeywords(Set<Keywords> keywords) {
        this.keywords = keywords;
    }

}
