//Niall Martin - 12301341 - CT326 Assignment 12
package Client;

import java.io.Serializable;

public class FileData implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String sourcePath, destinationPath;
	private static String fileName;
	private long fileSize;
	private byte[] fileData;
	private String status;
	
	//constructor
	public FileData()
	{
		
	}
	
	//Getter and setter methods for file data
	public String getSourcePath()
	{
		return sourcePath;
	}
	
	public void setSourcePath(String sourcePath)
	{
		this.sourcePath = sourcePath;
	}
	
	public String getDestinationPath()
	{
		return destinationPath;
	}
	
	public void setDestinationPath(String destinationPath)
	{
		this.destinationPath = destinationPath;
	}
	
	public static String getFileName()
	{
		return fileName;
	}
	
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	
	public long getFileSize()
	{
		return fileSize;
	}
	
	public void setFileSize(long fileSize)
	{
		this.fileSize = fileSize;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	public byte[] getFileData()
	{
		return fileData;
	}
	
	public void setFileData(byte[] fileData)
	{
		this.fileData = fileData;
	}

}
