//Niall Martin 12301341 Programming Assignment 3

public class Rational 
{
	private int p; // numerator
	private int q; // denominator
	
	public Rational(int numerator, int denominator) throws Exception // constructor
	{
		p = numerator;
		q = denominator;
		
		//exception to make sure q can't be made = 0
		if(q==0)
		{
			throw new Exception("Denominator cannot be equal to zero");
		}
	}
	
	//methods to add, subtract, multiply and divide the rational fractions respectively
	public static int add(int numerator1, int denominator1, int numerator2, int denominator2)
	{
		System.out.printf(numerator1 + "/" + denominator1 + " plus " + numerator2 + "/" + denominator2 + " = " + ((numerator1/denominator1)+(numerator2/denominator2)) + "\n");
		return (numerator1/denominator1)+(numerator2/denominator2);
	}
	
	public static int subtract(int numerator1, int denominator1, int numerator2, int denominator2)
	{
		System.out.printf(numerator1 + "/" + denominator1 + " take away " + numerator2 + "/" + denominator2 + " = " + ((numerator1/denominator1)-(numerator2/denominator2)) + "\n");
		return (numerator1/denominator1)-(numerator2/denominator2);
	}
	
	public static int multiply(int numerator1, int denominator1, int numerator2, int denominator2)
	{
		System.out.printf(numerator1 + "/" + denominator1 + " multiplied by " + numerator2 + "/" + denominator2 + " = " + ((numerator1/denominator1)*(numerator2/denominator2))+"\n");
		return (numerator1/denominator1)*(numerator2/denominator2);
	}
	
	public static int divide(int numerator1, int denominator1, int numerator2, int denominator2)
	{
		System.out.printf(numerator1 + "/" + denominator1 + " divided by " + numerator2 + "/" + denominator2 + " = " + ((numerator1/denominator1)/(numerator2/denominator2))+"\n");
		return (numerator1/denominator1)/(numerator2/denominator2);
	}
	
}
