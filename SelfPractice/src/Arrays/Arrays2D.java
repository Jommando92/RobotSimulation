package Arrays;

public class Arrays2D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2D Arrays = an array of arrays
		
		//String[][]cars = new String[3][3];
		
		//cars[0][0]= "Camaro";
		//cars[0][1]= "Tesla";
		//cars[0][2]= "Ford";
		//cars[0][0]= "Honda";
		//cars[1][1]= "Subaru";
		//cars[2][2]= "Ferrari";
		//cars[2][0]= "BMW";
		//cars[2][1]= "Vauxhall";
		//cars[2][2]= "Lambo";
		
		//for(int i = 0; i<cars.length; i++){
		//System.out.println();
		//for(int j = 0; j<cars[i].length; j++) {
		//System.out.print(cars[i][j]+"-");
		
		
		//Other Way is 
		
		String[][] cars = {	
							{"Camaro","Corvette","Ford"},
							{"Hond","Subaru","Ferrari"},
							{"BMW","Vauxhhall","Lambo"}
							};
		
		for(int i = 0; i<cars.length; i++){
		System.out.println();
		for(int j = 0; j<cars[i].length; j++) {
		System.out.print(cars[i][j]+"-");
				
			}
		}
	
	}

}
