// Niall Martin - 12301341

//imports
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class Input 
{
	//Specify strings to be save the user's input
	private static String firstName;
	private static String surname;
	private static String patientID;
	private static String phoneNumber;
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		enterData();	//Method to write data to file
		ReadFile.Read();	//Method to read data from file and print it to the console
	}
	
	public static void enterData()
	{
		//Scanner used to save patient's first name to a string
		System.out.printf("Enter patient's first name: ");	
		Scanner scan1 = new Scanner(System.in);
		firstName = scan1.nextLine();
		
		//Scanner used to save patient's surname to a string
		System.out.printf("Enter patient's surnname: ");	
		Scanner scan2 = new Scanner(System.in);
		surname = scan2.nextLine();
		
		//Scanner used to save patient's id to a string
		System.out.printf("Enter patient's ID: ");	
		Scanner scan3 = new Scanner(System.in);
		patientID = scan3.nextLine();
		
		//Scanner used to save patient's phone number to a string
		System.out.printf("Enter patient's phone number: ");	
		Scanner scan4 = new Scanner(System.in);
		phoneNumber = scan4.nextLine();
	
		//Create file object at location of file which will have the data written to it
		File file = new File("C:/Users/Niall/Desktop/College/Third year/Programming/Labs/Lab 4/patientData.txt");
		
		//Create FileWriter Object fo later use
		FileWriter fw = null;
		
		try 
		{
			//Write the entered data to the file and skip to the next line after writing
			fw = new FileWriter(file);
			fw.write(firstName + System.getProperty("line.separator"));
			fw.write(surname + System.getProperty("line.separator"));
			fw.write(patientID + System.getProperty("line.separator"));
			fw.write(phoneNumber + System.getProperty("line.separator"));
		} 
		
		catch (IOException e) //catch exception
		{
			e.printStackTrace();
		}
		
		finally
		{
			//close stream
			try
			{
				fw.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
	}
}
