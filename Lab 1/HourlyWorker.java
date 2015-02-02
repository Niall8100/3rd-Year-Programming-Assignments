import java.util.Date;
import java.util.Calendar;

// Definition of class HourlyWorker

public final class HourlyWorker extends Employee 
{

    private double wage; // wage per hour
    private double hours; // hours worked for week

    // constructor for class HourlyWorker
    public HourlyWorker(String first, String last, Date join, double wagePerHour, double hoursWorked, int id) 
    {
        super(first, last, join, id); // call superclass constructor
        setWage(wagePerHour);
        setHours(hoursWorked);
    }

    // Set the wage
    public void setWage(double wagePerHour) 
    {
        wage = (wagePerHour > 0 ? wagePerHour : 0);
    }

    // Set the hours worked
    public void setHours(double hoursWorked) 
    {
        hours = (hoursWorked >= 0 && hoursWorked < 168 ? hoursWorked : 0);
    }

    // Get the HourlyWorker's pay
    public double earnings() 
    {
        return wage * hours;
    }

    public String toString() 
    {
        return "Hourly worker: " + super.toString();
    }
}
