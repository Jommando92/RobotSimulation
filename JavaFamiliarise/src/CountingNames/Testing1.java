package CountingNames;

import javax.swing.JOptionPane;

public class Testing1 {

    public static void main(String[] args) {
        // Example of using the methods
        String inputNames = JOptionPane.showInputDialog("Enter names separated by spaces:");
        
        int count = countNames(inputNames);
        System.out.println("Total names: " + count);

        String[] nameArray = extractNames(inputNames);
        System.out.println("Individual names:");
        for (String name : nameArray) {
            System.out.println(name);
        }
    }

    static int countNames1(String names) {
        int count = 0;
        int index = 0;
        while (index < names.length()) {
            // Find the next space or the end of the string
            int spaceIndex = names.indexOf(' ', index);
            if (spaceIndex == -1) {
                // No more spaces found, increment count by 1
                count++;
                break;
            } else {
                // Increment count and update index to search from after the space
                count++;
                index = spaceIndex + 1;
            }
        }
        return count;
    }

    static String nextName(String names, int startIndex) {
        int spaceIndex = names.indexOf(' ', startIndex);
        if (spaceIndex == -1) {
            // If no more spaces are found, return the substring from startIndex to the end
            return names.substring(startIndex);
        } else {
            // Return the substring from startIndex to the spaceIndex
            return names.substring(startIndex, spaceIndex);
        }
    }

    static String[] extractNames(String names) {
        int numPeople = countNames1(names);
        String[] nameArray = new String[numPeople];
        int currentIndex = 0;

        for (int i = 0; i < numPeople; i++) {
            // Call nextName to get the next name and update currentIndex
            String next = nextName(names, currentIndex);
            currentIndex += next.length() + 1; // +1 to skip the space
            nameArray[i] = next;
        }

        return nameArray;
    }

    static int countNames(String names) {
        String[] nameArray = names.split(" ");
        return nameArray.length;
    }
}
