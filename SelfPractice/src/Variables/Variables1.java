package Variables;

public class Variables1 {
	public static void main(String[] args){
		String x = "Water";
		String y = "Beer";
		String temp;
		
		temp=x; // always create a new variable to swap data.
		x=y;
		y=temp;
		
				
		
		System.out.println("x; "+y);
		System.out.println("y; "+y);
		System.out.println("x; "+x);
		System.out.println("y; "+x);
	}

}
