//Niall Martin - 12301341
package part2;

//imports
import java.util.ArrayDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Queue 
{
	public ArrayDeque<String> queue = new ArrayDeque<String>();//queue to be used
    private Lock lock = new ReentrantLock(); // lock to be used
    
    //conditions to be used
    private Condition space = lock.newCondition();
    private Condition nonEmpty = lock.newCondition();

    
    public Queue()//queue constructor
    {
    }
    
    public void add(String word) throws InterruptedException
    {
    	
	    try
	    {
	    	lock.lock(); // obtain lock

	    	//add string to queue
    		queue.add(word);
    		System.out.println(word + " produced");
    		System.out.println("Number of threads in queue: " + Main.queueCount); // print number of elements in queue
    		nonEmpty.signal(); // tell the consumer that the queue has something in it
	    	
	    }
	    
	    finally
	    {
	    	lock.unlock(); // release lock so string can be consumed
	    }
    	
    }
      
    //method to remove consumed objects from queue
    public String remove() throws InterruptedException
    {
    	try
    	{
    		lock.lock();
    		
    		//can't consume anything if queue is empty
    		if(queue.size()==0)
    		{
    			System.out.println("Queue currently empty");
    			
    			while(queue.size()<=0) 
    			{
    				nonEmpty.await();//wait until it is signaled when the queue is no longer empty
    			}
    		}
    		
    		String lastString = this.queue.pollLast(); // get last word from queue (for LIFO)
    		System.out.println(lastString +" consumed.");
    		System.out.println("Number of threads in queue: " + Main.queueCount); // print number of elements in queue
    		space.signal();
    		
    		return lastString;
       	}
    	
    	finally
    	{
    		lock.unlock(); // release lock
    	}
    	
    }
    
}
