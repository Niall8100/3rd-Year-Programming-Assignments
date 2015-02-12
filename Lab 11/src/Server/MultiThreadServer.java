//Niall Martin - 12301341 - CT326 Assignment 11
package Server;

//import core packages
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.Event.*;
import java.util.*;
import java.util.concurrent.*;

public class MultiThreadServer implements Runnable
{
	private ServerSocket connSock;
	private ExecutorService threadPool;
	
	//constructor
	public MultiThreadServer(int port)
	{
		//set max number of connections/threads
		this.threadPool = Executors.newFixedThreadPool(20);
		
		try
		{
			connSock = new ServerSocket(port);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() 
	{
		try
		{
			while(true)
			{
				threadPool.execute(new ThreadHandler(connSock.accept()));
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
