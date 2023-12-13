package Robot_GUI_Simulation;

import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.TextAlignment;

/**
 * @author Jumar Quinio Mesicias
 *
 *
 *
 *      MyCanvas - class to provide a canvas for drawing on and some useful functions
 */
public class MyCanvas {
  int xCanvasSize = 550; // constants for relevant sizes
  int yCanvasSize = 550;
  private GraphicsContext gc;

  /**
   * onstructor sets up relevant Graphics context and size of canvas
   *
   * @param g
   * @param cs
   */
  public MyCanvas(GraphicsContext g, int xcs, int ycs) {
    gc = g;
    xCanvasSize = xcs;
    yCanvasSize = ycs;
  }

  /**
   * get size in x of canvas
   *
   * @return xsize
   */
  public int getXCanvasSize() {
    return xCanvasSize;
  }

  /**
   * get size of xcanvas in y
   *
   * @return ysize
   */
  public int getYCanvasSize() {
    return yCanvasSize;
  }

  /**
   * clear the canvas
   */
  public void clearCanvas() {
    gc.clearRect(0, 0, xCanvasSize, yCanvasSize); // clear canvas
  }

  public void setCanvasSize(int width, int height) {
    xCanvasSize = width;
    yCanvasSize = height;
    gc.getCanvas().setWidth(width);
    gc.getCanvas().setHeight(height);
  }

  /**
   * drawIt ... draws object defined by given image at position and size
   *
   * @param i  image
   * @param x  xposition in range 0..1
   * @param y  yposition in range 0..1
   * @param sz size
   */
  public void drawIt(Image i, double x, double y, double sz) {
    // to draw centred at x,y, give top left position and x,y size
    // sizes/position in range 0..1, so scale to canvassize
    gc.drawImage(i, xCanvasSize * (x - sz / 2), yCanvasSize * (y - sz / 2), xCanvasSize * sz, yCanvasSize * sz);
  }

  /**
   * function to convert char c to actual colour used
   *
   * @param c
   * @return Color
   */
  Color colFromChar(char c) {
    Color ans = Color.BLACK;
    switch (c) {
      case 'y':
        ans = Color.YELLOW;
        break;
      case 'w':
        ans = Color.WHITE;
        break;
      case 'r':
        ans = Color.RED;
        break;
      case 'g':
        ans = Color.GREEN;
        break;
      case 'b':
        ans = Color.BLUE;
        break;
      case 'o':
        ans = Color.ORANGE;
        break;
      case 'p':
        ans = Color.PURPLE;
        break;
      case 'c':
        ans = Color.CYAN;
        break;
      case 'm':
        ans = Color.MAGENTA;
        break;
      case 'k':
        ans = Color.LIGHTGRAY;
        break;
      case 'd':
        ans = Color.ROSYBROWN;
        break;
      case 'l':
        ans = Color.LIGHTBLUE;
        break;
      case 'a':
        ans = Color.LIGHTGREEN;
        break;
      case 't':
        ans = Color.TURQUOISE;
        break;
      case 's':
        ans = Color.SALMON;
        break;
      case 'n':
        ans = Color.BROWN;
        break;
    }
    return ans;
  }

  /**
   * set the fill colour to c
   *
   * @param c
   */
  public void setFillColour(Color c) { // set fill colour
    gc.setFill(c);
  }

  /**
   * show the Robot at position x,y , radius r in colour defined by col
   *
   * @param x   // x position
   * @param y   // y position
   * @param rad // radius
   * @param col // colour
   */
  public void showCircle(double x, double y, double rad, char col) {
    setFillColour(colFromChar(col)); // set the fill colour
    gc.fillArc(x - rad, y - rad, rad * 2, rad * 2, 0, 360, ArcType.ROUND); // fill circle
  }

  /**
   * show line in current colour from x,y to ix,iy with width 5
   *
   * @param x  // start of line
   * @param y  // start of line
   * @param ix // end of line
   * @param iy // end of line
   */

  public void showLineWheels(double x, double y, double ix, double iy) {
    setFillColour(Color.BLACK); // set the fill colour
    gc.setLineWidth(7); // set line width
    gc.strokeLine(x, y, ix, iy); // fill circle
  }

  public void showLine(double x1, double y1, double x2, double y2, double width, char col) {
    gc.setLineWidth(width); // set line width
    gc.strokeLine(x1, y1, x2, y2);
  }

  /**
   * Show Text .. by writing string s at position x,y
   *
   * @param x
   * @param y
   * @param s
   */
  public void showText(double x, double y, String s) {
    gc.setTextAlign(TextAlignment.CENTER); // set horizontal alignment
    gc.setTextBaseline(VPos.CENTER); // vertical
    gc.setFill(Color.WHITE); // colour in white
    gc.fillText(s, x, y); // print score as text
  }

  public void clearCanvas(double x, double y, double w, double h) {
    gc.clearRect(x, y, w, h); // clear canvas
  }

  /**
   * Show Int .. by writing int i at position x,y
   *
   * @param x
   * @param y
   * @param i
   */
  public void showInt(double x, double y, int i) {
    showText(x, y, Integer.toString(i));
  }
}
