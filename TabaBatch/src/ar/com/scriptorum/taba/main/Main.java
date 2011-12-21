package ar.com.scriptorum.taba.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import ar.com.scriptorum.taba.util.FileUtils;
import ar.com.scriptorum.taba.util.Record;

public class Main {
	public static void main(String [] args) throws IOException {
		//ExceptionFinder ef = ExceptionFinder.getInstance();
		try {
			BufferedReader br = FileUtils.getReader("datos.txt");
			String line;
			while( null != (line=br.readLine())) {
				Record record = new Record(line);
				System.out.println("Record.toString()= " + record.toString());
			}
		} catch (FileNotFoundException e) {
		}
	}

}
