//Niall Martin - 12301341 - CT326 Assignment 11
package Client;

//import core packages
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.Event.*;

public class SocketHandler 
{
	private Socket client;
	private PrintWriter sw;
	private BufferedReader sr;
	private String ipAddress;
	private int port;
	
	public SocketHandler(String ipAddress, int port)
	{
		this.ipAddress = ipAddress;
		this.port = port;
	}
	
	public void connect()
	{
		try
		{
			//create socket
			client = new Socket(this.ipAddress, this.port);
			
			//buffers for socket
			sw = new PrintWriter(client.getOutputStream(), true); //set autoflush to true
			sr = new BufferedReader(new InputStreamReader(client.getInputStream()));
		}
		//catch exceptions
		catch(UnknownHostException e)
		{
			System.out.println("Unknown host");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void getFile(String fileName) throws IOException
	{
		//for use in byte array
		int bytesRead;
		int current = 0;
 				
		//Send File Name to server
		sw.println(fileName);
		sw.flush();

		//check if file is on server
		File file = new File(fileName);
		if(file.exists())
		{
			//File exists
			System.out.println("Client: File " + fileName + " is on server");	
					
			//Receive file
			System.out.println("Client: Downloading file " + fileName);
			
			//convert file to bytes so it can be transferred
			byte [] byteArray  = new byte [(int)file.length()];
			InputStream is = client.getInputStream();
			FileOutputStream fos = new FileOutputStream(fileName); 
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			bytesRead = is.read(byteArray,0,byteArray.length);
			current = bytesRead;

			do 
			{
				bytesRead = is.read(byteArray, current, (byteArray.length-current));
				if(bytesRead >= 0) 
				{
					current += bytesRead;
				}
			} 
			while(bytesRead > -1);

			bos.write(byteArray, 0 , current);
			bos.flush();
			System.out.println("client: Download complete");
			bos.close();
					
		}
		else
		{
			//Files does not exists
			System.out.println("client: File " + fileName + " not found");				
			
		}
	}
	
	public void close()
	{
		try 
		{
			//Closes read/write buffers and the socket
			sw.close();
			sr.close();
			client.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
