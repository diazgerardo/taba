package ar.com.scriptorum.taba.cartografia;

/**
 * 
 * 	Instances of this class have to be initialized by one side with the coords of a geographical rectangle, 
 * 	and with the dimension of the screen where points are going to be drawn on the other hand
 * 
 *  Once the initialization has been done, the methods getX and getY will be able to determine which points
 *  in the image are correspondents to the latitud/longitud pair for that same point in reality
 *   
 * 	@author gd
 *
 */
public class CoordConverter {

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

	public CoordConverter latUpLeft(double latUpLeft) {

		this.latUpLeft = latUpLeft;
		return this;
		
	}

	public CoordConverter longUpLeft(double longUpLeft) {
		
		this.longUpLeft = longUpLeft;
		return this;
		
	}

	public CoordConverter latDownRight(double latDownRigth) {
		
		this.latDownRigth = latDownRigth;
		return this;
		
	}

	public CoordConverter longDownRight(double longDownRight) {
		
		this.longDownRight = longDownRight;
		return this;
		
	}

	public int getX(double latitude) {
		
		validateState();
		// TODO delegate this calculus to Cartesian as there are a number 
		// of considerations to take into account 
		return (int) ((height / (latUpLeft + latDownRigth)) * latitude);
		
	}

	private void validateState() {

	}

	public int getY(double longitude) {
		
		validateState();
		// TODO delegate this calculus to Cartesian as there are a number 
		// of considerations to take into account 
		return (int) ((width / (longUpLeft + longDownRight)) * longitude);
		
	}
	
}