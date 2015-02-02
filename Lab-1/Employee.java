// Abstract base class Employee.

import java.util.Date;
import java.util.Calendar;

public abstract class Employee 
{

    private String firstName;
    private String lastName;
    private Date joinDate;
    private static int employeeID;
    public Date sept2009;
    
    
   
    // constructor
    public Employee(String first, String last, Date join, int id)
    {
        firstName = first;
        lastName = last;
        joinDate = join;
        employeeID = id;
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
