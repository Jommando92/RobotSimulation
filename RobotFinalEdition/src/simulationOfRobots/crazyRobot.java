/**
 * !!CrazyRobot.java
 * robot that moves randomly non stop
 */
package simulationOfRobots;

/**
 *  @author Jumar Quinio Mesicias
 */

public class crazyRobot extends Robot {

  double cAngle, cSpeed; // current angle and speed of the robot travel

  /**
   *
   */
  public crazyRobot() {
    // TODO Auto-generated constructor stub
  }

  /**
   * Create the CrazyRobot, size cx, cy, cr, ca, cs moving at angle ca and speed cs
   * @param cx  // x-coordinate
   * @param cy  // y-coordinate   
   * @param cr  // radius
   * @param ca // angle
   * @param cs // speed
   */
  public crazyRobot(double cx, double cy, double cr, double ca, double cs) {
    super(cx, cy, cr);
    cAngle = ca;
    cSpeed = cs;
  }

  /**
   * checkRobot - change angle of the travel if hit wall or another robot
   * @param ra   RobotArena
   */
  @Override
  protected void checkRobot(RobotArena ra) {
    cAngle = ra.checkRobotAngle(x, y, radius, cAngle, RobotID);
  }

  /**
   * adjustRobot - change angle of the travel if hit wall or another robot
   */
  @Override
  protected void adjustRobot() {
    double radAngle = cAngle * Math.PI / 180; // convert to radians the angles
    x += cSpeed * Math.cos(radAngle); // move the robot to new X
    y += cSpeed * Math.sin(radAngle); // move the robot to new Y
    
  }

  /**
   * return string of the robot type
   */
  protected String getStrType() {
    return "CrazyRobot";
  }
}
