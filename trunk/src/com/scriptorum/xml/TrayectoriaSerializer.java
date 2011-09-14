package com.scriptorum.xml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import android.os.Environment;

import com.scriptorum.abstractions.Vertice;

public class TrayectoriaSerializer {
	
	static int number;

	public static void save(LinkedList<Vertice> trayectoria) {

		try {
			String stamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
			File xml = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/t"+stamp+".xml");
			FileWriter fstream = new FileWriter(xml);
			BufferedWriter out = new BufferedWriter(fstream);
		  for(Vertice v : trayectoria) {
			  out.write(v.toXmlString());
			  out.newLine();
		  }
		  //Close the output stream
		  out.close();
		  }catch (Exception e){//Catch exception if any
		  System.err.println("Error: " + e.getMessage());
		  }

	}
}
