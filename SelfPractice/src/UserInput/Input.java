package UserInput;

import java.util.Scanner; //class scanner



public class Input {

	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in); // a class to ask information to the user
		
		System.out.println("what is your name?? ");
		String name = scanner.nextLine();
		
		System.out.println("How old are you?? ");
		int age = scanner.nextInt();
		scanner.nextLine(); //
		
		System.out.println("What is your favorite food?? ");
		String food = scanner.nextLine();
		
		System.out.println("Hello " +name);
		System.out.println("You are "+age+" years");
		System.out.println("You like "+food);
		
		
		
	}
}
