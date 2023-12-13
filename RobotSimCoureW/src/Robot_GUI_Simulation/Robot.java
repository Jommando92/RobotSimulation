package Robot_GUI_Simulation;

/**
 *
 */

import java.io.Serializable;

/**
 * @author Jumar Quinio Mesicias
 *
 *
 *
 *
 * 
 *         this Robot is the parent class of all the other Robots in the arena
 */
public abstract class Robot implements Serializable {

  private static final long serialVersionUID = 1L;
  protected double x, y, rad; // position and size of Robot
  protected char col; // used to set colour
  static int robotCounter = 0; // used to give each Robot a unique identifier
  protected int RobotID; // unique identifier for item
  protected double rAngle, rSpeed; // angle and speed of travel

  Robot() {
    this(100, 100, 10, 10, 3);
  }

  /**
   * construct a Robot of radius ir at ix,iy
   *
   * @param ix
   * @param iy
   * @param ir
   */
  Robot(double ix, double iy, double ir, double ia, double is) {
    x = ix;
    y = iy;
    rad = ir;
    RobotID = robotCounter++; // set the identifier and increment class static
    col = 'w';
    rAngle = ia;
    rSpeed = is;
  }

  /**
   * return x position
   *
   * @return
   */
  public double getX() {
    return x;
  }

  /**
   * return y position
   *
   * @return
   */
  public double getY() {
    return y;
  }

  /**
   * return radius of Robot
   *
   * @return
   */
  public double getRad() {
    return rad;
  }

  /**
   * set the Robot at position nx,ny
   *
   * @param nx
   * @param ny
   */
  public void setXY(double nx, double ny) {
    x = nx;
    y = ny;
  }

  /**
   * return the identity of Robot
   *
   * @return
   */
  public int getID() {
    return RobotID;
  }

  /**
   * draw a Robot into the interface bi
   *
   * @param bi
   */
  public void drawRobot(MyCanvas mc) {
    double ang = rAngle * Math.PI / 180; // put angle in radians

    mc.showCircle(x, y, rad, col); // draw Robot body

    double x1 = x + (rad * Math.cos(ang + Math.PI / 4)); // calculate corners of Robot
    double y1 = y + (rad * Math.sin(ang + Math.PI / 4));

    double x2 = x + (rad * Math.cos(ang + 3 * Math.PI / 4)); // calculate corners of Robot
    double y2 = y + (rad * Math.sin(ang + 3 * Math.PI / 4));

    double x3 = x + (rad * Math.cos(ang - Math.PI / 4));
    double y3 = y + (rad * Math.sin(ang - Math.PI / 4));

    double x4 = x + (rad * Math.cos(ang - 3 * Math.PI / 4));
    double y4 = y + (rad * Math.sin(ang - 3 * Math.PI / 4));

    // adjust the angle of the lines to the Robot angle of travel
    mc.showLineWheels(x1, y1, x2, y2); // draw Robot wheels
    mc.showLineWheels(x3, y3, x4, y4); // draw Robot Wheels
  }

  protected String getStrType() {
    return "Robot";
  }

  /**
   * return string describing Robot
   */
  public String toString() {
    return getStrType() + " at " + Math.round(x) + ", " + Math.round(y);
  }

  /**
   * abstract method for checking a Robot in arena b
   *
   * @param b
   */
  protected abstract void checkRobot(RobotArena b);

  /**
   * abstract method for adjusting a Robot (?moving it)
   */
  protected abstract void adjustRobot();

  /**
   * is Robot at ox,oy size or hitting this Robot
   *
   * @param ox
   * @param oy
   * @param or
   * @return true if hitting
   */
  public boolean hitting(double ox, double oy, double or) {
    return (ox - x) * (ox - x) + (oy - y) * (oy - y) < (or + rad) * (or + rad);
  } // hitting if dist between Robot and ox,oy < ist rad + or

  /**
   * is Robot hitting the other Robot
   *
   * @param oRobot - the other Robot
   * @return true if hitting
   */
  public boolean hitting(Robot oRobot) {
    return hitting(oRobot.getX(), oRobot.getY(), oRobot.getRad());
  }
}
