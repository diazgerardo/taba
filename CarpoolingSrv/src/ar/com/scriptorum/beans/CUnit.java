package ar.com.scriptorum.beans;

import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;


public class CUnit implements Unit {

    private static Logger _logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
    File f;
    CompilationUnit unit;
    BasicFileAttributes fileAttributes;
    AclFileAttributeView aclFileAttributes;
    private CycloInfo cycloInfo;
    private Map<String, UMethod> methods;
 
    public CUnit(File f, CompilationUnit unit) {
        this.unit = unit;
        this.f = f;
        try {
            this.aclFileAttributes = Files.getFileAttributeView(f.toPath(), AclFileAttributeView.class);
            this.fileAttributes = Files.readAttributes(f.toPath(), BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
            new MethodVisitor().visit(unit, null);
            cycloInfo = new CycloInfo(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer getNLines() {
        return unit.getEndLine();
    }

    @Override
    public String getModifiedOn() {
        return new SimpleDateFormat("dd-MM-yyyy dd:mm:ss").format(new Date(fileAttributes.lastModifiedTime().toMillis()));
    }

    @Override
    public String getCreation() {
        return ""+fileAttributes.creationTime().toMillis();
    }
    
    
    @Override
    public String getModifiedBy() {
        return "unknown yet";
    }

    @Override
    public String getModule() {
        return "unknown yet";
    }

    @Override
    public String getName() {
        return f.getName();
    }

    public Map<String, ? extends UMethod> getMethods() {
        return methods;
    }

    /**
     * should any method change, the same will happen for its container class
     * @return
     */
    public String getMd5() {
        // Carpooler.java --- 130479255582116279
        StringBuffer md5=new StringBuffer();
        md5.append(this.getCreation());
        for(UMethod m : methods.values()) {
            md5.append(m.getMd5());
        }
        _logger.debug(">"+md5.toString()+"<");            
        return new String(DigestUtils.md5DigestAsHex(md5.toString().getBytes()).toString());
    }

    private class MethodVisitor extends VoidVisitorAdapter<Object> {

        MethodVisitor() {
            methods = new HashMap<String, UMethod>();
        }

        @Override
        public void visit(MethodDeclaration n, Object arg) {
            methods.put(n.getName(), new UMethod(n));
        }
    }

    public CycloInfo getCycloInfo() {
        return cycloInfo;
    }
}
