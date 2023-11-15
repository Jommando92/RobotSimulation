package RobotCwkSimu;

public class Robot {
    private int x;
    private int y;
    private static int robotCount = 0;
    private int id;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.id = robotCount++;
    }

    public void displayRobot(ConsoloCanvas c) {
        c.showIt(x, y, 'R');
    }

    public void tryToMove(RobotArena arena) {
        // Calculate the next potential position based on the direction
        int newX = x;
        int newY = y;
        switch (direction) {
            case NORTH:
                newY--;
                break;
            case EAST:
                newX++;
                break;
            case SOUTH:
                newY++;
                break;
            case WEST:
                newX--;
                break;
        }

        // Check if the new position is valid
        if (arena.canMoveHere(newX, newY)) {
            // Move to the new position
            x = newX;
            y = newY;
        } else {
            // Change direction to the next one in the NESW sequence
            direction = direction.nextDirection();
        }
    }

    @Override
    public String toString() {
        return "Robot " + id + " is at " + x + ", " + y + " facing " + direction.toString();
    }

    public boolean isHere(int sx, int sy) {
        return (x == sx && y == sy);
    }

    public static Direction generateRandomDirection() {
        return Direction.values()[(int) (Math.random() * Direction.values().length)];
    }
}