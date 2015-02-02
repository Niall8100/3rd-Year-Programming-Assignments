//Niall Martin - 12301341 3BCT1

import java.util.*;

public class Test 
{
	//implement arraylists
	public static ArrayList<Rational> rationals = new ArrayList<Rational>();
	
	public static void main(String[] args) throws Exception 
	{
		//create 10 rational objects
		addObjects();
		
		//print string representation of rational objects
		System.out.println("Print unsorted arraylist");
		
		for(Rational element:rationals)
		{
			System.out.println(element.toString());
		}
		
		//shuffle rational objects
		Collections.shuffle(rationals);
		
		//print rational objects in new shuffled order
		System.out.println("\nPrint shuffled arraylist");
		for(Rational element:rationals)
		{
			System.out.println(element.toString());
		}
		
		//sort rational objects
		Collections.sort(rationals, new ComparatorClass());
		//print rational objects in new sorted order
		System.out.println("\nPrint sorted arraylist");
		for(Rational element:rationals)
		{
			System.out.println(element.toString());
		}
		
		//method to compare inputed fraction with the fractions in the list.
		compareRational();	
	}
	
	public static void addObjects() throws Exception
	{
		//create random rational objects and add them to the list
		
			int a,b;
			for(int i=0;i<10;i++)
			{
				a=(int) Math.ceil(Math.random()*20);
				b=(int) Math.ceil(Math.random()*20);
				Rational obj = new Rational(a,b);
				rationals.add(obj);
			}
			
	} 
		
	
	public static void compareRational() throws Exception
	{
		//Enter fraction
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter rational to see if it is in the list.");
		System.out.print("Enter fraction in the form p/q: ");
		String fraction = scan.nextLine();
		
		//split string into array, and parse each element to integers to be used to make a new rational object to compare with the list.
		String[] inputArray = new String[2];
		inputArray = fraction.split("\\/");
		int numerator = Integer.parseInt(inputArray[0]);
		int denominator = Integer.parseInt(inputArray[1]);
		
		Rational inputObject = new Rational(numerator, denominator);
		
		//Use binarySearch to see if the object is a member of the list
		int present = Collections.binarySearch(rationals, inputObject);
		
		if(present > -1)//will be true if it is in the list
		{
			System.out.println("Inputted fraction is in the list.");
		}
		
		else
		{
			System.out.println("Inputted fraction is not in the list.");
		}
	}
}

