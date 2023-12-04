

/**
 * !!SteadyRobot.java
 * robot that moves wher the mouse clicks
 */

package simulationOfRobots;

/**
 * @author Jumar Quinio Mesicias
 *
 */

public class steadyRobot extends Robot {

  /**
   * Set up the SteadyRobot to control by the user mouse
   */
  public steadyRobot() {
    // TODO Auto-generated constructor stub
  }

  /**
   * Set Steadyrobot size sr, st, sx, sy
   * @param sx // x-coordinate
   * @param sy // y-coordinate
   * @param sr // radius
   */
  public steadyRobot(double sx, double sy, double sr) {
    super(sx, sy, sr);
    color = 'r';
    // TODO Auto-generated constructor stub
  }

  /*
   *
   */
  @Override
  protected void checkRobot(RobotArena r) {} // do nothing

  /*
   *
   */
  @Override
  protected void adjustRobot() {} // do nothing

  /**
   *
   */
  protected String getString() {
    return "SteadyRobot";
  }
}
