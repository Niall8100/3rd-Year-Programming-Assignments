//Niall Martin - 12301341

package Part1;
//Niall Martin - 12301341

import java.io.Serializable;



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
	
	//toString override
	@Override
	public String toString()
	{
		return "Student name: " + name + "|| Course Code: " + code + "|| Student ID " + id;
	}
}
