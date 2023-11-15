package LogicalOperators;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//logical operator = use to connect tow or more expressions
		//
		//			&& = (AND) both condition must be true
		//			|| = (OR) either one condition must be true
		//			! = (NOT) reverses boolean value of conditions
		
		//int temp = 20;
		
		//if(temp>=20) {
			System.out.println("it is hot outside");
		//}
		//else if(temp<= 10 && temp>=0) {
		//	System.out.println("it is Freezing");
		//}
		//else {
		//	System.out.println("it is warm ouside");
		//
		//}
			
		//Scanner scanner = new Scanner(System.in);
			
		//System.out.println("You are playing a game!!! Press q or Q to quit");
		//String response = scanner.next();
			
		//if(response.equals("q") || response.equals("Q")) {
		//	System.out.println("You quit the game");
		//}
		//else {
		//	System.out.println("You are still playing the game");
		//}
			
		Scanner scanner = new Scanner(System.in);
			
		System.out.println("You are playing a game!!! Press q or Q to quit");
		String response = scanner.next();
			
		if(!response.equals("q") &&  !response.equals("Q")) {
			System.out.println("You are playing the game");
			}
			else {
			System.out.println("You are not playing the game");
			}
			
			
	
	
	
	}

}
