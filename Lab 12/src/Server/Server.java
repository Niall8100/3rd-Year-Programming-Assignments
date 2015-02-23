//Niall Martin - 12301341 - CT326 Assignment 12
package Server;

//Server for UDP file transfer application that
//uses Datagram sockets and packets

//imports fpr application
import java.io.IOException;
import java.net.*;
//imports for GUI
import java.awt.BorderLayout;
import javax.swing.*;

public class Server extends JFrame
{
	private JTextArea display; //will display received packets
	private DatagramSocket socket; //socket to connect to client
	
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
}
