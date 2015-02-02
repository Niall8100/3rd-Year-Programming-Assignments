//Niall Martin - 12301341
package part1;

//imports
import java.util.ArrayDeque;

public class Consumer implements Runnable
{
	Queue queue;

	Consumer(Queue queue)
	{
		this.queue=queue;
	}

	@Override
	public void run()
	{
		try
		{
			//consume current string object in the queue
			String word = queue.remove();
			Main.queueCount--;
			Thread.sleep(200);
		}
	    	
	    catch (InterruptedException e1)
	   	{
	   		e1.printStackTrace();
	   	}	                   
    }
}
