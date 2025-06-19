package Calculator;

import java.util.Scanner;

public class ArithmaticCalculator {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num1 = 0, num2 = 0, answer = 0;
		String operator = "";

		System.out.println("Enter the two numbers You want to do operation with");
		boolean valid1 = true;
		while(valid1) {
			try {
			System.out.print("num1: ");
			num1 = Integer.parseInt(in.nextLine());
			System.out.print("num2: ");
			num2 = Integer.parseInt(in.nextLine());
			valid1 = false;
			}
			catch(NumberFormatException num) {
				System.out.println("Enter Numbers Bro!");
			}
		}
		
		System.out.println("Enter one of the Operations: '+', '-', '*', '%'");
		boolean valid2 = true;
		while(valid2) {
			try {
				operator = in.nextLine();
				if(!operator.matches("[+\\-*/]")) {
					throw new IllegalArgumentException();
				}
				valid2 = false;
			}
			catch(IllegalArgumentException op) {
				System.out.println("Enter one of the Operations Bro: '+', '-', '*', '%'");
			}
		}
		
		switch(operator) {
			case "+":
				answer = num1 + num2;
				break;
			case "-":
				answer = num1 - num2;
				break;
			case "*":
				answer = num1 * num2;
				break;
			case "/":
				answer = num1 / num2;
				break;
		}
		
		System.out.println(num1+" "+operator+" "+num2+" = "+answer);
		in.close();
	}
}