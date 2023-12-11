package Robot_GUI_Simulation;

/**
 *
 */

import java.io.File;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * @author Jumar Quinio Mesicias
 * Example with Robots
 */
public class RobotInterface extends Application {
	private MyCanvas mc;
	private AnimationTimer timer;								// timer used for animation
	private VBox rtPane;										// vertical box for putting info
	private RobotArena arena;
    private FileChooser fileChooser; // for selecting files to read/write



	 /**
	  * Function to show a message,
	  * @param TStr		title of message block
	  * @param CStr		content of message
	  */
	private void showMessage(String TStr, String CStr) {
		    Alert alert = new Alert(AlertType.INFORMATION);
		    alert.setTitle(TStr);
		    alert.setHeaderText(null);
		    alert.setContentText(CStr);
		    alert.showAndWait();
	}

	/**
	 * function to show in a box ABout the programme
	 */
	private void showAbout() {
		showMessage("About", "JQM's Robot Simulation, This program was create and edited from a ballsSimulationand transform into robots");			// give text
	}

	 /**
	  * @param canvas
	 * set up the menu of commands for the GUI
	 * @return the menu bar
	 */
	MenuBar setMenu() {
		// initially set up the file chooser to look for cfg files in current directory
	fileChooser = new FileChooser();
	FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Robot Files", "*.cfg");
	fileChooser.getExtensionFilters().add(extFilter);
	fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));


		MenuBar menuBar = new MenuBar();						// create main menu

		Menu mFile = new Menu("File");							// add File main menu
		MenuItem mExit = new MenuItem("Exit");					// whose sub menu has Exit
		mExit.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent t) {					// action on exit is
	        	timer.stop();									// stop timer
		        System.exit(0);									// exit program
		    }
		});
		MenuItem mLoad = new MenuItem("Load");				// whose sub menu has Exit
		mLoad.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent t) {				// action on exit
            	timer.stop();								// stop timer
            	File selectedFile = fileChooser.showOpenDialog(null);		// ask user for file name
            	if (selectedFile != null) {									// if selected
             		if (arena.loadFile(selectedFile.getName()) > 0)		// load try to load
            			showMessage("Error", "Could not load file");
            		else {
            			showMessage ("Message", "File loaded ok");
    		            drawWorld();										// redraw the world
    		            drawStatus();										// indicate where Robots are
            		}
            	}
		    }
		});
		MenuItem mSave = new MenuItem("Save");							// save option
		mSave.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent t) {							// action on save
            	timer.stop();											// stop timer
            	File selectedFile = fileChooser.showSaveDialog(null);	// user selects file
            	if (selectedFile != null) {
            		if ( arena.saveFile(selectedFile.getName()) > 0)	// save the arena
            			showMessage("Error", "Could not save file");
            		else showMessage ("Message", "File saved ok");
            	}
		    }
		});

		mFile.getItems().addAll(mLoad, mSave, mExit);			// add load, save and exit to File menu


		Menu mHelp = new Menu("Help");							// create Help menu
		MenuItem mAbout = new MenuItem("About");				// add About sub men item
		mAbout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	showAbout();									// and its action to print about
            }
		});
		mHelp.getItems().addAll(mAbout);						// add About to Help main item
		menuBar.getMenus().addAll(mFile, mHelp);				// set main menu with File, Help
		return menuBar;											// return the menu
	}

	/**
	 * set up the horizontal box for the bottom with relevant buttons
	 * @return
	 */
	private HBox setButtons() {
	    Button btnStart = new Button("Start");					// create button for starting
	    btnStart.setOnAction(new EventHandler<ActionEvent>() {	// now define event when it is pressed
	        @Override
	        public void handle(ActionEvent event) {
	        	timer.start();									// its action is to start the timer
	       }
	    });

	    Button btnStop = new Button("Pause");					// now button for stop
	    btnStop.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	           	timer.stop();									// and its action to stop the timer
	       }
	    });

	    Button btnAdd = new Button("Another Robot");				// now button for stop
	    btnAdd.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	           	arena.addRobot();								// and its action to stop the timer
	           	drawWorld();
	       }
	    });
	    														// now add these buttons + labels to a HBox
	    return new HBox(new Label("Run: "), btnStart, btnStop, new Label("Add: "), btnAdd);
	}

	/**
	 * Show the score .. by writing it at position x,y
	 * @param x
	 * @param y
	 * @param score
	 */
	public void showScore (double x, double y, int score) {
		mc.showText(x, y, Integer.toString(score));
	}
	/**
	 * draw the world with Robot in it
	 */
	public void drawWorld () {
	 	mc.clearCanvas();						// set beige colour
	 	arena.drawArena(mc);
	}

	/**
	 * show where Robot is, in pane on right
	 */
	public void drawStatus() {
		rtPane.getChildren().clear();					// clear rtpane
		ArrayList<String> allBs = arena.describeAll();
		for (String s : allBs) {
			Label l = new Label(s); 		// turn description into a label
			rtPane.getChildren().add(l);	// add label
		}
	}


	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
	primaryStage.setTitle("Robot Simulation, by JQM");
	BorderPane bp = new BorderPane();
	bp.setPadding(new Insets(10, 20, 10, 20));
	bp.setTop(setMenu());											// put menu at the top
	Group root = new Group();										// create group with canvas
	Canvas canvas = new Canvas( 400, 500 );
	root.getChildren().add( canvas );
	bp.setLeft(root);												// load canvas to left area
	mc = new MyCanvas(canvas.getGraphicsContext2D(), 400, 500);
	arena = new RobotArena(400, 500);								// set up arena
	drawWorld();
	    timer = new AnimationTimer() {									// set up timer
			public void handle(long currentNanoTime) { // and its action when on
				arena.checkRobots(); // check the angle of all Robots
				arena.adjustRobots(); // move all Robots
				drawWorld(); // redraw the world
				drawStatus(); // indicate where Robots are
				// Inside the AnimationTimer's handle method
				for (Robot b : arena.getAllRobots()) {
					if (b instanceof PacManBot) {
						((PacManBot) b).eatGameRobots(arena);
					}
				}
			}

	};

	    	rtPane = new VBox();											// set vBox on right to list items
		rtPane.setAlignment(Pos.TOP_LEFT);								// set alignment
		rtPane.setPadding(new Insets(5, 75, 75, 5));					// padding
 		bp.setRight(rtPane);											// add rtPane to borderpane right

	    bp.setBottom(setButtons());										// set bottom pane with buttons

	    Scene scene = new Scene(bp, 700, 600);							// set overall scene
        bp.prefHeightProperty().bind(scene.heightProperty());
        bp.prefWidthProperty().bind(scene.widthProperty());

        primaryStage.setScene(scene);
        primaryStage.show();


	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    Application.launch(args);			// launch the GUI

	}

}
