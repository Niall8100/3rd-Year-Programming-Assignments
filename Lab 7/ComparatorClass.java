//Niall Martin - 12301341 3BCT1

import java.util.Comparator;

public class ComparatorClass implements Comparator<Rational>
{

	@Override
	public int compare(Rational o1, Rational o2) 
	{
		return o1.compareTo(o2);
	}	
}
