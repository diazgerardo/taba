package ar.com.scriptorum.taba.cartografia;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import ar.com.scriptorum.taba.abstractions.Ruta;
import ar.com.scriptorum.taba.abstractions.Vertice;

public class MapDrawer { 

	private Ruta ruta;
	private Bitmap map;

	
	public MapDrawer() {}

	public MapDrawer ruta(Ruta ruta) {
		this.ruta = ruta;
		return this;
	}

	public MapDrawer drawOn(Bitmap updatedMap) {

		Canvas canvas = new Canvas();
		canvas.setBitmap(updatedMap);

		// draws a mock map arbitrarily selected from a bigger one.
		// the real implementation should draw a vectorial map based
		// on the nodes we select from the database based on the
		// location of the movil...
		canvas.drawBitmap(updatedMap, 1, 1, null);

		// from now on, we'll draw several circles, based on their xy
		// coordinates. none of these points are of special interest 
		// right now, but they are drawn as a proof of concept. 
		// they may be used to represent several things as towns, 
		// filling stations, and other points of interest for the
		// traveler right next to to the circle, we'll write (draw,
		// really) its description
		CartesianConverter cc = getCartesianConverter(updatedMap.getHeight(), updatedMap.getWidth());
		Paint paint = new Paint();
		paint.setStyle(Paint.Style.FILL);
		paint.setAntiAlias(true);
		paint.setTextSize(8);
		float RADIUS = 2;
		int xy[];

		for (Vertice vertice : ruta.getRuta()) {

			xy = cc.getXY(vertice);
			paint.setColor(Color.BLUE);
			canvas.drawCircle(xy[0], xy[1], RADIUS, paint);
			paint.setColor(Color.WHITE);
			canvas.drawText(vertice.getNombre(), xy[0], xy[1] + 5, paint);

		}
		
		map = updatedMap;
		return this;

	}

	public BitmapDrawable asDrawable() {
		
		if(null==map)
			Log.e("MapDrawer", "Bad usage in asDrawable!");
		return new BitmapDrawable(map);
	
	}
	
	private CartesianConverter getCartesianConverter(int height, int width) {

		// TODO remove these magic numbers replacing them with dynamic maximum/minimum
		// values taken from the path (Ruta) being drawn...
		return (CartesianConverter) new CartesianConverter()
				.latUpLeft(-30.0000). 		
				longUpLeft(-65.0000). 		
				latDownRight(-35.0000). 	
				longDownRight(-57.0000). 	
				imgHeight(height).imgWidht(width).build();

	}

}