package Robot_GUI_Simulation;

/**
 *
 * @author Jumar Quinio Mesicias
 *
 * BRokenRobot is a subclass of Robot that acts as a static obstacle in the arena.
 * It provides navigational challenges for other robots.
 *
 *
 */


public class BrokenRobot extends Robot {
	private static final long serialVersionUID = 1L;



	// public BrokenRobot() {
	// 	// TODO Auto-generated constructor stub
	// }

	/**
	 * @param ix
	 * @param iy
	 * @param ir
	 */
    public BrokenRobot(double ix, double iy, double ir, double ia, double is) {
         super(ix, iy, ir, ia, is);
         col = 'k';
         rAngle = ia;
         rSpeed = is;
	}


	@Override
	protected void checkRobot(RobotArena b) {

	}

	@Override
	protected void adjustRobot() {

	}
	protected String getStrType() {
		return "Brokenrobot";
	}
}
