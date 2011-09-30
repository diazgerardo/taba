package ar.com.scriptorum.taba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import ar.com.scriptorum.taba.abstractions.Vertice;
import ar.com.scriptorum.taba.cartografia.CartesianConverter;

public class FourthTab extends MyActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new Panel(this));
    }
 
    class Panel extends View {
        public Panel(Context context) {
            super(context);
        }
 
        @Override
        public void onDraw(Canvas canvas) {
        	
        	// draws a mock map arbitrarily selected from a bigger one.
        	// the real implementation should draw a vectorial map based
        	// on the nodes we select from the database based on the 
        	// location of the movil...
     
        	Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.map);
            canvas.drawBitmap(bitmap, 1, 1, null);
            
            // from now on, we'll draw several circles, based on their xy coordinates. 
            // none of these points are of special interest right now, but they are
            // drawn as a proof of concept. they may be used to represent several 
            // things as towns, filling stations, and other points of interest for
            // the traveler
            // right nexto to the circle, we'll write (draw, really) its description 
     
            CartesianConverter cc = getCartesianConverter( bitmap );
            
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            paint.setTextSize(8);
            float RADIUS = 2; 
            int xy[];
            
            for(Vertice v : ruta.getRuta() ) {
            	
            	xy = cc.getXY(v);
            	paint.setColor(Color.BLUE);
            	canvas.drawCircle(xy[0],xy[1],RADIUS,paint);
                paint.setColor(Color.BLACK);
                canvas.drawText(v.getNombre(),xy[0],xy[1]+5, paint);
                
            }
            
        }

		private CartesianConverter getCartesianConverter(Bitmap b) {
			
            return (CartesianConverter) new CartesianConverter().
				latUpLeft(-31.05764). 			// La Falda  	y=0
				longUpLeft(-64.507141). 		//  "   "    	x=0
				latDownRight(-34.538812).		// Buenos Aires y=250
				longDownRight(-58.475763).		//    "     "	y=600
				imgHeight(b.getHeight()).
				imgWidht(b.getWidth()).
				build();		
            
		}
		
    }
    
}
