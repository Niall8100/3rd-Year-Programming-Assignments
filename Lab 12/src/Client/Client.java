//Niall Martin - 12301341 - CT326 Assignment 12
package Client;

//imports
import java.io.*;
import java.net.*;
import java.awt.*;

import javax.swing.*;

import java.util.Scanner;

public class Client extends JFrame
{
	private String sourceFile; //for entering source file path
	private String destinationPath; // for entering destination file path
	private DatagramSocket socket; //socket to connect to server
	private FileData event = null;
	
	//constructor
	public Client()
	{
		
	}
	
	//set up connection to server
	public void connectionCreator()
	{
		 System.out.println("Enter your source file: ");
		 Scanner scanner1 = new Scanner(System.in);
		 sourceFile = scanner1.nextLine();
		 
		 System.out.println("Enter destination path: ");
		 Scanner scanner2 = new Scanner(System.in);
		 destinationPath = scanner2.nextLine();

		//create and send packet
		try
		{
			socket = new DatagramSocket();
			
			InetAddress IP = InetAddress.getByName("localHost");
			byte[] indata = new byte[1024];
			
			event = getFileEvent();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(event);
			
			//convert data to byte array
			byte[] data = baos.toByteArray();
			DatagramPacket send = new DatagramPacket(data, data.length, IP, 4444);
			
			socket.send(send);
			System.out.println("File sent.");
			
			DatagramPacket inPacket = new DatagramPacket(indata, indata.length);
			socket.receive(inPacket);
			
            String response = new String(inPacket.getData());
			System.out.println("Server Response: " + response);
			Thread.sleep(2000);
			System.exit(0);
		}
		catch(UnknownHostException e)
		{
			e.printStackTrace();
		}
		catch(SocketException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	//set up file for sending to server
	public FileData getFileEvent() 
	{
		//set file info
		FileData fileEvent = new FileData();
        String fileName = sourceFile.substring(sourceFile.lastIndexOf("/") + 1, sourceFile.length());
        String path = sourceFile.substring(0, sourceFile.lastIndexOf("/") + 1);
        fileEvent.setDestinationPath(destinationPath);
        fileEvent.setFileName(fileName);
        fileEvent.setDestinationPath(sourceFile);
        File file = new File(sourceFile);
		if(file.isFile())
        {
            try 
            {
                //loop though length of file to send it to byte array for later use
            	DataInputStream dis = new DataInputStream(new FileInputStream(file));
                long len = (int) file.length();
                byte[] fileBytes = new byte[(int) len];
                int read = 0;
                int numRead = 0;
                while (read < fileBytes.length && (numRead = dis.read(fileBytes, read,fileBytes.length - read)) >= 0) 
                {
                    read = read + numRead;
                }
                fileEvent.setFileSize(len);
                fileEvent.setFileData(fileBytes);
                fileEvent.setStatus("Success");
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
                fileEvent.setStatus("Error");
            }
        } 
		
		else 
		{
            System.out.println("path specified is not pointing to a file");
            fileEvent.setStatus("Error");
        }
        return fileEvent;
    }
}

