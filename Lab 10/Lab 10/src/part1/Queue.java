//Niall Martin - 12301341
package part1;

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
	public int capacity; //capacity of queue

    
    public Queue(int capacity)//queue constructor
    {
    	this.capacity = capacity;
    }
    
    public void add(String word) throws InterruptedException
    {
    	
	    try
	    {
	    	lock.lock(); // obtain lock
	    	
	    	 // if queue is full, wait for space to be available
	    	if(queue.size()>= capacity)
	    	{
	    		System.out.println("Queue full, wait for space to open up");
	    		while(queue.size()>= capacity) space.await();
	    	}
	    	
	    	//add string to queue
    		queue.add(word);
    		System.out.println(word + " produced");
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
    		
    		String firstString = this.queue.pollFirst(); // get first word from queue
    		System.out.println(firstString +" consumed.");
    		System.out.println("Number of threads in queue: " + Main.queueCount); // print number of elements in queue
    		space.signal();
    		
    		return firstString;
       	}
    	
    	finally
    	{
    		lock.unlock(); // unlock
    	}
    	
    }
    
}
