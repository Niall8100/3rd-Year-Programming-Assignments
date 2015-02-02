//Niall Martin - 12301341

//imports
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadFile 
{
	//integer used to keep track of line number and for printing with each line
	private static int lineNum = 1;
	
	public static void Read() throws FileNotFoundException
	{
		//create file object to read from patientData.txt
		File file = new File("C:/Users/Niall/Desktop/College/Third year/Programming/Labs/Lab 4/patientData.txt");
		
		System.out.println("\nNow printing text from file to console");
		
		//create bufferedReader object for use when printing ot console
		try (BufferedReader br =  new BufferedReader ( new FileReader(file)))
			{
				//string which will contain current line for use in while loop
				String currentLine;
				
				while ((currentLine = br.readLine()) !=null) // checks to make sure line is not empty
				{
					System.out.println("Line number " + lineNum + ": " + currentLine); // print current line number and the line 
					lineNum++; //increment lineNum
				}
			}
		catch (IOException e) //catch exception
		{
				e.printStackTrace();
		}
		
	}
}
