package CountSs;


import javax.swing.JOptionPane;

/**
 * 
 * @author Jumar
 * Saved, need to use AutoFix to import JOptionPane
 * 
 */
public class Week1Task2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Prompt the user to enter  a string using JOptionPanel dialog
		String aString = JOptionPane.showInputDialog (null, "Enter a String");
		//Counter 0 for the "s" occurrences
		int numberOfS = 0;
		//Loop through each character in the string
		for (int i=0; i<aString.length();i++) {
			if (aString.charAt(i)=='s') numberOfS++;
		}
	// Display the count of 's' characters using another JOptionPane dialog
	JOptionPane.showMessageDialog(null, "The letter 's' appears " + numberOfS + " times.");
	}

}
