package ar.com.scriptorum.taba.view;

import java.io.File;
import java.io.FilenameFilter;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import ar.com.scriptorum.taba.abstractions.Trayectoria;
import ar.com.scriptorum.taba.singletons.Movil;


public class ThirdTab extends MyActivity {
	static Drawable oldDrawable = null;

	
	private String[] mFileList;
	private File mPath = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
	private static final String FTYPE = ".xml";    
	private static final int DIALOG_LOAD_FILE = 1000;

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		loadFileList();
		setContentView(R.layout.tabs3);
		OnClickListener onClickListener = new OnClickListener() {
			
			public void onClick(View v) {
	
				if(null==oldDrawable) {
					oldDrawable = v.getBackground();
					v.setBackgroundColor(Color.BLUE);
				} else {
					v.setBackgroundDrawable(oldDrawable);
					oldDrawable = null;
				}
				
			}
		};
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(Trayectoria.getInstance());
		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(Movil.getInstance());
		Button button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// clean public vars
				mChosenFile = null;
				ruta = null;
				// pick file
				showDialog(1);
				// update ruta
				getRuta();
				
			}
		});
		Button button4 = (Button) findViewById(R.id.button4);
		button4.setOnClickListener(onClickListener);
		Button button5 = (Button) findViewById(R.id.button5);
		button5.setOnClickListener(onClickListener);
		Button button6 = (Button) findViewById(R.id.button6);
		button6.setOnClickListener(onClickListener);

	}

	@Override
	protected Dialog onCreateDialog(int id) {

		Dialog dialog = null;
		AlertDialog.Builder builder = new Builder(this);
		builder.setTitle("Choose your file");
		if (mFileList == null) {
			dialog = builder.create();
			return dialog;
		}
		
		builder.setItems(mFileList, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				mChosenFile = mFileList[which];
				// you can do stuff with the file here too
			}
		});
		
		dialog = builder.show();
		return dialog;
		
	}

	private void loadFileList() {

		if (mPath.exists()) {
			FilenameFilter filter = new FilenameFilter() {
				public boolean accept(File dir, String filename) {
					File sel = new File(dir, filename);
					return filename.contains(FTYPE) || sel.isDirectory();
				}
			};
			mFileList = mPath.list(filter);
		} else {
			mFileList = new String[0];
		}
	}

}
