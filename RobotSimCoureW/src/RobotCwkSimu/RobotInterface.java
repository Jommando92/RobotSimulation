//still have an error with i dont understand

package RobotCwkSimu;

import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.invoke.VarHandle;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JFileChooser;

public class RobotInterface extends Application {

  private Scanner s;
  private RobotArena myArena;
  private Text arenaText;

  public RobotInterface() {
    s = new Scanner(System.in);
    myArena = new RobotArena(25, 10);
    arenaText = new Text();

    char ch = ' ';
    do {
      System.out.print(
        "Enter (A)dd Robot, get (I)nformation, (M)ove Robots, (D)isplay Arena, a(N)imation, (C)reate new Arena,(S)ave or (L)oad Arena, or e(X)it > "
      );
      ch = s.next().charAt(0);
      s.nextLine();
      switch (ch) {
        case 'A':
        case 'a':
          myArena.addRobot();
          break;
        case 'I':
        case 'i':
          System.out.print(myArena.toString());
          break;
        case 'M':
        case 'm':
          myArena.moveAllRobots();
          doDisplay();
          System.out.print(myArena.toString());
          break;
        case 'D':
        case 'd':
          doDisplay();
          break;
        case 'N':
        case 'n':
          animateRobots(10); // Add this option to move all robots 10 times with animation
          break;
        case 'C':
        case 'c':
          createNewArena();
          break;
        case 'X':
        case 'x':
          ch = 'X';
          break;
        case 'S':
        case 's':
          save();
          break;
        case 'L':
        case 'l':
          load();
          break;
        default:
          System.out.println("Invalid option");
      }
    } while (ch != 'x' && ch != 'X');
  }

  @Override
  public void start(Stage primaryStage) {
    myArena = new RobotArena(15, 10);

    Button addRobotButton = new Button("Add Robot");
    Button displayButton = new Button("Display Arena");

    addRobotButton.setOnAction(e -> {
      myArena.addRobot();
      doDisplay();
    }); // Add this line to load the arena state from a file

    displayButton.setOnAction(e -> doDisplay());

    GridPane grid = new GridPane();
    grid.add(addRobotButton, 0, 0);
    grid.add(displayButton, 1, 0);

    arenaText = new Text();
    grid.add(arenaText, 0, 1, 2, 1);

    Scene scene = new Scene(grid, 300, 200);

    primaryStage.setTitle("Robot Simulation");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  void doDisplay() {
    // Create a StringBuilder to build the text representation of the arena
    StringBuilder displayText = new StringBuilder();

    // Iterate over the arena and append each character to the StringBuilder
    for (int i = 0; i < myArena.getHeight(); i++) {
      for (int j = 0; j < myArena.getWidth(); j++) {
        displayText.append(myArena.getRobotAt(j, i) != null ? 'R' : ' ');
      }
      displayText.append("\n");
    }

    // Set the StringBuilder content to the Text component
    arenaText.setText(displayText.toString());
  }

  void createNewArena() {
    System.out.print("Enter the new x size of the arena: ");
    int newXSize = s.nextInt();
    System.out.print("Enter the new y size of the arena: ");
    int newYSize = s.nextInt();
    myArena = new RobotArena(newXSize, newYSize);
  }

  void animateRobots(int moves) {
    for (int i = 0; i < moves; i++) {
      myArena.moveAllRobots();
      doDisplay();
      System.out.print(myArena.toString());
    }
  }

  public void save() {
    JFileChooser fileChooser = new JFileChooser();
    int result = fileChooser.showSaveDialog(null);

    if (result == JFileChooser.APPROVE_OPTION) {
      File selectedFile = fileChooser.getSelectedFile();

      try (
        ObjectOutputStream oos = new ObjectOutputStream(
          new FileOutputStream(selectedFile)
        )
      ) {
        oos.writeObject(myArena);
        System.out.println("Arena saved successfully.");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public void load() {
    JFileChooser fileChooser = new JFileChooser();
    int result = fileChooser.showOpenDialog(null);

    if (result == JFileChooser.APPROVE_OPTION) {
      File selectedFile = fileChooser.getSelectedFile();

      try (
        ObjectInputStream ois = new ObjectInputStream(
          new FileInputStream(selectedFile)
        )
      ) {
        myArena = (RobotArena) ois.readObject();
        System.out.println("Arena loaded successfully.");
      } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    launch(args);
    RobotInterface s = new RobotInterface();
    s.save(); // Add this line to save the arena state to a file
    s.load(); // Add this line to load the arena state from a file
  }
}
