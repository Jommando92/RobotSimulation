package Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//array = used to store multiple values ins a single variable
		
		//String[]cars = {"Camaro","Corvette","Tesla"}; //make sure the data type are the same of the array 
		
		//cars[1] = "Mustang";
		//System.out.println(cars[4]);
	
		String[]cars = new String[4];
		cars[0] = "Tesla";
		cars[1]	= "Corvette";
		cars[2]	= "Ferrari";
		cars[3]	= "Ford";
		
		for (int i=0; i<cars.length; i++) {
			System.out.println(cars[i]);
		}
	}

}
