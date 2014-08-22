package ar.com.scriptorum.util.cyclo;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import ar.com.scriptorum.util.DateUtil;



/**
 * Una versión simplificada para el cálculo de la Complejidad Ciclomática es la
 * siguiente: M = Número de condiciones (max) + 1
 * 
 * @see http://es.wikipedia.org/wiki/Complejidad_ciclom%C3%A1tica
 * @author gd21367
 * 
 */
public class CyclomplexityTest {

	List<ClassScanner> scanners = null;

	final static Logger _logger = Logger.getLogger(CyclomplexityTest.class);
	final static int M = 4;
	
	@Test
	public void workspaceFullScan() throws Exception {

		_logger.debug(new DateUtil().getYYYYMMDD(new Date()));
		String path = "C:/Documents and Settings/gd21367/Desktop/proyectos/workspaces/asignator2013/";

		String[] modules = new String[] { "assignations", "bonds", "core", "envelopes", "Bus", "workflow" };
		String[] keywords = new String[] { "if", "else", "switch", "case", "Autowired", "new" };
		
		printTitle(keywords);
		for (String moduleName : modules) {

			scanners = new ArrayList<ClassScanner>();
			new ScanHelper(keywords).walkOn(path + moduleName, moduleName);
			for (ClassScanner s : scanners)
				System.out.println(s.scan(keywords).print());
		}
	};

	private void printTitle(String[] keywords) {
		System.out.print("module	class	lines	methods	params");
		for (String keyword : keywords) {
			System.out.print("\t" + keyword);
		}
		System.out.println("");
	}


	class ScanHelper {

		String[] keywords;
		List<File> files;

		ScanHelper(String[] keywords) {
			this.keywords = keywords;
		}

		public List<File> walkOn(String path, String module) {

			// tests nullness because recursive calls don't send
			File root = new File(path);
			files = Arrays.asList(root.listFiles());

			for (File file : files) {
				// System.out.println("i="+i+f.getName());
				if (file.isDirectory()) 
					new ScanHelper(keywords).walkOn(file.getAbsolutePath(),module);
				else if (file.getName().toUpperCase().endsWith(".JAVA"))
					scanners.add(new ClassScanner(file, module));

			}

			return files;
		}
	}

}
