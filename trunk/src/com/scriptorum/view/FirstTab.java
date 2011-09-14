package com.scriptorum.view;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.scriptorum.abstractions.Vertice;

public class FirstTab extends MyActivity {
	LinearLayout root;
	ListView lv;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		root = new LinearLayout(this);
		lv = new ListView(this);
		lv.setAdapter(new ArrayAdapter<Vertice>(this, R.layout.list_item,ruta.getRuta()));
		lv.setBackgroundColor(Color.WHITE);
		root.addView(lv);
		root.setBackgroundColor(Color.BLACK);
		setContentView(root);
	}

}