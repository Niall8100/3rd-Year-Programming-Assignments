//Niall Martin - 12301341
package part2;

//imports
import java.util.ArrayDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main 
{

	public static int queueCount = 0;
	
	public static void main(String[] args) throws InterruptedException
	{
		int randThreadCount = (int)Math.ceil((Math.random()*10));//for use when creating random number of threads for application
		Queue queue = new Queue();	//initialize queue with no boundaries
		ReentrantLock lock = new ReentrantLock(); //lock for use so a consume can't happen before a produce
		Condition condition = lock.newCondition();
		ExecutorService executor = Executors.newFixedThreadPool(randThreadCount);//creates thread pool that reuses a fixed number of threads, will always have enough executors
		
		//create arrays for producers and consumers
		 Producer[] producers = new Producer[randThreadCount];
		 Consumer[] consumers = new Consumer[randThreadCount];
		 
		 System.out.println("Total number of threads that will be executed(random each time): " + randThreadCount);
	     
	     for(int i=0;i<randThreadCount;i++)
	     {
	    	 //fill arrays with producer and consumer threads
	    	 producers[i] = new Producer(queue);
	    	 consumers[i] = new Consumer(queue);
	     }
	     System.out.println("Application started");
	     for(int k=0;k<randThreadCount;k++)
	     {
	    	 //execute tasks to produce and consume threads
	    	 executor.submit(producers[k]);
	    	 executor.submit(consumers[k]);
	     }
	     
	     executor.shutdown();//No new tasks are accepted at this point, existing tasks are completed
	     
	}

}
