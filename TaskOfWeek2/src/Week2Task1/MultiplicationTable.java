package Week2Task1;

/**
 * class to create a multiplication table
 * 
 * @author shsmchlr
 */
public class MultiplicationTable {

	private int maxNum; // up to maxNum*maxNum
	private int[][] TableData; // 2D array to store these

	/**
	 * create table for 1*1 up to maxN*maxN
	 * 
	 * @param maxN
	 */
	MultiplicationTable(int maxN) {
		// create array of right size, then call makeTable to fill it
		maxNum = maxN; // set maxNum
		TableData = new int[maxNum][maxNum]; // create array
		makeTable(); // populate it

	}

	/**
	 * function to populate the table
	 */
	private void makeTable() {
		for (int i = 1; i <= maxNum; i++) // loop through rows
			for (int j = 1; j <= maxNum; j++) // loop through columns
				TableData[i - 1][j - 1] = i * j;
		// write code to populate the table (hint use nested for loops)
	}

	/**
	 * return string with the table
	 */
	public String toString() {
		String res = "Jumar Multiplication Table" + "\n"; // title for string
		for (int i = 1; i <= maxNum; i++) { // loop through rows
			for (int j = 1; j <= maxNum; j++) // loop through columns
				res = res + TableData[i - 1][j - 1] + "\t"; // add data to string
			res = res + "\n"; // add newline at end of row
		}
		// write code to add data from 2D array to res
		return res;
	}

	public static void main(String[] args) {
		MultiplicationTable mt = new MultiplicationTable(10);
		System.out.print(mt.toString());
	}

}
