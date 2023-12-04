

/**
 * !!RobotInterface.java
 */
package simulationOfRobots;
/**
 * @author Jumar Quinio Mesicias
 */

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RobotInterface extends Application {

  private MyCanvas mc;
  private AnimationTimer timer;
  private VBox rtPaneBox;
  private RobotArena ra;

  /**
   * Function to show in the interface in  box the information of the robot
   */
  private void showAbout() {
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("About");
    alert.setHeaderText("Robot Simulation Program");
    alert.setContentText(
      "This program simulates a robot moving in an arena. \n\nAuthor: Jumar Quinio Mesicias"
    );
    alert.showAndWait();
  }

  /**
   * set up the mouse event - when the mouse is clicked, the robot will move to the mouse position
   *@param canvas mc
   */
  void setMouseEvents(Canvas canvas) {
    canvas.addEventHandler(
      MouseEvent.MOUSE_PRESSED,
      new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
          ra.setSteadyRobot(e.getX(), e.getY());
          drawMap();
          drawStatus();
        }
      }
    );
  }

  /**
   * set up menu of commands for the GUI
   * @return menuBar
   */

  MenuBar setMenu() {
    MenuBar menuBar = new MenuBar();
    Menu mFile = new Menu("File");
    MenuItem mExit = new MenuItem("Exit");
    mExit.setOnAction(
      new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
          timer.stop();
          System.exit(0);
        }
      }
    );
    mFile.getItems().addAll(mExit);
    Menu mHelp = new Menu("Help");
    MenuItem mAbout = new MenuItem("About");
    mAbout.setOnAction(
      new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
          showAbout();
        }
      }
    );
    mHelp.getItems().addAll(mAbout);
    menuBar.getMenus().addAll(mFile, mHelp);
    return menuBar;
  }

  /**
   * set up the horizontal box for the buttons
   *@return
   */
  private HBox setButtons() {
    Button btnStart = new Button("Start");
    btnStart.setOnAction(
      new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
          timer.start();
        }
      }
    );
    Button btnStop = new Button("Stop");
    btnStop.setOnAction(
      new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
          timer.stop();
        }
      }
    );
    //  Button btnReset = new Button("Reset");
    //  btnReset.setOnAction(new EventHandler<ActionEvent>() {
    //       @Override
    //       public void handle(ActionEvent e) {
    //            robot.reset();
    //            drawMap();
    //            drawStatus();
    //       }
    //  });
    //  Button btnExit = new Button("Exit");
    //  btnExit.setOnAction(new EventHandler<ActionEvent>() {
    //       @Override
    //       public void handle(ActionEvent e) {
    //            timer.stop();
    //            System.exit(0);
    //       }
    //  });
    Button btnAdd = new Button("Add Robot");
    btnAdd.setOnAction(
      new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
          ra.addRobot();
          drawMap();
        }
      }
    );
    //  Button btnSave = new Button("Save");
    //  btnSave.setOnAction(new EventHandler<ActionEvent>() {
    //       @Override
    //       public void handle(ActionEvent e) {
    //            robot.save();
    //       }
    //  });
    //  Button btnLoad = new Button("Load");
    //  btnLoad.setOnAction(new EventHandler<ActionEvent>() {
    //       @Override
    //       public void handle(ActionEvent e) {
    //            robot.load();
    //            drawMap();
    //            drawStatus();
    //       }
    //  });
    return new HBox(
      new Label("Run: "),
      btnStart,
      btnStop,
      new Label("Add: "),
      btnAdd
    );
  }

  /**
   * Show the Score of robot touching the target
   * @param x
   * @param y
   * @param score
   */

  public void showScore(double x, double y, int score) {
    mc.showText(Integer.toString(score), x, y);
  }

  /**
   * Draw the map for the robot
   */

  public void drawMap() {
    mc.clearCanvas(); // set color to another color
    ra.drawArena(mc); // draw the arena
  }

  /**
   * show the status of the robot in the interface
   */
  public void drawStatus() {
    rtPaneBox.getChildren().clear(); // clear rtpane
    ArrayList<String> allBs = ra.describeAll();
    for (String s : allBs) {
      Label l = new Label(s); // turn description into a label
      rtPaneBox.getChildren().add(l); // add label
    }
  }

  /**
   * set up the interface
   * @param primaryStage
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    // TODO Auto-generated method stub
    primaryStage.setTitle("Jumar Quinio Robot Simulation");
    BorderPane bp = new BorderPane(); // set up the border pane
    bp.setPadding(new Insets(10, 20, 10, 20)); // set padding of the border pane
    bp.setTop(setMenu()); // set the menu bar on the top of the border pane
    Group root = new Group(); // set up the group
    Canvas canvas = new Canvas(600, 600); // set up the canvas with size 300, 500 pixels
    root.getChildren().add(canvas); // add canvas to the group
    bp.setLeft(canvas); // set the canvas on the left of the border pane
    mc = new MyCanvas(canvas.getGraphicsContext2D(), 600, 600); // set up the canvas with size 400, 600 pixels
    setMouseEvents(canvas); // set up the mouse event
    ra = new RobotArena(600, 600); // set up the robot arena with size 500, 500 pixels
    drawMap(); // draw the map
    timer =new AnimationTimer() {
          public void handle(long currentNanoTime) {
          ra.checkRobots(); // check the robot
          ra.adjustRobots(); // adjust the robot
          drawMap();
          drawStatus();
        }
      };
    rtPaneBox = new VBox();
    rtPaneBox.setAlignment(Pos.TOP_LEFT); // set the alignment of the box
    rtPaneBox.setPadding(new Insets(5, 75, 75, 5)); // set the padding of the box
    bp.setRight(rtPaneBox); // set the box on the right of the border pane
    bp.setBottom(setButtons()); // set the buttons on the bottom of the border pane

    Scene scene = new Scene(bp, 700, 700); // set up the scene size
    bp.prefHeightProperty().bind(scene.heightProperty()); // set the height of the border pane
    bp.prefWidthProperty().bind(scene.widthProperty()); // set the width of the border pane

    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * @param args the command line arguments
   */

  public static void main(String[] args) {
    Application.launch(args);
  }
}
