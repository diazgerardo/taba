package com.scriptorum.view;

import android.app.Activity;
import android.os.Bundle;

public class FourthTab extends Activity {
	RutaVisible rutaVisible = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		setContentView(new RutaVisible(getApplicationContext()));
	}
}
