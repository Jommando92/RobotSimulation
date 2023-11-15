package Initials;


import javax.swing.JOptionPane;

public class Week1Task3 {
    
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog(null, "Enter your full name");
        String initials = name.substring(0, 1);
        // put in here code to scan through string finding initials
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == ' ') {
                initials += name.charAt(i + 1);
            }
        }
        // Are they capital letters? Or first one and ones after space ?
        initials = initials.toUpperCase();
		JOptionPane.showMessageDialog (null, "Your initials are "+initials);
	}

}
