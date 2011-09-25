package ar.com.scriptorum.taba.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class FourthTab extends Activity {
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
     
        	Bitmap _scratch = BitmapFactory.decodeResource(getResources(), R.drawable.map);
            canvas.drawBitmap(_scratch, 1, 1, null);
            
            // from now on, we'll draw several circles, based on their xy coordinates. 
            // none of these points are of special interest right now, but they are
            // drawn as a proof of concept. they may be used to represent several 
            // things as towns, filling stations, and other points of interest for
            // the traveler
            // right nexto to the circle, we'll write (draw, really) its description 
     
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            paint.setTextSize(10);
            float RADIUS = 3; 
            float[][] xy = {{80,20},{25, 60},{90,35},{35, 64},{40,23},{2, 25},{80,60},{35, 50}};
            
            for(int i=0;i<xy.length;i++) {
            	
            	paint.setColor(Color.BLUE);
            	canvas.drawCircle(xy[i][0],xy[i][1],RADIUS,paint);
                paint.setColor(Color.BLACK);
                canvas.drawText(xy[i][0]+"/"+xy[i][1],xy[i][0],xy[i][1]+5, paint);
                
            }
            
        }
    }
}
