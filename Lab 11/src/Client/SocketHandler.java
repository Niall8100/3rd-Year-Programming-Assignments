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
	
	//constructor
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
	
	//download file from server
	public void downloadFile(String fileName) throws IOException
	{		
		int readBytes;
		int current = 0;
				
		//Send file name to server
		sw.println(fileName);
		sw.flush();
		
		//create file object assuming file name is valid
		File file = new File(fileName);
		if(file.exists())
		{
			System.out.println("Client: File " + fileName + " exists on server, will download.");
			
			//download file
			System.out.println("Client: Downloading file " + fileName + "...");
			
			//convert file to bytes so it can be transferred
			byte[] byteArray  = new byte[(int)file.length()];
			InputStream is = client.getInputStream();
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			//loop through byte array so that it can be transferred from server
			for(int i = 0;i<byteArray.length;i++)
			{
				readBytes = is.read(byteArray, i, (byteArray.length-i));
			}
						
			//get file from server
			bos.write(byteArray, 0, current);
			bos.flush();
			System.out.println("Client: Download complete!");
			bos.close();
		}
		
		else
		{
			//Files does not exists
			System.out.println("client: File " + fileName + " not found");								
		}
	}
		
	//upload file to server
	public void uploadFile(String fileName) throws IOException
	{ 				
		//Send File Name to server
		sw.println(fileName);
		sw.flush();
		
		//create file object assuming file name is valid
		File file = new File(fileName);
		
		if(file.exists())
		{
			//File exists
			System.out.println("Client: File " + fileName + " exists, will upload to server.");	
					
			//convert file to bytes so it can be transferred
			byte[] byteArray  = new byte[(int)file.length()];
			//OutputStream is = client.getOutputStream();
			FileInputStream fis = new FileInputStream(file); 
			BufferedInputStream bis = new BufferedInputStream(fis);

			DataInputStream dis = new DataInputStream(bis);
			dis.readFully(byteArray, 0, byteArray.length);
			OutputStream os = client.getOutputStream();
					
			//send file to server
			System.out.println("Client: uploading file " + fileName);
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF(file.getName());
			dos.writeLong(byteArray.length);
			dos.write(byteArray, 0, byteArray.length);
			dos.flush();
			System.out.println("client: upload complete!");
			dos.close();
		}
					
		else
		{
			//Files does not exists
			System.out.println("client: File " + fileName + " not found");				
			
		}
	}
	
	//close connection
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
