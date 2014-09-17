package ar.com.scriptorum.beans;

import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.stmt.BlockStmt;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

public class UMethod implements Method {

    private static Logger _logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    MethodDeclaration methodDeclaration;
    List<Parameter> parameters;

    private Set<Keywords> keywords;

    public UMethod(MethodDeclaration methodDeclaration) {
        this.methodDeclaration = methodDeclaration;
        this.parameters = methodDeclaration.getParameters();
    }

    @Override
    public String getName() {
        return methodDeclaration.getName();
    }

    @Override
    public Integer getCountParameters() {
        return parameters != null ? parameters.size() : 0;
    }

    @Override
    public List<Parameter> getParameters() {
        return parameters;
    }

    @Override
    public Integer getLines() {
        return methodDeclaration.getEndLine()-methodDeclaration.getBeginLine();
    }

    @Override
    public String getMd5() {
        _logger.debug(">");
        BlockStmt body = methodDeclaration.getBody();
        StringBuffer sb = new StringBuffer();
        sb.append(methodDeclaration.getName());
        sb.append(body!=null?body.toString():"");
        return new String(DigestUtils.md5DigestAsHex(sb.toString().getBytes()));
    }

    public String getBody() {
        try {
            return methodDeclaration.getBody().toString();
        }catch(NullPointerException e) { 
            // interfaces don't have body
            return "";
        }
    }

    @Override
    public Set<Keywords> getKeywords() {
        return keywords;
    }

    @Override
    public void setKeywords(Set<Keywords> keywords) {
        this.keywords=keywords;
    }
    

}
