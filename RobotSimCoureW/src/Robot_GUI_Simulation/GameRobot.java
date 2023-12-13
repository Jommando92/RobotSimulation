package Robot_GUI_Simulation;

import java.util.Random;

/**
 *
 */

/**
 * @author Jumar Quinio Mesicias
 *
 *
 *
 *
 *
 *
 *
 *        The Game Robot which you are controlling to hit the TargetRobot
 *
 */
public class GameRobot extends Robot {

   private static final long serialVersionUID = 1L;
   private double bAngle, bSpeed; // angle and speed of travel

   /**
    * Create game Robot, size ir ay ix,iy, moving at angle ia and speed is
    *
    * @param ix
    * @param iy
    * @param ir
    * @param ia
    * @param is
    */
   public GameRobot(double ix, double iy, double ir, double ia, double is) {
      super(ix, iy, ir, ia, is);
      bSpeed = is;
      bAngle = ia;
      col = 'b';
      // generate a random angle between 0 and 360
      Random r = new Random();
      bAngle = r.nextDouble() * 360; // Face the robot in that direction with the wheels pointing forward
      rAngle = bAngle;

   }

   /**
    * checkRobot - change angle of travel if hitting wall or another Robot
    *
    * @param arena RobotArena
    */
   @Override
   protected void checkRobot(RobotArena arena) {
      bAngle = arena.CheckRobotAngle(x, y, rad, bAngle, RobotID); // check for collision with wall or Robot

   }

   /**
    * adjustRobot
    * Here, move Robot depending on speed and angle
    */
   @Override
   protected void adjustRobot() {
      double radAngle = bAngle * Math.PI / 180; // put angle in radians
      x = x + bSpeed * Math.cos(radAngle);
      y = y + bSpeed * Math.sin(radAngle);
      // check if Robot has hit a wall and adjust the facing angle
      rAngle = bAngle; // set facing angle to be same as moving angle

   }

   /**
    * return string defining Robot type
    */
   protected String getStrType() {
      return "Game Robot";
   }
}
