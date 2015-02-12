//Niall Martin - 12301341 - CT326 Assignment 11
package Client;

//import core packages
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.Event.*;

import java.util.Scanner;

public class Client 
{
	public static void main(String[] args) throws IOException
	{
		//server info
		String ipAddress = "127.0.0.1";
		int port = 4444;
		
		//file name
		String fileName;
		System.out.print("Client: Enter file name: ");
		Scanner scan = new Scanner(System.in);
		fileName = scan.nextLine();
		
		//Create Socket
		SocketHandler client = new SocketHandler(ipAddress, port);
		//connect to server
		System.out.println("Client: Connecting to server...");
		client.connect();
		//get file
		System.out.println("Client: Get file " + fileName);
		client.getFile(fileName);
		//close connection
		System.out.println("Client: Closing Connection...");
		client.close();
	}
}

