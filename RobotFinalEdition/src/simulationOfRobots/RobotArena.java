

/**
 * RoborArena.java
 *  This class is used to create a robot arena
 */

package simulationOfRobots;

/**
 * @author Jumar Quinio Mesicias
 */

import java.util.ArrayList;

public class RobotArena {

  double SizeX, SizeY; // size of the arena
  private ArrayList<Robot> allRobots; // list of all robots in the arena

  /**
   * Constructor
   */
  RobotArena() {
    this(750, 750); //by default, the arena is 750x750
  }

  /**
   * Constructor with given size
   * @param Sx
   * @param Sy
   */
  RobotArena(double Sx, double Sy) {
    SizeX = Sx;
    SizeY = Sy;
    allRobots = new ArrayList<Robot>(); // create an empty list of robots
    allRobots.add(new crazyRobot(Sx / 5, Sy / 5, 10, 60, 10)); // add a new CrazyRobot to the arena
    allRobots.add(new HitBot(Sx / 5, 20, 5)); // add a new HitBot to the arena
    allRobots.add(new steadyRobot(Sx / 2, Sy - 2, 10)); // add a new SteadyRobot to the arena
    allRobots.add(new obstacleR(Sx / 2, Sy / 4, 10)); // add a new ObstacleR to the arena
    allRobots.add(new obstacleR(2 * Sx / 4, Sy / 2, 20)); // add a new ObstacleR to the arena
    allRobots.add(new obstacleR(3 * Sx / 4, Sy / 2, 20)); // add a new ObstacleR to the arena
  }

  /**
   * return arena size in X direction
   * @return
   */
  public double getSizeX() {
    return SizeX;
  }

  /**
   * return arena size in Y direction
   * @return
   */
  public double getSizeY() {
    return SizeY;
  }

  /**
   * return list of all robots in the arena into the interface ba
   * @return
   */
  public void drawArena(MyCanvas mc) {
    for (Robot r : allRobots) r.drawRobot(mc); // for each robot in the list
  }

  /**
   * check all the robots in the arena if they need to be moved or not
   */
  public void checkRobots() {
    for (Robot r : allRobots) r.checkRobot(this); // for each robot in the list
  }

  /**
   * adjust Robots ... if they are out of the arena, move them back in
   */
  public void adjustRobots() {
    for (Robot r : allRobots) r.adjustRobot(); // for each robot in the list
  }

  /**
   * set Robot in the mouse position
   * @param x
   * @param y
   */
  public void setSteadyRobot(double x, double y) {
    for (Robot r : allRobots) if (r instanceof steadyRobot) r.setPositionXY(
      x,
      y
    ); // robot is set to the mouse-click position
  }

  /**
   * return list of strng defining all robots in the arena
   * @return
   */
  public ArrayList<String> describeAll() {
    ArrayList<String> ans = new ArrayList<String>(); //set up empty list
    for (Robot r : allRobots) ans.add(r.toString()); // for each robot in the list
    return ans; // return the list
  }

  /**
   * Check Angle of Robots . . . if hitting wall, change angle, bounce off, and move
   * @param  x           // x position of the Robot
   * @param y          // y position of the Robot
   * @param angle    // angle of the Robot
   * @param radius  // radius of the Robot
   * @param notID   // check the robot
   * @return    // return the angle of the Robot
   */
  public double checkRobotAngle(
    double x,
    double y,
    double angle,
    double radius,
    int notID
  ) {
    double ans = angle; // set the angle to the Robot
    if (x < radius || x > SizeX - radius) ans = 180 - ans;
    // if the Robot hits the wall, change the angle
    if (y < radius || y > SizeY - radius) ans = -ans;
    // if the Robot hits the top/bottom wall, change the angle
    for (Robot r : allRobots) if (
      r.getRobotID() != notID && r.hittingRobot(x, y, radius)
    ) ans = 180 * Math.atan2(y - r.getY(), x - r.getX()) / Math.PI;
    // check all balls except the one with the given ID
    // if the Robot hits another Robot, change the angle
    return ans; // return the angle
  }

  /**
   * check if the obstacle is hit by the Robot
   * @param Obs   // Obstacle for the robot to hit x Times
   * @return  true if the Robot hits the obstacle
   */
  public boolean checkHit(Robot Obs) {
    boolean ans = false; // set the answer to false
    for (Robot r : allRobots) if (
      r instanceof crazyRobot && Obs.hittingRobot(Obs)
    ) ans = true;
    // if the Robot is CrazyRobot and hits the obstacle, set the answer to true
    return ans; // return the answer
  }

  public void addRobot() {
    allRobots.add(new crazyRobot(SizeX / 2, SizeY / 2, 20, 20, 5)); // add a new CrazyRobot to the arena
  }
}
