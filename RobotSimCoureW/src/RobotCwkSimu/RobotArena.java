package RobotCwkSimu;

import java.util.ArrayList;
import java.util.Random;

public class RobotArena {
    private int width;
    private int height;
    private ArrayList<Robot> robots;
    private Random randomGenerator;

    public RobotArena(int width, int height) {
        this.width = width;
        this.height = height;
        this.robots = new ArrayList<>();
        this.randomGenerator = new Random();
    }

    public void addRobot(Direction initialDirection) {
        int x = randomGenerator.nextInt(width - 2) + 1;
        int y = randomGenerator.nextInt(height - 2) + 1;
        Robot robot = new Robot(x, y, initialDirection);
        robots.add(robot);
    }

    public void showRobots(ConsoloCanvas c) {
        for (Robot robot : robots) {
            robot.displayRobot(c);
        }
    }

    public Robot getRobotAt(int x, int y) {
        for (Robot robot : robots) {
            if (robot.isHere(x, y)) {
                return robot;
            }
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
        result.append("Arena Size: ").append(width).append(" x ").append(height).append("\n");
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
        RobotArena a = new RobotArena(20, 10);
        a.addRobot(null);
        a.addRobot(null);
        a.addRobot(null);

        System.out.println(a.toString());
    }
}