package RobotCwkSimu;

//still have an error with i don't understand

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.invoke.VarHandle;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class RobotInterface {

private Scanner s;
private RobotArena myArena;

public RobotInterface() {
  s = new Scanner(System.in);
  myArena = new RobotArena(20, 6);

  char ch = ' ';
  do {
    System.out.print(
      "Enter (A)dd Robot, get (I)nformation, (M)ove Robots, (D)isplay Arena, a(N)imation, (C)reate new Arena,(S)ave and (L)oad Arena, or e(X)it > "
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
  } while (ch != 'X');

  s.close();
}

public void save() {
  JFileChooser fileChooser = new JFileChooser();
  int result = fileChooser.showSaveDialog(null);

  if (result == JFileChooser.APPROVE_OPTION) {
    File selectedFile = fileChooser.getSelectedFile();

    try (FileWriter writer = new FileWriter(selectedFile)) {
      //method to write a human-readable representation
      writer.write(myArena.toString());
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
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println(
        "IOException during deserialization: " + e.getMessage()
      );
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      System.out.println(
        "ClassNotFoundException during deserialization: " + e.getMessage()
      );
    }
  }
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

void doDisplay() {
  ConsoloCanvas c = new ConsoloCanvas(
    myArena.getWidth(),
    myArena.getHeight(),
    "30810845"
  );
  myArena.showRobots(c);
  System.out.println(c.toString());
}

public static void main(String[] args) {
  RobotInterface r = new RobotInterface();
}
}
