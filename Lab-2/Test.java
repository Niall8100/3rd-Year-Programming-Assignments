// Driver for Employee hierarchy

// Java core packages
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Calendar;




// Java extension packages
import javax.swing.JOptionPane;

public class Test 
{
	private static int id = 0;
	public static Date sept2009;
	
    // test Employee hierarchy
    public static void main(String args[]) throws Exception 
    {
        Employee employee; // superclass reference
        String output = "";
        
        //5 years ago date for checking for bonus
        Calendar cal = Calendar.getInstance();	
        cal.set(2009, 8, 29);
        Date sept2009 = cal.getTime();

        
        //Array to store employee object references
        Employee[] employeeArray = new Employee[4];
        
        //try catching possible exceptions for each of the employee objects
        try
        {
        	Calendar cal1 = Calendar.getInstance();
        	cal1.set(2015, 5, 21);
        	Date date1 = cal1.getTime();
        	
        	Boss boss = new Boss("John", "Smith", date1, 800.0, id);
        	employeeArray[0] = boss;
        }
        
        catch (Exception e)
        {
        	System.out.println("Exception thrown: " + e);
        }

        try
        {
        	Calendar cal2 = Calendar.getInstance();
        	cal2.set(1989, 3, 15);
        	Date date2 = cal2.getTime();
        	
        	CommissionWorker commissionWorker = new CommissionWorker("Sue", "Jones", date2, 400.0, 3.0, 150, id);
            employeeArray[1] = commissionWorker;
        }
        
        catch (Exception e)
        {
        	System.out.println("Exception thrown: " + e);
        }
        
        try
        {
        	Calendar cal3 = Calendar.getInstance();
        	cal3.set(2010, 3, 1);
        	Date date3 = cal3.getTime();
        	
        	PieceWorker pieceWorker = new PieceWorker("Bob", "Lewis", date3, 2.5, 200, id);
            employeeArray[2] = pieceWorker;
        }
        
        catch (Exception e)
        {
        	System.out.println("Exception thrown: " + e);
        }
        
        try
        {
        	Calendar cal4 = Calendar.getInstance();
        	cal4.set(2014, 2, 13);
        	Date date4 = cal4.getTime();
        	
        	HourlyWorker hourlyWorker = new HourlyWorker("Karen", "Price", date4, 13.75, 40, id);
        	employeeArray[3] = hourlyWorker;
        }
        
        catch (Exception e)
        {
        	System.out.println("Exception thrown: " + e);
        }
        DecimalFormat precision2 = new DecimalFormat("0.00");
         
        
        for(int i=0;i<employeeArray.length ; i++)
        {
        	//if statements to account for null objects if the employee is invalid
        	if(employeeArray[i] == null)
        	{
        		output += "Invalid object due to invalid date, exceptions thrown in console output.\n\n";
        	}
        	
        	else if(employeeArray[i].getJoinDate().before(sept2009))
        	{
        		output += employeeArray[i].toString() + "(ID: " + employeeArray[i].getEmployeeID() + ") " + " started on " + employeeArray[i].getJoinDate() + " earned $"
                        + precision2.format(employeeArray[i].earnings()) + " plus $100.00 as a bonus for working here longer than 5 years for a total payment of $" + precision2.format(employeeArray[i].earnings()+ 100.00) + "\n\n";
        	}
        	
        	else
        	{
        		output += employeeArray[i].toString() + "(ID: " + employeeArray[i].getEmployeeID() + ") " + " started on " + employeeArray[i].getJoinDate() + " earned $"
        				+ precision2.format(employeeArray[i].earnings()) + "\n\n";
        	}
        }
      
        JOptionPane.showMessageDialog(null, output,"Demonstrating Polymorphism",JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
} // end class Test
