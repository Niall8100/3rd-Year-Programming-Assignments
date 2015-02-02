//Niall Martin 12301341 Programming Assignment 3

import java.util.Scanner;	//scanner for reading in rational fractions
import java.util.regex.*;	// import to split string instead of string tokenizer

public class Test 
{
	//arrays to store numerators and denominators
	private static int[] p = new int[2];
	private static int[] q = new int[2];
	
	public static void main(String[] args)
	{
		System.out.printf("Enter numerator & denominator of first rational number in the form p/q: ");	//Scanner to enter first rational fraction
		Scanner scan1 = new Scanner(System.in);
		String input1 = scan1.nextLine();
		
		String[] inputArray = new String[2];
		inputArray = input1.split("\\/");	//split sting into string array with the two numbers entered as string elements
		
		try
		{
			p[0] = Integer.parseInt(inputArray[0]);	// store the string numbers as integers in the numerator and denominator arrays
			q[0] = Integer.parseInt(inputArray[1]);
			
			new Rational(p[0],q[0]); //call rational class with entered numbers as parameters
		}
		catch(Exception e)
		{
			System.out.println("Exception thrown: " + e);	//handle exception if q=0
		}
		
		//repeat for second rational fraction
		System.out.printf("Enter numerator & denominator of second rational number in the form p/q: ");
		Scanner scan2 = new Scanner(System.in);
		String input2 = scan2.nextLine();
		
		inputArray = input2.split("\\/");
		
		try
		{
			p[1] = Integer.parseInt(inputArray[0]);
			q[1] = Integer.parseInt(inputArray[1]);
			
			new Rational(p[1],q[1]);
		}
		catch(Exception e)
		{
			System.out.println("Exception thrown: " + e);
		}
			
		//call rational class methods to add, subtract, multiply and divide
		Rational.add(p[0],q[0],p[1],q[1]);
		Rational.subtract(p[0],q[0],p[1],q[1]);
		Rational.multiply(p[0],q[0],p[1],q[1]);
		Rational.divide(p[0],q[0],p[1],q[1]);		
	}

}
