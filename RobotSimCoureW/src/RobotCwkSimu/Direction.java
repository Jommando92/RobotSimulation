package RobotCwkSimu;

import java.util.Random;

public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    private static final Direction[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public Direction nextDirection() {
        return VALUES[(this.ordinal() + 1) % SIZE];
    }

    public static Direction randomDirection() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}