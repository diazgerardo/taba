package ar.com.scriptorum.taba.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileUtils {
	private static BufferedReader br;
	public static BufferedReader getReader(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		br = new BufferedReader(fr);
		return br;
	}
	
public Record getRecord () {

	return new Record();
}
}