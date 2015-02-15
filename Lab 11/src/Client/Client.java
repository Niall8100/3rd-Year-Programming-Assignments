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
		
		//Create Socket
		SocketHandler client = new SocketHandler(ipAddress, port);
		//connect to server
		System.out.println("Client: Connecting to server...");
		client.connect();
		
		int choice;
		System.out.print("Choose\n1: Download file\n2: Upload file\nYour choice: ");
		Scanner scan1 = new Scanner(System.in);
		choice = scan1.nextInt();
		
		if(choice == 1)
		{
			//file name
			String fileName;
			System.out.print("Client: Enter file name: ");
			Scanner scan2 = new Scanner(System.in);
			fileName = scan2.nextLine();
			
			//get file
			System.out.println("Client: Get file " + fileName);
			client.downloadFile(fileName);
		}
		else if(choice == 2)
		{
			//file name
			String fileName;
			System.out.print("Client: Enter file name: ");
			Scanner scan3 = new Scanner(System.in);
			fileName = scan3.nextLine();
			
			//get file
			System.out.println("Client: Get file " + fileName);
			client.uploadFile(fileName);
		}
		else
		{
			System.out.println("Client: Invalid Input.");
		}
				
		//close connection
		System.out.println("Client: Closing Connection...");
		client.close();
	}
}

