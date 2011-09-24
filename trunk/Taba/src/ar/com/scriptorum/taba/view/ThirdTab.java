package ar.com.scriptorum.taba.view;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import ar.com.scriptorum.taba.abstractions.Trayectoria;
import ar.com.scriptorum.taba.singletons.Movil;


public class ThirdTab extends Activity {
	static Drawable oldDrawable = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
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
		button3.setOnClickListener(onClickListener);
		Button button4 = (Button) findViewById(R.id.button4);
		button4.setOnClickListener(onClickListener);
		Button button5 = (Button) findViewById(R.id.button5);
		button5.setOnClickListener(onClickListener);
		Button button6 = (Button) findViewById(R.id.button6);
		button6.setOnClickListener(onClickListener);

	}
	
}
