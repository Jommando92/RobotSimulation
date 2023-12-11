package Robot_GUI_Simulation;

/**
 *
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Jumar Quinio Mesicias
 * Class for Arena of Robots
 */
public class RobotArena implements Serializable {

  private static final long serialVersionUID = 1L;
  private double xSize, ySize; // size of arena
  private ArrayList<Robot> allRobots; // array list of all Robots in arena


  /**
   * construct an arena
   */
  RobotArena() {
    this(500, 400); // default size
  }

  /**
   * construct arena of size xS by yS
   * @param xS
   * @param yS
   */
  RobotArena(double xS, double yS) {
    xSize = xS;
    ySize = yS;
    allRobots = new ArrayList<Robot>(); // list of all Robots, initially empty
    allRobots.add(new GameRobot(xS / 2, yS / 2, 14, 15, 4)); // add game Robot
    allRobots.add(new TargetRobot(xS / 5, yS / 7, 14, 30, 2)); // add target Robot
    allRobots.add(new BeamBot(xS / 4, yS / 2, 14, 270, 3)); // add target Robot
    allRobots.add(new WhiskerBot(xS / 8, yS / 2, 14, 45, 3));
    allRobots.add(new PacManBot(xS/1.2, yS/2, 14, 65, 2));
  }

  /**
   * return arena size in x direction
   * @return
   */
  public double getXSize() {
    return xSize;
  }

  /**
   * return arena size in y direction
   * @return
   */
  public double getYSize() {
    return ySize;
  }

  /**
   * draw all Robots in the arena into interface bi
   * @param bi
   */
  public void drawArena(MyCanvas mc) {
    for (Robot b : allRobots)
      b.drawRobot(mc); // draw all Robots
  }

  // Add this method to RobotArena class
  public ArrayList<Robot> getAllRobots() {
    return allRobots;
  }

  /**
   * check all Robots .. see if need to change angle of moving Robots, etc
   */
  public void checkRobots() {
    for (Robot b : allRobots)
      b.checkRobot(this); // check all Robots
  }

  public void removeRobot(Robot robot) {
    allRobots.remove(robot);
  }




  /**
   * adjust all Robots .. move any moving ones
   */
  public void adjustRobots() {
    for (Robot b : allRobots) b.adjustRobot( );// adjust all Robots
  }


  /**
   * return list of strings defining each Robot
   * @return
   */
  public ArrayList<String> describeAll() {
    ArrayList<String> ans = new ArrayList<String>(); // set up empty arraylist
    for (Robot b : allRobots) ans.add(b.toString()); // add string defining each Robot
    return ans; // return string list
  }


  /**
   * Check angle of Robot ... if hitting wall, rebound; if hitting Robot, change angle
   * @param x				Robot x position
   * @param y				y
   * @param rad			radius
   * @param ang			current angle
   * @param notID			identify of Robot not to be checked
   * @return				new angle
   */
  public double CheckRobotAngle(double x,double y,double rad,double ang,int notID) {
    double ans = ang;
    if (x < rad || x > xSize - rad) ans = 180 - ans;// if Robot hit (tried to go through) left or right walls, set mirror angle, being 180-angle
    if (y < rad || y > ySize - rad) ans = -ans;// if try to go off top or bottom, set mirror angle, being -angle
    for (Robot b : allRobots) if (b.getID() != notID && b.hitting(x, y, rad)
    ) ans = 180 * Math.atan2(y - b.getY(), x - b.getX()) / Math.PI;
    // check all Robots except one with given id
    // if hitting, return angle between the other Robot and this one.

    return ans; // return the angle
  }

  /**
   * check if the target Robot has been hit by another Robot
   * @param target	the target Robot
   * @return 	true if hit
   */
  public boolean checkHit(Robot target) {
    for (Robot b : allRobots) if (
      b instanceof GameRobot && b.hitting(target))
// try all Robots, if GameRobot, check if hitting the target
return true; // if so, return true
return false;
  }

  public void addRobot() {
    allRobots.add(new GameRobot(xSize / 2, ySize / 5, 10, 35, 3));

  }


  /**
   * Load the arena with the set up in the given file
   * @param fname
   * @return 0 if successful
   */
  public int loadFile(String fname) {
    int status = 0;
    allRobots.clear();
    try {
      FileInputStream fileInputStream = new FileInputStream(fname); // set up input stream
      ObjectInputStream inputStream = new ObjectInputStream(fileInputStream); // and file
      RobotArena A = (RobotArena) inputStream.readObject(); // read whole object
      this.xSize = A.xSize; // load into arena
      this.ySize = A.ySize;
      this.allRobots = A.allRobots;
      inputStream.close(); // close...
      fileInputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
      status = 1;
    } catch (ClassNotFoundException c) {
      c.printStackTrace();
      status = 2;
    }
    return status;
  }

  /**
   * save the arena and its contents into the named file
   * @param fname
   * @return 0 if ok
   */
  public int saveFile(String fname) {
    int status = 0;
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(fname); // setup
      ObjectOutputStream outputStream = new ObjectOutputStream(
        fileOutputStream
      );
      outputStream.writeObject(this); // write arena and contents
      outputStream.close(); // close
      fileOutputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
      status = 1;
    }
    return status;
  }
}
