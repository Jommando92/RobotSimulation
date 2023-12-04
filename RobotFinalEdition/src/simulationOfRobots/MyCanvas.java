/**
 * @author: Jumar Quinio Mesicias
 */

package simulationOfRobots;

/**
 * !!MyCanvas.java
 *this class is used to create the canvas where the robot will be drawn
 */

import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.TextAlignment;

public class MyCanvas {

  int xCanvas = 515;
  int yCanvas = 515;
  GraphicsContext gc;

  /**
   * contructor of the class sets relevant Graphics Context and canvas size
   * @param gc
   * @param c
   */

  public MyCanvas(GraphicsContext g, int xc, int yc) {
    gc = g;
    xCanvas = xc;
    yCanvas = yc;
  }

  /**
   * get size of x in MyCanvas
   * @return xSize
   */

  public int getXCanvasSize() {
    return xCanvas;
  }

  /**
   * get size of y in xCanvas
   */
  public int getYCanvasSize() {
    return yCanvas;
  }

  /**
   * clear the canvas and set new
   */

  public void clearCanvas() {
     gc.clearRect(0, 0, yCanvas, xCanvas);
  }

  /**
   * drawIt draws the robot on the canvas by calling the drawRobot method
   * @param i    image of the robot
   * @param x    x coordinate of the robot
   * @param y    y coordinate of the robot
   * @param angle    angle of the robot
   * @param sz   size of the robot
   */

  public void drawIt(Image i, double x, double y, double angle, double sz) {
    //to draw the robot at x,y give the top left corner position x,y so that the robot is centered at x,y
    //size /position in range 0-1, so scale to canvas size
    gc.drawImage(
      i,
      xCanvas * (x - sz / 2),
      yCanvas * (y - sz / 2),
      xCanvas * sz,
      yCanvas * sz
    );
  }

  /**
   * function to convert chart c to a color for the robot
   * @param c
   * @return color
   */

  Color colFromChar(char c) {
    Color ans = Color.BLACK;
    switch (c) {
      case 'r':
        ans = Color.RED;
        break;
      case 'g':
        ans = Color.GREEN;
        break;
      case 'b':
        ans = Color.BLUE;
        break;
      case 'y':
        ans = Color.YELLOW;
        break;
      case 'o':
        ans = Color.ORANGE;
        break;
      case 'p':
        ans = Color.PURPLE;
        break;
      case 'w':
        ans = Color.WHITE;
        break;
      case 'k':
        ans = Color.PINK;
        break;
      default:
        ans = Color.BLACK;
        break;
    }
    return ans;
  }

  public void setFillColour(Color c) {
    gc.setFill(c);
  }

  /**
   * show the robot at position x, y, radius with angle and color
   * @param x
   * @param y
   * @param radius
   * @param angle
   * @param c
   */
  public void showCircle(double x, double y, double radius, char c) {
    setFillColour(colFromChar(c));
    gc.fillArc(
      x - radius,
      y - radius,
      radius * 2,
      radius * 2,
      0,
      360,
      ArcType.ROUND
    );
  } //fill circle

  /**
   * show the robot at position x, y, radius, size and color
   * @param x
   * @param y
   * @param radius
   * @param size
   * @param c
   */
  public void showCircle(double x,double y,double radius,double size, char c
  ) {
     gc.fillArc(x - radius, -radius, radius * 2, radius * 2, 0, 360, ArcType.ROUND); //fill circle
  }
    

  /**
   * show Text by writing string str at position x,y
   * @param str
   * @param x
   * @param y
   */
  public void showText(String s, double x, double y) {
    gc.setTextAlign(TextAlignment.CENTER); //set text to be centered
    gc.setTextBaseline(VPos.CENTER); //set text to be centered
    gc.setFill(Color.BLACK); //set text color
    gc.fillText(s, x, y); //draw text
  }

  /**
   * show Int by Writting int i at position x,y
   * @param i
   * @param x
   * @param y
   */
  public void showInt(int i, double x, double y) {
    showText(Integer.toString(i), x, y);
  }
}
