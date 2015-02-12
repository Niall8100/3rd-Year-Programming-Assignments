//Niall Martin - 12301341 - CT326 Assignment 11

package Server;

//import extension packages
import javax.swing.JFrame;

public class ServerTest
{	
	public static void main(String[] args)
	{
		System.out.println("Server: Starting server...");
		
		MultiThreadServer server = new MultiThreadServer(4444);
		server.run();
	}
}
