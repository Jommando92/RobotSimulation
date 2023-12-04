/**
 * !!ObstacleR.java
 * obstacle for the robots
 */
package simulationOfRobots;

/**
 * @author Jumar Quinio Mesicias
 */
public class obstacleR extends Robot {

  /**
   *
   */
  public obstacleR() {
    // TODO Auto-generated constructor stub
  }

  /**
   * @param ox // x-coordinate
   * @param oy // y-coordinate
   * @param or // radius
   */ 
  public obstacleR(double ox, double oy, double or) {
     super(ox, oy, or);
     color = 'g';
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
    return "ObstacleR"; // return the name of the robot
  }
}

