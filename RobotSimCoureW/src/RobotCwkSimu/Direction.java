package RobotCwkSimu;

import java.util.concurrent.ThreadLocalRandom;

public enum Direction {
  NORTH,
  EAST,
  SOUTH,
  WEST;

  // Enums are implicitly final and immutable

  // Static values for optimization
  private static final Direction[] VALUES = values();
  private static final int SIZE = VALUES.length;

  // Thread-safe random number generator
  private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

  // Get the next direction in a circular manner
  public Direction nextDirection() {
    return VALUES[(this.ordinal() + 1) % SIZE];
  }

  // Get a random direction
  public static Direction randomDirection() {
    return VALUES[RANDOM.nextInt(SIZE)];
  }
}
