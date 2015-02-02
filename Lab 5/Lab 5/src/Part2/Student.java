//Niall Martin - 12301341

package Part2;

import java.io.*;

public class Student implements Serializable
{
	public String name;
	public String code;
	public String id;
	
	//constructor
	public Student(String name, String code, String id)
	{
		this.name = name;
		this.code = code;
		this.id = id;
	}
	
	@Override
	public String toString()
	{
		return "Student name: " + name + "|| Course Code: " + code + "|| Student ID " + id;
	}
	
	//custom writeObject
	private void writeObject(ObjectOutputStream oos) throws IOException 
	{
        oos.writeObject(this.name);
        oos.writeObject(this.code);
        oos.writeObject(this.id);
    }

	//custom readObject
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException 
    {
        this.name = (String) ois.readObject();
        this.code = (String) ois.readObject();
        this.id = (String) ois.readObject();
    }
}
