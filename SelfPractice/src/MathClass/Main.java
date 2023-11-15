package MathClass;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//double x = 3.14;
		//double y = - 10;
		
		//double z = Math.max(x, y);
		//System.out.println(z);
		
		//double z = Math.abs(y);
		//System.out.println(z);
		
		//double z = Math.sqrt(y); // no negative numbers will work as s a negative root
		//System.out.println(z);
		
		//double z = Math.round(x);// will round the number depending on.
		//System.out.println(z); // if you use ceil (round up) floor (round down)
		
		
		double x;
		double y;
		double z;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter side x: ");
		x = scanner.nextDouble();
		System.out.println("Enter side y: ");
		y = scanner.nextDouble();
		
		
		z = Math.sqrt((x*x)+(y*y));
		
		System.out.println("The hypotenuse is: " +z);
		scanner.close();
		
	}

}
