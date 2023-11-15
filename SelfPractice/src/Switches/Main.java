package Switches;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Switch = statement that allows a variable to be tested for equality against a list of values
		// use this when is a lot of if statement
		String day = "yo";
		
		switch(day) {
		case "Sunday": System.out.println("It is Sunday");
		break;  //DO NOT FORGET TO ADD BREAKS AFTER CASES
		case "Monday": System.out.println("It is Monday");
		break;
		case "Tuesday": System.out.println("It is Tuesday");
		break;
		case "Wednesday": System.out.println("It is Wednesday");
		break;
		case "Thursday": System.out.println("It is Thursday");
		break;
		case "Friday": System.out.println("It is Friday");
		break;
		case "Saturday": System.out.println("It is Saturday");
		break;
		default: System.out.println("Thats not a day!!"); // this will be if you put a wrong word
		}
		
	}

}
