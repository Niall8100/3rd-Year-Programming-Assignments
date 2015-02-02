//Niall Martin - 12301341 - 3BCT1

package part2;

//imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.util.Scanner;

public class FlashingLabel extends Applet implements Runnable, MouseListener
{
	//variables to be used
	private boolean paintText = true; //will always be true for use in infinite loop
	private boolean flash = true; //for stopping and starting flash
	private boolean paintThisTime = true; //to switch between showing and not showing text.
	static Thread helloThread = null; //create null thread, will be initialized in start(). 
	String message = "Hello World"; // text to flash
	
	Font font = new Font("TimesRoman", Font.BOLD, 24); // text settings
	
	int x,y;//window width and height
	
	//once off initialization code
	public void init()
	{
		x = 30; // display width
		y = 30; // display height
	}
	
	public void start()
	{

		if(helloThread==null)
		{
			helloThread = new Thread(this); //initialize thread
			helloThread.start(); //invokes run() method
			addMouseListener(this); // for handling mouse clicks
		}
	}
	
	
	public void run() 
	{
		
		while(paintText == true) // will always be true
		{
			try
			{
				helloThread.sleep(200);//flash interval
			}
			catch (InterruptedException e)
			{
				
			}
			
			repaint();//redo paint
		}
		
	}
	
	public void paint(Graphics g)
	{
		
		if(flash == true)
		{
			paintThisTime = !paintThisTime;
		
			if(paintThisTime == false)
			{
				return;
			}
		
			g.setFont(font);
			g.setColor(Color.BLACK);
			g.drawString(message, x, y);
		}
		else //used when not flashing
		{
			g.setFont(font);
			g.setColor(Color.BLACK);
			g.drawString(message, x, y);
		}
	}

	public static void main(String[] args)
	{
		helloThread.start(); //start null thread
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{	
		int x = e.getX();
		int y = e.getY();
		if(x<500 && y<500) //if mouse click is in this area of window, stop or restart flashing
		{
			flash = !flash;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		//not needed
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		//not needed
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		//not needed
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		//not needed
	}
}
