//Niall Martin - 12301341 - 3BCT1

package part1;

public class test 
{
	//int to keep track of total stock. static so all threads will use the same instance of this variable
	public static int stock = 300;
	
	public static void main(String args[])
	{
		//instansiate several threads that will run concurrently
		StockRoom thread1 = new StockRoom("Thread 1", 25);
		thread1.start();
		
		StockRoom thread2 = new StockRoom("Thread 2", 40);
		thread2.start();
		
		StockRoom thread3 = new StockRoom("Thread 3", 100);
		thread3.start();
	}
}
