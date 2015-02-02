//Niall Martin - 12301341

package Part3;

import java.io.IOException;
import java.io.RandomAccessFile;

public class part3 
{
	public static void main(String[] args) throws IOException
	{
		//create RandomAccessFile object where you can read and write
		RandomAccessFile file = new RandomAccessFile("C:\\Users\\Niall Martin\\Desktop\\College\\Third Year\\Programming\\Labs\\Lab 5\\part3.txt", "rw");

        System.out.println("About to write to randomly accessed file");

        // find end of file
        file.seek(file.length());
        // Write the raw bytes to the file
        file.write(("programming is fun").getBytes());
        // close stream
        file.close();
	}
}
