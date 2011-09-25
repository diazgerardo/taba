package ar.com.scriptorum.taba.singletons;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Environment;

public class MovilSerializer {
	static String _stamp;
	static File _xml;
	static FileWriter _fstream;
	static BufferedWriter _out;
	static MovilSerializer _instance;
	
	public static MovilSerializer getInstance() {
		if( _instance == null) 
			_instance = new MovilSerializer();
		return _instance;
	}
	
	public void save(Movil _movil) {

		try {
			_out.write(_movil.toXmlString());
			_out.newLine();			
		  }catch (Exception e){//Catch exception if any
		  System.err.println("Error: " + e.getMessage());
		  }

	}

	static {
		_stamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
		_xml = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/m"+_stamp+".xml");
		_fstream = null;
		try {
			_fstream = new FileWriter(_xml);
		} catch (IOException e) {
			e.printStackTrace();
		}
		_out = new BufferedWriter(_fstream);
	}
}
