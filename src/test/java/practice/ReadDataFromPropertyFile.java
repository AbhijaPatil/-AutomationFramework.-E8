package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException 
	{
		//Step 1: Open the document in a java readable object
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		
		//Step 2: Create object of properties for java.util package
		Properties p = new Properties();
		
		//Step 3: Load the file input stream into properties
		p.load(fis);
		
		//Step 4: Provide the key and read the value
		String value = p.getProperty("browser");
		System.out.println(value);
	}

}
