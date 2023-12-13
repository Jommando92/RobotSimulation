package Robot_GUI_Simulation;

/**
 *
 */

/**
 * @author Jumar Quinio Mesicias
 *
 *
 *
 *
 *         The WhiskerRobot is the robot that will move after detecting anything
 *         blocking its path, using its whiskers
 */
public class WhiskerBot extends Robot {
	private static final long serialVersionUID = 1L;// private int score;
	private double rAngle;
	private double rSpeed; // angle and speed of travel

	/**
	 * @param ix // x position
	 * @param iy // y position
	 * @param ir // radius
	 * @param ia // angle
	 * @param is // speed
	 */
	public WhiskerBot(double ix, double iy, double ir, double ia, double is) {
		super(ix, iy, ir, ia, is);
		// score = 0;
		col = 'r';
		rAngle = ia;
		rSpeed = is;
	}

	/**
	 * checkRobot in arena
	 *
	 * @param b RobotArena
	 */
	@Override
	protected void checkRobot(RobotArena b) {
		double originalAngle = rAngle;
		rAngle = b.CheckRobotAngle(x, y, rad, rAngle, RobotID); // check for collision with wall or Robot
		if (originalAngle != rAngle) {
			adjustRobot();
		}
	}

	/**
	 * draw Robot and display score
	 */
	@Override
	public void drawRobot(MyCanvas mc) {
		double ang = rAngle * Math.PI / 180; // put angle in radians
		mc.showCircle(x, y, rad, col); // draw Robot body
		drawWheels(mc, ang); // draw Robot wheels
		drawAntennas(mc, ang);
	}

	private void drawWheels(MyCanvas mc, double ang) {
		double x1 = x + (rad * Math.cos(ang + Math.PI / 4)); // calculate corners of Robot
		double y1 = y + (rad * Math.sin(ang + Math.PI / 4));
		double x2 = x + (rad * Math.cos(ang + 3 * Math.PI / 4)); // calculate corners of Robot
		double y2 = y + (rad * Math.sin(ang + 3 * Math.PI / 4));
		double x3 = x + (rad * Math.cos(ang - Math.PI / 4));
		double y3 = y + (rad * Math.sin(ang - Math.PI / 4));
		double x4 = x + (rad * Math.cos(ang - 3 * Math.PI / 4));
		double y4 = y + (rad * Math.sin(ang - 3 * Math.PI / 4));
		// adjust the angle of the lines to the Robot angle of travel
		// adjust the angle of the lines to the Robot angle of travel
		mc.showLineWheels(x1, y1, x2, y2); // draw Robot wheels
		mc.showLineWheels(x3, y3, x4, y4); // draw Robot Wheels
	}

	private void drawAntennas(MyCanvas mc, double ang) {
		// Draw antennas
		double antennaLength = rad * 2; // You can adjust the length of the antennas as needed
		double antennaWidth = 2;
		double antenna1X = x + (antennaLength * Math.cos(ang + Math.PI / 6)); // Adjust angle for antenna
		double antenna1Y = y + (antennaLength * Math.sin(ang + Math.PI / 6));

		double antenna2X = x + (antennaLength * Math.cos(ang - Math.PI / 6));
		double antenna2Y = y + (antennaLength * Math.sin(ang - Math.PI / 6));

		mc.showLine(x, y, antenna1X, antenna1Y, antennaWidth, 'b'); // Draw antenna 1
		mc.showLine(x, y, antenna2X, antenna2Y, antennaWidth, 'b'); // Draw antenna 2

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

	/**
	 * return string defining Robot ... here as target
	 */
	protected String getStrType() {
		return "WhiskerBot";
	}
}
