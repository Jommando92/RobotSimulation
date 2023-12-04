package RobotsTerminal;

import java.util.ArrayList;
import java.util.Random;

public class RArena {

  private int width;
  private int height;
  private ArrayList<Robot> robots;
  private Random randomGenerator;
  private static final int MIN_POSITION = 2;

  public RArena(int width, int height) {
    this.width = width;
    this.height = height;
    this.robots = new ArrayList<>();
    this.randomGenerator = new Random();
  }

  public void addRobot() {
    int x = randomGenerator.nextInt(width - MIN_POSITION * 2) + MIN_POSITION;
    int y = randomGenerator.nextInt(height - MIN_POSITION * 2) + MIN_POSITION;
    Robot robot = new Robot(x, y, Direction.randomDirection());
    robots.add(robot);
  }

  public void showRobots(ConsoleCanvas c) {
    for (Robot robot : robots) {
      robot.displayRobot(c);
    }
  }

  public Robot getRobotAt(int x, int y) {
    try {
      for (Robot robot : robots) {
        if (robot.isHere(x, y)) {
          return robot;
        }
      }
    } catch (Exception e) {
      // Handle the exception (e.g., log or return null)
      return null;
    }
    return null;
  }

  public boolean canMoveHere(int x, int y) {
    if (x < 1 || x >= width - 1 || y < 1 || y >= height - 1) {
      return false;
    }
    Robot robotAtPosition = getRobotAt(x, y);
    return robotAtPosition == null;
  }

  public void moveAllRobots() {
    for (Robot robot : robots) {
      robot.tryToMove(this);
    }
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    result
      .append("Arena Size: ")
      .append(width)
      .append(" x ")
      .append(height)
      .append("\n");
    for (Robot robot : robots) {
      result.append(robot.toString()).append("\n");
    }
    return result.toString();
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public static void main(String[] args) {
    RArena a = new RArena(20, 10);
    a.addRobot();
    a.addRobot();
    a.addRobot();

    System.out.println(a.toString());
  }
}
