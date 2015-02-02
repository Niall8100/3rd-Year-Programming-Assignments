//Niall Martin - 12301341

import java.util.ArrayList;

public class Test 
{

	public static ArrayList<Rational> rationals = new ArrayList<Rational>();
	public static ArrayList<Double> doubles = new ArrayList<Double>();
	
	public static void main(String[] args) 
	{
		addObjects();
		System.out.println("Print unsorted arraylist");
		for(Double element:doubles)
		{
			System.out.println(element);
		}
		
		Sort(doubles);
		System.out.println("Print sorted arraylist");
		for(Double element:doubles)
		{
			System.out.println(element);
		}
		
	}
	
	public static void addObjects()
	{
		try 
		{
			double temp;
			int a,b;
			
			a=5;
			b=1;
			Rational obj1 = new Rational(a,b);
			rationals.add(obj1);
			temp = Rational.divide(a, b);
			doubles.add(temp);
			
			a=3;
			b=1;
			Rational obj2 = new Rational(a,b);
			rationals.add(obj2);
			temp = Rational.divide(a, b);
			doubles.add(temp);
			
			a=4;
			b=1;
			Rational obj3 = new Rational(a,b);
			rationals.add(obj3);
			temp = Rational.divide(a, b);
			doubles.add(temp);
			
			a=4;
			b=2;
			Rational obj4 = new Rational(a,b);
			rationals.add(obj4);
			temp = Rational.divide(a, b);
			doubles.add(temp);
			
			a=2;
			b=1;
			Rational obj5 = new Rational(a,b);
			rationals.add(obj5);
			temp = Rational.divide(a, b);
			doubles.add(temp);
			
			a=8;
			b=2;
			Rational obj6 = new Rational(a,b);
			rationals.add(obj6);
			temp = Rational.divide(a, b);
			doubles.add(temp);
			
			a=6;
			b=1;
			Rational obj7 = new Rational(a,b);
			rationals.add(obj7);
			temp = Rational.divide(a, b);
			doubles.add(temp);
			
			a=10;
			b=5;
			Rational obj8 = new Rational(a,b);
			rationals.add(obj8);
			temp = Rational.divide(a, b);
			doubles.add(temp); 
			
			a=1;
			b=1;
			Rational obj9 = new Rational(a,b);
			rationals.add(obj9);
			temp = Rational.divide(a, b);
			doubles.add(temp);
			
			a=6;
			b=2;
			Rational obj10 = new Rational(a,b);
			rationals.add(obj10);
			temp = Rational.divide(a, b);
			doubles.add(temp);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void Sort(ArrayList<Double> list)
	{
		double temp;
		int prevIndex;
		
		for(int index = 1; index<list.size();index++)
		{
			temp = list.get(index);
			prevIndex = index - 1;
			
			while (prevIndex >=0 && (list.get(prevIndex)>temp))
			{
				list.set((prevIndex+1), list.get(prevIndex));
				prevIndex -=1;
			}
			
			if (prevIndex >= 0 && list.get(prevIndex) > temp) 
			 {
	                list.set((prevIndex + 1), list.get(prevIndex));
	                list.set((prevIndex + 1), temp);
	         } 
			 
			 else 
			 {
	                list.set((prevIndex + 1), temp);
	         }
		}
	}

}
