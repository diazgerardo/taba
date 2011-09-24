package ar.com.scriptorum.taba.singletons;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Environment;

public class MovilSerializer {
	public static void save(Movil _movil) {

		try {
			String stamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
			File xml = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/m"+stamp+".xml");
			FileWriter fstream = new FileWriter(xml);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(_movil.toXmlString());
			out.newLine();
		  //Close the output stream
		  out.close();
		  }catch (Exception e){//Catch exception if any
		  System.err.println("Error: " + e.getMessage());
		  }

	}
}
