//Niall Martin - 12301341 - CT326 - 3BCT1

//imports
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class testApplication extends JFrame 
{
	private JLabel label1, label2, label3;
	private String part1Status;
	private String part2Status;
	private String part3Status;
	
	//part 1 variables
	private JRadioButton heatSwitchOn, heatSwitchOff;
	private ButtonGroup radioGroup;
	
	//part 2 variables
	private JComboBox heatIntensity;
	private String intensityLevels[] = {"1", "2", "3", "4", "5"};
	
	//part 3 variables
	private JList modeOperation;
	private String modes[] = {"Manual", "Timed"};
	
	//part 4 vavriables
	private JButton status;
	private String totalStatus;

	public static void main(String args[])
	{
		//Execute Application
		testApplication app = new testApplication(); //create application object
		
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //program will exit when window is closed
	}
	
	//Application constructor - sets up GUI
	public testApplication()
	{
		//label on top of program
		super("CT326 Programming Assignment 8 - Heater Controller");
	
		//get content pane and set its layout
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		
		//PART 1 - add heat switch label
		label1 = new JLabel("Heat Switch");
		container.add(label1);
		
		//add heat switch
		heatSwitchOn = new JRadioButton("On", false);
		heatSwitchOff = new JRadioButton("Off", false);
		
		//Register events for radio buttons
		RadioButtonHandler handler1 = new RadioButtonHandler();
		heatSwitchOn.addItemListener(handler1);
		heatSwitchOff.addItemListener(handler1);
		
		//add radio buttons to group
		radioGroup = new ButtonGroup();
		radioGroup.add(heatSwitchOn);
		container.add(heatSwitchOn);
		radioGroup.add(heatSwitchOff);
		container.add(heatSwitchOff);
		
		//PART 2 - add heat intensity label
		label2 = new JLabel("Heat Intensity");
		container.add(label2);
		
		//set up heat intensity option list
		heatIntensity = new JComboBox(intensityLevels);
		heatIntensity.setMaximumRowCount(5);
		
		//Register JComboBox to receive events from anonymous ItemListener
		heatIntensity.addItemListener(
				// anonymous inner class to handle JComboBox events
				new ItemListener()
				{
					public void itemStateChanged(ItemEvent event) 
					{
						//find the selected item from list
						if(event.getStateChange() == ItemEvent.SELECTED)
						{
							part2Status = ("Heat Intensity set to " + (1+heatIntensity.getSelectedIndex() + "."));
							JOptionPane.showMessageDialog( null, part2Status);
							System.out.println(part2Status);
						}
					}
				}// end anonymous inner class
			);// end call to addItemListener
		
		//add list to program
		container.add(heatIntensity);
		
		//PART 3 - add manual and timed operation buttons
		label3 = new JLabel("Mode of Operation");
		container.add(label3);
		
		//Create List
		modeOperation = new JList(modes);
		modeOperation.setVisibleRowCount(2);
		
		//don't allow multiple selections
		modeOperation.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//add JScrollPane containing list
		container.add(new JScrollPane(modeOperation));
		
		//event handler
		modeOperation.addListSelectionListener(
				//anonymous inner class for list selection event
				new ListSelectionListener()
				{
					public void valueChanged(ListSelectionEvent event)
					{
						//handle each option
						if(modeOperation.getSelectedIndex() == 0)
						{
							part3Status = ("Mode of operation set to manual.");
							JOptionPane.showMessageDialog( null, part3Status);
							System.out.println(part3Status);
						}
						
						else if(modeOperation.getSelectedIndex() == 1)
						{
							part3Status = ("Mode of operation set to timed.");
							JOptionPane.showMessageDialog( null, part3Status);
							System.out.println(part3Status);
						}
					}
				}//end anonymous inner class
			);//end call to addListSelectionListener
		
		//PART 4 - Overall status button
		//create button
		status = new JButton("Check current heater settings");
		container.add(status);

		//create instance of inner class ButtonHandler() to handle event
		ButtonHandler handler3 = new ButtonHandler();
		status.addActionListener(handler3);
		
		setSize(215,200);
		setVisible(true);
	}
	
	//private inner class to handle radio button events (PART 1)
	private class RadioButtonHandler implements ItemListener
	{
		public void itemStateChanged(ItemEvent event) 
		{
			//user clicked on for heat switch
			if(event.getSource() == heatSwitchOn)
			{
				part1Status = ("Heat switch set to on.");
				System.out.println(part1Status);
			}
			
			//user hit off for heat switch
			else if(event.getSource() == heatSwitchOff)
			{
				part1Status = ("Heat switch set to off.");
				System.out.println(part1Status);
				
			}
		}
	}//end private inner class RadioButtonHandler
	
	////private inner class to handle button events (PART 4)
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event) 
		{
			//make sure all settings have been set at least once
			if(part1Status == null || part2Status == null || part3Status == null)
			{
				JOptionPane.showMessageDialog( null, "Please finish choosing preferred heater setting");
				System.out.println("Please finish choosing preferred heater settings.");
			}
			
			else
			{
				totalStatus = ("Overall heater status:\n" + part1Status + "\n" + part2Status + "\n" + part3Status);
				JOptionPane.showMessageDialog( null, totalStatus);
				System.out.println(totalStatus);
			}
		}
	}//end private inner class
}
