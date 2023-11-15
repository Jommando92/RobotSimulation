package Week2Task1;

import javax.swing.JOptionPane;

public class SmallestDifference {

	private int[] numbers; // array of integers to analyse
	private int smallest; // smallest difference found
	// you may want to add more private variables

	/**
	 * create class :
	 * 
	 * @param instr - string with series of numbers separated by space
	 */
	SmallestDifference(String instr) {
		StringSplitter S = new StringSplitter(instr, " ");
		numbers = S.getIntegers();
		smallest = Integer.MAX_VALUE; // largest possible integer
	}

	/**
	 * method to search through array and find pairs of adjacent numbers
	 * which are closest in value; note the difference and where in array
	 */
	public void findSmallest() {
		for (int i = 0; i < numbers.length - 1; i++) {
			int diff = Math.abs(numbers[i] - numbers[i + 1]);
			if (diff < smallest) {
				smallest = diff;
			}
		}
		// you write this
	}

	/**
	 * return as string the result of analysis
	 */
	public String toString() {

		return "Smallest difference is "; // you extend this string

	}

	public static void main(String[] args) {
		String userIn = JOptionPane.showInputDialog(null,
				"Enter series of numbers separated by space > ");
		SmallestDifference sd = new SmallestDifference(userIn);
		sd.findSmallest();
		JOptionPane.showMessageDialog(null, sd.toString());

	}
}
