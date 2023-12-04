




/**
 * !!HitBot.java
 * is a hitbot which counts the number of times it is hit by a robot
 */

package simulationOfRobots;

/**
 * @author Jumar Quinio Mesicias
 */
public class HitBot extends Robot {

  private int hitCount;

  /**
   *
   */
  public HitBot() {
    // TODO Auto-generated constructor stub
  }

  /**
   * @param hx // x-coordinate
   * @param hy // y-coordinate
   * @param hr // radius
   */
  public HitBot(double hx, double hy, double hr) {
    super(hx, hy, hr);
    hitCount = 0;
    color = 'b';
  }

  /**
   *checkRobot in Arena
   * @param r
   */
  @Override
  protected void checkRobot(RobotArena r) {
    if (r.checkHit(this)) {
      hitCount++;
    }
  }

  /**
   * draw a robot which represents the number of times it is hit
   */

  public void drawRobot(MyCanvas mc) {
    super.drawRobot(mc);
    mc.showInt(hitCount, x, y + radius + 10);
  }

  /**
   * adjustRobot in Arena - move the robot
   * not need here
   */
  @Override
  protected void adjustRobot() {} // do nothing

  /**
   * return the string of HitBot
   */
  protected String getString() {
    return "HitBot";
  }
}
