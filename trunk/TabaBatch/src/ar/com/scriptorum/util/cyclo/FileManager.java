package ar.com.scriptorum.util.cyclo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class FileManager {
	private static int lines;

	static public synchronized String readFileAsString(String filePath) {
//		_logger.info(">");
//		_logger.debug("reading file " + filePath );
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader br = getBufferedReader(filePath);
			String textLine;
		    while ((textLine = br.readLine()) != null) {
		    	lines++;
		        sb.append(textLine);
		    }
		    br.close();
		} catch (IOException e) {
			throw new RuntimeException("Exception caught, cause: "+e.getCause());
		}
//		_logger.debug("sb.toString(): "+sb.toString());
//		_logger.info("<");
		return sb.toString();
	}

	public static synchronized BufferedReader getBufferedReader(String filePath) {
		try {
			return new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath))));
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File not found: "+filePath);
		}	
	}

	static public synchronized int lines() {
		int tmp = lines;
		lines = 0;
		return tmp;
	}

}
