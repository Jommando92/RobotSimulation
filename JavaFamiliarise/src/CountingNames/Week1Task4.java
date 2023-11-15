package CountingNames;

import javax.swing.JOptionPane;

public class Week1Task4 {
	
	static int countNames (String names) {
		int ans = 0;
			// write code here to count number of names .. look for spaces
		return ans;
	}
	
	static String nextName(String names, int sFrom) {
			// write code to find the position in names of the next space after position sFrom
			// or if no space the end of the string
			// return string from names[sFrom] to names[sTo]
		return "";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String names = JOptionPane.showInputDialog(null, "Enter a series of names > ");
		int numPeople = countNames(names);
		System.out.println("Number of names is "+numPeople);
		
		// second stage, create suitable sized array of strings
		// then add code (calling nextName) to populate that array
		// then write code to print the array of strings
		
		// third stage, add code to use the split method and test it
		
	}
}