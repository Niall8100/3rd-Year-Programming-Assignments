//Niall Martin - 12301341
package part2;

//imports
//import java.util.ArrayDeque;
import java.util.Random;

public class Producer implements Runnable
{
	public static String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; // used for letters to string
	String word; // used in getter and setter methods
	Queue queue; // queue

    Producer(Queue queue) 
    {
        this.queue = queue;
    }

    @Override
    public void run() 
    {
    	try 
    	{
    		//add random string to queue
    		String randomString = setter();
    		queue.add(randomString);
    		Main.queueCount++;
    		Thread.sleep(200);
    	} 
    	
    	catch (InterruptedException e) 
    	{
    		e.printStackTrace();
    	}
            
     }
    
	public static String randomString()
	{
		//create random string
		String threadString ="" ;
		for(int i=0;i<1+(int)(Math.random()*99);i++)
		{
			threadString+= alphabet.charAt((int)(Math.random()*alphabet.length()));
		}
		
		return threadString;
	}
	
	public String setter()
	{
		this.word = randomString();		
		return this.word;
	}
	
	public String getter()
	{
		return this.word;
	}
}
