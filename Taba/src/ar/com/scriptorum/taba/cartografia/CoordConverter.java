package ar.com.scriptorum.taba.cartografia;

import ar.com.scriptorum.taba.abstractions.Vertice;

/**
 * 
 * 	Instances inheriting this class have to be initialized by one side with the coords of a geographical rectangle, 
 * 	and with the dimension of the screen where points are going to be drawn on the other hand
 * 
 *  Once the initialization has been done, the methods getX and getY will be able to determine which points
 *  in the image are correspondents to the latitud/longitud pair for that same point in reality
 *   
 * 	@author gd
 *
 */

public abstract class CoordConverter {

	private int height;
	private int width;
	private double latUpLeft;
	private double longUpLeft;
	private double latDownRigth;
	private double longDownRight;

	public CoordConverter imgHeight(int height) {
	
		this.height = height;
		return this;
		
	}

	public CoordConverter imgWidht(int width) {
		
		this.width = width;
		return this;
		
	}

	public CoordConverter yUpLeft(double latUpLeft) {

		this.latUpLeft = latUpLeft;
		return this;
		
	}

	public CoordConverter xUpLeft(double longUpLeft) {
		
		this.longUpLeft = longUpLeft;
		return this;
		
	}

	public CoordConverter yDownRight(double latDownRigth) {
		
		this.latDownRigth = latDownRigth;
		return this;
		
	}

	public CoordConverter xDownRight(double longDownRight) {
		
		this.longDownRight = longDownRight;
		return this;
		
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public double getLatUpLeft() {
		return latUpLeft;
	}

	public double getLongUpLeft() {
		return longUpLeft;
	}

	public double getLatDownRight() {
		return latDownRigth;
	}

	public double getLongDownRight() {
		return longDownRight;
	}

	// TODO delegate this calculus to CartesianConverter as there are a number 
	// of considerations to take into account 
	
	public abstract int getX(double latitude);

	public abstract int getY(double longitude);
	
	public abstract int[] getXY(Vertice v);
	
	public abstract void validate();
	
	public abstract Object build();

	
}