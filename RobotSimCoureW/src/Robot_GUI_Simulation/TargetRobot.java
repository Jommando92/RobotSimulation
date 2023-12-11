package Robot_GUI_Simulation;

/**
 *
 */


/**
 * @author Jumar Quinio Mesicias
 * The Target Robot which you are aiming at
 */
public class TargetRobot extends Robot {
	private static final long serialVersionUID = 1L;
	private int score;
	private double rAngle;
	private double rSpeed; // angle and speed of travel

	/**
	 * @param ix
	 * @param iy
	 * @param ir
	 */
	public TargetRobot(double ix, double iy, double ir, double ia, double is) {
	super(ix, iy, ir, ia, is);
	score = 0;
     col = 't';
     rAngle = ia;
	rSpeed = is;

	}

	/**
	 * checkRobot in arena
	 * @param b RobotArena
	 */
	@Override
	protected void checkRobot(RobotArena b) {
		rAngle = b.CheckRobotAngle(x, y, rad, rAngle, RobotID); // check for collision with wall or Robot
		if (b.checkHit(this))
			score++; // if been hit, then increase score
	}


	/**
	 * draw Robot and display score
	 */

	public void drawRobot(MyCanvas mc) {

		// super.drawRobot(mc); // Commented out as this draws a circle and was duplicating the my robot
		double ang = rAngle * Math.PI / 180; // put angle in radians
		mc.showCircle(x, y, rad,col ); // draw Robot body
		mc.showInt(x, y, score); // display score
	}
	/**
	 * adjustRobot
	 * for moving the Robot - not needed here
	 */
	@Override
	protected void adjustRobot() {
		double radAngle = rAngle * Math.PI / 180; // convert to radians
		x += rSpeed * Math.cos(radAngle); // move Robot
		y += rSpeed * Math.sin(radAngle);
	}

      // not needed here ..
		@Override
		public void setXY(double nx, double ny) {
			// TODO Auto-generated method stub

		}
	/**
	 * return string defining Robot ... here as target
	 */
	protected String getStrType() {
		return "TargetRobot";
	}
}
