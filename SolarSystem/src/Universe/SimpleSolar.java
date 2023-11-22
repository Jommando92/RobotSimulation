package	Universe;

import javafx.scene.image.Image;

/**
 * class for simple solar system, initially with sun and earth
 * @author shsmchlr
 *
 */
public class SimpleSolar {
	private double sunSize = 0.2;					// size sun should be drawn
	private double sunX, sunY;						// position of sun
	private double earthSize = 0.05;
	private double earthAngle;						// angle of earth .. for calculating its position
	private double earthOrbitSize = 0.3; // defines relevant sizes (<1 so that positions in range -0.5 .. +0.5
	private double earthX, earthY; // position of earth
	private double marsSize = 0.05; // size of mars
	private double marsAngle; // angle of mars
	private double marsOrbitSize = 0.4; // orbit size of mars
	private double marsX, marsY; // position of mars
	private Image earth;							// images of earth and sun
	private Image sun;
	private Image mars; // image of mars

	/**
	 * construct simple solar system
	 */
    public SimpleSolar() {
    	earth = new Image(getClass().getResourceAsStream("earth.png"));		// load image of earth
		sun = new Image(getClass().getResourceAsStream("sun.png"));
		mars = new Image(getClass().getResourceAsStream("mars.png")); // load image of sun
    	sunX = 0.5;															// set position of sun
    	sunY = 0.5;
		earthX = 0.2; // set position of earth
		earthY = 0.0;
		marsX = 0.4; // set position of mars
		marsY = 0.4;

	

		
    }
    
	/**
	 * update position of planet(s) at specified angle 
	 * @param angle		angle (time dependent) of planet(s)
	 */
	public void updateSystem(double angle) {
		earthAngle += 0.02;
		earthAngle %= (2*Math.PI);		// keep angle in range 0..2PI
										// set angle of earth appropriately
		marsAngle += 0.01; // set angle of mars appropriately
		marsAngle %= (2 * Math.PI); // keep angle in range 0..2PI
	}
	
	/** 
	 * set sun at position passed
	 * @param x		x position, in canvas coordinates
	 * @param y
	 */
	public void setSystem(MyCanvas mc, double x, double y) {
		sunX = x;
		sunY = y;

		earthX = sunX + 0.2;
		earthY = sunY;

		marsX = sunX + 0.4;
		marsY = sunY;

		mc.getXCanvasSize();
		mc.getYCanvasSize();
	
		
		// note x,y in range 0.. canvassize
	}

	/**
	 * drawImage into canvas, at position x,y relative to sun, but scale the x,y and sz before drawing
	 * @param mc	canvas
	 * @param i		image
	 * @param x		x position		in range -0.5..0.5
	 * @param y		y position
	 * @param sz	size
	 */
	public void drawImage (MyCanvas mc, Image i, double x, double y, double sz) {
		int cs = mc.getXCanvasSize();
		mc.drawImage (i, (x + 0.5) * cs - sz / 2, (y + 0.5) * cs - sz / 2, sz * cs);		// add sun's position to positions then * canvas size
	}
	
	/**
	 * draw system  into specified canvas
	 * @param mc		canvas
	 */
	public void drawSystem (MyCanvas mc) {
		mc.clearCanvas();					// first clear canvas 
		drawImage( mc, sun, 0, 0, sunSize );				// draw sun at 0,0
		// call drawImage to draw earth at position set by earth's angle and orbit size
		double earthX = earthOrbitSize * Math.cos(earthAngle);
		double earthY = earthOrbitSize * Math.sin(earthAngle);
		drawImage(mc, earth, earthX, earthY, earthSize);
		// call drawImage to draw mars at position set by mars's angle and orbit size
		double marsX = marsOrbitSize * Math.cos(marsAngle);
		double marsY = marsOrbitSize * Math.sin(marsAngle);
		drawImage(mc, mars, marsX, marsY, marsSize);
	}

	/**
	 * return information about planets as a string
	 */
	public String toString() {
	  return "Earth at " + earthAngle + " Mars at " + marsAngle;
	}
}
