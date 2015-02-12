//Niall Martin - 12301341 - CT326 Assignment 11
package Server;

//import core packages
import java.io.*;
import java.net.*;
import java.awt.*;
import java.util.*;

public class ThreadHandler extends Thread
{
	private Socket connection;
	
	public ThreadHandler(Socket connection)
	{
		this.connection = connection;
		connectionHandler();
	}
	
	//synchronized method to prevent interference 
	private synchronized boolean connectionHandler()
	{
		try
		{
			//read and write buffers for socket
			//PrintWriter writer = new PrintWriter(connection.getOutputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			//fetch file name from client
			String fileName = reader.readLine();
			System.out.println("Server: file " + fileName + "requested from client");
			
			try
			{
				File file = new File(fileName); //files in upload directory
				
				//if file exists
				if(file.exists())
				{
					System.out.println("File found, transfer will begin...");
					
					//create buffer to read file to socket
					byte[] byteArray = new byte[(int)file.length()]; //byte array will be the appropriate size needed
					FileInputStream fis = new FileInputStream(file);
					BufferedInputStream bis = new BufferedInputStream(fis);
					bis.read(byteArray, 0, byteArray.length);
					OutputStream os = connection.getOutputStream();
					
					//send file
					os.write(byteArray, 0, byteArray.length);
					os.flush();
					bis.close();
					connection.close();
					
					System.out.println("Server: File " + fileName + " sent!");
				}
				
				else
				{
					//can't find file
					System.out.println("Server: Can't find file " + fileName);
				}
				
				return true;
			}
			
			catch(Exception e)
			{
				System.err.println("Error: " + e.getMessage());
				return false;
			}
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
			return false;
		}
	}
}
