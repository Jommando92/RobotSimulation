package Week2Task1;

/**
 * Class to illustrate Java, 
 * Of a car, which can be commanded to travel at a given speed for a certain time
 * It reports how far the car has travelled.
 * @author shsmchlr
 *
 */
public class Car {
	private int distanceTravelled = 0;		// for distance travelled
	/**
	 *  constructor to set up car
	 */
	Car() {
		distanceTravelled = 0;
	}
	/**
	 * move the car at the given speed for the specified time
	 * @param speed
	 * @param time
	 */
	public void move (int speed, int time) {
		distanceTravelled += speed * time;
	}
	/**
	 * return as String the relevant information, namely how far travelled.
	 */
	public String toString() {
		return "Car has travelled "+distanceTravelled;
	}
	/**
	 * main function
	 * @param args
	 */
	public static void main(String[] args) {
		Car myCar = new Car();			// create car
		myCar.move(5, 5);				// move at speed 5 for time 5
		myCar.move(15, 10);
		myCar.move(30, 15);
		System.out.println(myCar.toString());	// report distance travelled
	}
}
