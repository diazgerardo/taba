package com.scriptorum.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class RutaVisible extends View {
	public RutaVisible(Context context) {
		super(context);
	}

	@Override
	public void onDraw(Canvas canvas) {
		canvas.drawRect(1, 1, 3, 3, new Paint());
	}
}
