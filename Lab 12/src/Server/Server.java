//Niall Martin - 12301341 - CT326 Assignment 12
package Server;

//Server for UDP file transfer application that
//uses Datagram sockets and packets

//imports fpr application
import java.io.*;
import java.net.*;
//imports for GUI
import java.awt.BorderLayout;

import javax.swing.*;

public class Server extends JFrame
{
	private JTextArea display; //will display received packets
	private DatagramSocket socket; //socket to connect to client
	private FileData fileData;
	
	//constructor to set up GUI and DatagramSocket
	public Server()
	{
		super("Server");
		
		display = new JTextArea(); //create GUI display
		add(new JScrollPane(display), BorderLayout.CENTER);
		setSize(400, 300); //window size
		setVisible(true); //window will be visible to user
		
		//Create DatagramSocket for sending and receiving packets
		try
		{
			socket = new DatagramSocket(4444);
		}
		catch (SocketException sEx) //( ͡° ͜ʖ ͡°)
		{
			sEx.printStackTrace();
			System.exit(1);
		}
	} //end constructor
	
	//display text messages in the window of the GUI
	private void messageDisplay(final String message)
	{
		SwingUtilities.invokeLater(
				new Runnable()
				{
					public void run() //update display area
					{
						display.append(message);
					}
				}
			);
	}
	
	
	//method that waits for packets to arrive, displays data and echoes it pack to client
	public void packetChecker()
	{
		messageDisplay("Server started...");
		while(true)//infinite loop to constantly check for packets
		{
			try
			{
				byte[] bytePacket = new byte[1024];
				DatagramPacket receive = new DatagramPacket(bytePacket, bytePacket.length);
				
				socket.receive(receive); //wait to receive packet
				
				byte[] data = receive.getData();
				ByteArrayInputStream is = new ByteArrayInputStream(data);
				ObjectInputStream ois = new ObjectInputStream(is);
				
				fileData = (FileData) ois.readObject();
				if(fileData.getStatus().equalsIgnoreCase("Error"))
				{
					messageDisplay("Error while sending data from client\nExiting...");
				}
							
				writeFile();
				
				//display packet info.
				messageDisplay(" Received packet: From host " + receive.getAddress() + 
								"\nPort no.: " + receive.getPort() +
								"\nFile Name: " + FileData.getFileName());
				
				sendPacketToClient(receive); //echo packet back to client
			}
			catch(IOException e)
			{
				messageDisplay(e + "\n");
				e.printStackTrace();
			}
			catch(ClassNotFoundException e)
			{
				messageDisplay(e + "\n");
				e.printStackTrace();
			}
		}
	}
	
	//Method to create and write file from byte array
	public void writeFile()
	{
		String output = fileData.getDestinationPath();
		
		if(!new File(fileData.getDestinationPath()).exists())
		{
			new File(fileData.getDestinationPath()).mkdirs();
		}
		
		File outputFile = new File(output);
		
		try
		{
			FileOutputStream fos = new FileOutputStream(outputFile);
			fos.write(fileData.getFileData());
			fos.flush();
			fos.close();
			
			messageDisplay("File: " + output + "successfully transferred.");
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//Method to be used when sending packet back to client
	private void sendPacketToClient(DatagramPacket receive) throws IOException
	{
		messageDisplay("Send data back to client.");
			
		//make packet
		DatagramPacket send = new DatagramPacket(receive.getData(), receive.getLength(), receive.getAddress(), receive.getPort() );
		
		socket.send(send); //send packet
		messageDisplay("Packet sent.");
	}	
}
