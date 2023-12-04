/**
 * !!Robot.java
 */
package simulationOfRobots;

/**
 * @author Jumar Quinio Mesicias
 */

public abstract class Robot {

  protected double x, y, radius;
  protected char color;
  protected int RobotCounter = 0;
  protected int RobotID;

  Robot() {
    this(50, 50, 50);
  }

  /**
   * constract a robot with the given x, y, and radius
   * @param x
   * @param y
   * @param radius
   */
  Robot(double x, double y, double radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
    this.color = 'b';
    this.RobotID = RobotCounter++;
  }

  /**
   * return the x-coordinate of the robot
   * @return
   */
  public double getX() {
    return x;
  }

  /**
   * return the y-coordinate of the robot
   */
  public double getY() {
    return y;
  }

  /**
   * return the radius of the robot
   * @return
   */
  public double getRadius() {
    return radius;
  }

  /**
   * set rpbpt position to the given x and y
   */
  public void setPositionXY(double spx, double spy) {
    x = spx;
    y = spy;
  }

  /**
   * Itendity of the robot
   */
  public int getRobotID() {
    return RobotID;
  }

  /**
   * draw a robot in the interface
   */
  public void drawRobot(MyCanvas mc) {
    mc.showCircle(x, y, radius, color);
  }

  protected String getStrType() {
    return "Robot";
  }

  /**
   * return a string representation of the robot
   */
  public String toString() {
    return getStrType() + " " + RobotID + " at (" + x + ", " + y + ")";
  }

  /**
   * method to check if the robot is in the given area a
   * @param a
   */
  protected abstract void checkRobot(RobotArena a);

  /**
   * method to move the robot
   */
  protected abstract void adjustRobot();

  /**
   * is the robot in the given area a hitting the obstacle
   * @param xa // x-coordinate of the robot
   * @param xo // x-coordinate of the obstacle
   * @param xi // radius of the obstacle
   * @return true if the robot is hitting the obstacle
   */
  protected boolean hittingRobot(double xa, double xo, double xi) {
    return (
      (xa - x) * (xa - x) + (xo - y) * (xo - y) < (xi + radius) * (xi + radius)
    );
  } // end of hittingObstacle

  /**
   * is the Bobot hitting another robot
   * @param hRobot - the other robot
   * @return true if the robot is hitting the other robot
   */

  protected boolean hittingRobot(Robot hRobot) {
    return hittingRobot(hRobot.getX(), hRobot.getY(), hRobot.getRadius());
  } // end of hittingRobot

  protected boolean hittingObstacle(double xa, double xo, double xi) {
    return (
      (xa - x) * (xa - x) + (xo - y) * (xo - y) < (xi + radius) * (xi + radius)
    );
  } // end of hittingObstacle
}
