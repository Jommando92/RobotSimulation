package	Universe;

import java.util.ArrayList;

import javafx.scene.image.Image;

/**
 * @author shsmchlr
 *
 */
public class SolarSystem {
	private double sunX, sunY, sunSize; // positions of sun
	private double earthX, earthY, earthSize; // position of earth
	private double marsX, marsY, marsSize; // position of mars
	private Image sun; // image of sun
	private Image earth; // image of earth
	private Image mars; // image of mars
	

//    private Planet Earth;
    
    /**
     * constructor for setting up solar system
     */
	public SolarSystem() {   
	
		sun = new Image(getClass().getResourceAsStream("sun.png"));
		earth = new Image(getClass().getResourceAsStream("earth.png"));
		mars = new Image(getClass().getResourceAsStream("mars.png"));
		sunX = 0.5;
	    sunY = 0.5;
		sunSize = 0.2;
		earthX = sunX + 0.3;
		earthY = sunY;
		earthSize = 0.05;
		marsX = sunX + 0.5;
		marsY = sunY;
		marsSize = 0.05;
		

	}

	/**
	 * Calculate the position of each object in system
	 * @param angle	indication of time/angle
	 */
	public void updateSystem(double angle) {
		// set angle of earth appropriately
	} 
	
	/**
	 * draw the system into the given viewer
	 * @param s
	 */
	public void drawSystem(MyCanvas mc) {
		drawImage(mc, sun, 0, 0, sunSize); // draw Sun,
		drawImage(mc, earth, earthX, earthY, earthSize); // draw Earth,
		drawImage(mc, mars, marsX, marsY, marsSize); // draw Mars,
		

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
		mc.drawImage (i, x*cs - sz/2, y*cs - sz/2, sz*cs);		// add sun's position to positions then * canvas size
	}

	/**
	 * return String with info of planet(s) in system
	 */
	public String toString() {
		String s = "";
		return s;
	}

}
