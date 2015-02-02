//Niall Martin - 12301341 3BCT1

public class Rational implements Comparable<Rational>
{

	private int numerator; // numerator
	private int denominator; // denominator

	
	public Rational(int numerator, int denominator) throws Exception // constructor
	{
		this.numerator = numerator;
		this.denominator = denominator;
		
		//exception to make sure q can't be made = 0
		if(this.denominator==0)
		{
			throw new Exception("Denominator cannot be equal to zero");
		}
	}	
	
	//toString method to print strings
	public String toString()
	{
		return (numerator + "/" + denominator);
	}

	//override compareTo method
	@Override
	public int compareTo(Rational o) 
	{
		if((double)this.numerator/this.denominator == (double)o.numerator/o.denominator)
		{
			return 0;
		}
		
		else if ((double)this.numerator/this.denominator < (double)o.numerator/o.denominator)
		{
			return -1;
		}
		
		else if ((double)this.numerator/this.denominator > (double)o.numerator/o.denominator)
		{
			return 1;
		}
		return 2; // should never get to this
	}
	
}
