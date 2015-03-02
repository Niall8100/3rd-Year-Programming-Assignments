//Niall Martin - 12301341 - CT326 Assignment 12
package Server;

import javax.swing.JFrame;

public class ServerTest 
{
	public static void main(String[] args)
	{
		Server app = new Server();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.packetChecker();//run application
	}
}
