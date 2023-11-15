package GUIintro;

import javax.swing.JOptionPane;

public class Main {
	
	
public static void main(String[]args) {
	
	String name = JOptionPane.showInputDialog("Enter your name");
	JOptionPane.showMessageDialog(null, "Hello " +name);
	
	// int age = JOptionPane.showInputDialog("Enter your age"); this will be wrong as 
	//JOptionPane is only showing strigs not intiger, to show intigers we need
	// intiger.parseInt(JOptionPane.showInputDialog("Enter your age"));
	int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));
	JOptionPane.showMessageDialog(null,"You are " +age+" years old.");
	
	double height = Double.parseDouble(JOptionPane.showInputDialog("Enter your height"));
	JOptionPane.showMessageDialog(null,"You are " +height+" cm tall.");
	
	
	

}

}
