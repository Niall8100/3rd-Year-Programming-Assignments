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
    public static void main(String args[]) 
    {
        Employee employee; // superclass reference
        String output = "";
        
        Calendar cal = Calendar.getInstance();
        cal.set(2009, 8, 21);
        Date sept2009 = cal.getTime();
        
        //Creating join dates for employees
        Calendar cal1 = Calendar.getInstance();
        cal1.set(2001, 5, 21);
        Date date1 = cal1.getTime();
        
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2005, 3, 15);
        Date date2 = cal2.getTime();
        
        Calendar cal3 = Calendar.getInstance();
        cal3.set(2010, 3, 1);
        Date date3 = cal3.getTime();
        
        Calendar cal4 = Calendar.getInstance();
        cal4.set(2014, 2, 13);
        Date date4 = cal4.getTime();
        

        Boss boss = new Boss("John", "Smith", date1, 800.0, id);

        CommissionWorker commissionWorker = new CommissionWorker("Sue", "Jones", date2, 400.0, 3.0, 150, id);

        PieceWorker pieceWorker = new PieceWorker("Bob", "Lewis", date3, 2.5, 200, id);

        HourlyWorker hourlyWorker = new HourlyWorker("Karen", "Price", date4, 13.75, 40, id);

        DecimalFormat precision2 = new DecimalFormat("0.00");
        
        //Array to store employee object references
        Employee[] employeeArray = new Employee[4];
        
        //initialise array with object references
        employeeArray[0] = boss;
        employeeArray[1] = commissionWorker;
        employeeArray[2] = pieceWorker;
        employeeArray[3] = hourlyWorker;
        
        for(Employee currentEmployee : employeeArray)
        {
        	if(currentEmployee.getJoinDate().before(sept2009))
        	{
        		output += currentEmployee.toString() + "(ID: " + currentEmployee.getEmployeeID() + ") " + " started on " + currentEmployee.getJoinDate() + " earned $"
                        + precision2.format(currentEmployee.earnings()) + " plus $100.00 as a bonus for working here longer than 5 years for a total payment of $" + precision2.format(currentEmployee.earnings()+ 100.00) + "\n\n";
        	}
        	
        	else
        	{
        		output += currentEmployee.toString() + "(ID: " + currentEmployee.getEmployeeID() + ") " + " started on " + currentEmployee.getJoinDate() + " earned $"
        				+ precision2.format(currentEmployee.earnings()) + "\n\n";
        	}
        }

        JOptionPane.showMessageDialog(null, output,"Demonstrating Polymorphism",JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
} // end class Test
