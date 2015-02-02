// Abstract base class Employee.

import java.util.Date;
import java.util.Calendar;

public abstract class Employee 
{

    private String firstName;
    private String lastName;
    private Date joinDate;
    private static int employeeID;
    
    
   
    // constructor
    public Employee(String first, String last, Date join, int id) throws Exception
    {
    	 Calendar cal = Calendar.getInstance();
         cal.set(2014, 8, 26);
         Date today = cal.getTime();
         
         Calendar cal1 = Calendar.getInstance();
         cal.set(1990, 0, 01);
         Date Jan1990 = cal.getTime();
    	
    	firstName = first;
        lastName = last;
        joinDate = join;
        employeeID = id;
        
        
        //throw exceptions for invalid dates
        if(joinDate.after(today))
        {
        	throw new Exception("Invalid join date, is in the future!");
        }
        
        if(joinDate.before(Jan1990))
        {
        	throw new Exception("Invalid join date. Date is too early");
        }
    }
    
    // get first name
    public String getFirstName() 
    {
        return firstName;
    }

    // get last name
    public String getLastName() 
    {
        return lastName;
    }
    
  //get start date
    public Date getJoinDate()
    {
    	return joinDate;
    }
    
    // get employeeID
    public int getEmployeeID()
    {
    	employeeID++;
    	return employeeID;
    }

    public String toString() 
    {
        return firstName + ' ' + lastName;
    }
    
    public abstract double earnings();
}
