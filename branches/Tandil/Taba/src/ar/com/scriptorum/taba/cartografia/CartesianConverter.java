package ar.com.scriptorum.taba.cartografia;

import ar.com.scriptorum.taba.abstractions.Vertice;

/**
 * 
 * @author gd
 *	
 */
public class CartesianConverter extends CoordConverter {
	
	public CartesianConverter() {}
	
	@Override
	public int getY(double latitude) {
		
		// TODO this formula only works for quadrant (A), please take a look at the file
		//      doc/dev/cartografia/cuadrantes.jpg for more details..
		validate();
		
		double totalDiffLat = getLatUpLeft() - getLatDownRight();
		double currDiffLat = getLatUpLeft() - latitude;
		return (int) ((getHeight()/totalDiffLat)*currDiffLat);
		
	}

	@Override
	public int getX(double longitude) {
		
		// TODO this formula only works for quadrant (A), please take a look at the file
		//      doc/dev/cartografia/cuadrantes.jpg for more details..
		validate();
		double totalDiffLong = getLongUpLeft() - getLongDownRight();
		double currDiffLong = getLongUpLeft() - longitude;
		return (int) ((getWidth()/totalDiffLong)*currDiffLong);

	}

	@Override
	public int[] getXY(Vertice v) {
		
		int y = getY(v.getLatitud().doubleValue());
		int x = getX(v.getLongitud().doubleValue());
		return new int[]{ x, y };
		
	}

	@Override
	public void validate() {
		// nothing to do right now
	}

	@Override
	public CartesianConverter build() {
		
		return this;
	}

}
