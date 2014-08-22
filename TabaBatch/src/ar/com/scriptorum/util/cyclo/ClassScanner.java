package ar.com.scriptorum.util.cyclo;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.DigestUtils;

import ar.com.scriptorum.util.StringUtil;


public class ClassScanner {

	private String name;
	private String module;
	private String content;
	private int occurrences;
	private int lines;
	private String result;
	private Map<String, String> methods = new HashMap<String, String>();
	private int maxParams;

	
	public ClassScanner(File file, String moduleName) {
		try {
			content = FileManager.readFileAsString(file.getCanonicalPath());
			lines = FileManager.lines();
			name = file.getName();
			module = moduleName;
			
	        FileInputStream in = new FileInputStream(file.getAbsolutePath());

	        CompilationUnit cu = null;
	        try {
	            // parse the file
	            cu = JavaParser.parse(in);
	        } catch (ParseException e) {
				e.printStackTrace();
			} finally {
	            in.close();
		        // prints the resulting compilation unit to default system output
		        new MethodScanner().visit(cu, null);
	        }

		} catch (IOException e) {
			throw new RuntimeException("invalid file received.");
		}
	}
	
	public boolean scan(String st) {
		if(content.contains(st)) {
			occurrences = StringUtil.count(content, st);
			return true;
		}
		occurrences = 0;
		return false;
	}
	
	public ClassScanner scan(String[] st) {
		StringBuffer sb = new StringBuffer();
		for(String s : st) {
			scan(s);
			sb.append(occurrences+"\t");
			occurrences = 0;
		}
		result = sb.toString();
		return this;
	}
	
	public String print() {
		return this.module+"\t"+this.name+"\t"+this.lines+"\t"+methods.size()+"\t"+maxParams+"\t"+result+printMethods();
	}
	
	private String printMethods() {
		StringBuffer strMethods = new StringBuffer();
		for(String key : methods.keySet()) {
			strMethods.append("\t"+key+"\t"+methods.get(key));
		}
		return strMethods.toString();
	}

	public Record asRecord() {
		
		return new RecordBuilder()
		.setModule(this.module)
		.setName(this.name)
		.setLines(this.lines)
		.setSize(methods.size())
		.setMaxParam(maxParams)
		.setResults(result)
		.build();
		
	}

	public String name() {
		return name;
	}

	public int occurrences() {
		return occurrences;
	}

	public int lines() {
		return lines;
	}

	public String modulize() {
		return module;
	}
	
	
	 private class MethodScanner extends VoidVisitorAdapter {

	        @Override
	        public void visit(MethodDeclaration n, Object arg) {
	        	
	        	int max=0;
	            methods.put(toMd5(n.getBody()), n.getName());
	            if(n.getParameters()!=null) {
	            	max= n.getParameters().size();
	            }
	            if(max>maxParams) { 
	            	maxParams=max;
	            }
	        }

			private String toMd5(BlockStmt body) {
				String bodyStr = body==null?"":body.toString();
				return new String(DigestUtils.md5DigestAsHex(bodyStr.getBytes()));
			}
	    }
}
