package Expressions;

public class Main {
	public static void main(String[]args) {
		//expressions = operands & operators
		// operands = values, variables,numbers, quantity
		// operators = + - / * %
		
		int friends = 10;
		//friends = friends + 1;
		//friends = friends - 1;
		//friends = friends / 2;
		//friends = friends * 2;
		//friends = friends % 2;
		//instead doing this we can use the operators
		friends++;
		friends = friends/3;  // will give you just the decimal to change it, we need to change
		// "int" for "double" so the answer can have decimals
		System.out.println(friends);
	}

}
