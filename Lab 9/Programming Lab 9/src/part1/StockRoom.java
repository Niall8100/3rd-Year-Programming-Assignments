//Niall Martin - 12301341 - 3BCT1

package part1;

//imports
import java.lang.Runnable;

public class StockRoom implements Runnable
{
	//variables
	private Thread thread = null;
	String threadName;
	int stockAmount;
	
	//Constructor
	StockRoom(String name, int amount)
	{
		threadName = name;
		stockAmount = amount;
	}
	
	
	public void start()
	{
		System.out.println("Starting " + threadName); //print starting current thread

		if(thread==null)
		{
			thread = new Thread(this, threadName); //initialize thread
			thread.start(); //invokes run() method
		}
	}
	
	public void run() 
	{
		System.out.println("Running " + threadName);//print running current thread
			
		//run each method to change test.stock, the int to remember current stock level
		addToStock();
		removeStock();
		checkStock();
	}
	
	public void addToStock()
	{
		//print what method is doing to console
		System.out.println(threadName + " Adding " + stockAmount + " to current stock total: " + test.stock + " to get new stock total: " + (test.stock + stockAmount));
		test.stock += stockAmount; //change test.stock to test.stock + stockAmount
	}
	
	public void removeStock()
	{
		//print what method is doing to console
		System.out.println(threadName + " Removing " + stockAmount + " from current stock total: " + test.stock + " to get new stock total: " + (test.stock - stockAmount));
		test.stock -= stockAmount; //change test.stock to test.stock + stockAmount
	}
	
	public void checkStock()
	{
		//print current total stock level
		System.out.println(threadName + " Checking stock, Current total stock: " + test.stock);
	}
}
