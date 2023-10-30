package practice;

import java.io.IOException;

import genericUtilities.ExcelfileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;

public class GenericUtilitiesPractice {

	public static void main(String[] args) throws IOException 
	{
		PropertyFileUtility putil =  new PropertyFileUtility();
		String URL = putil.readDataFromPropertyFile("url");
		
		System.out.println(URL);
		
		String BROWSER = putil.readDataFromPropertyFile("browser");
		System.out.println(BROWSER);
		
		ExcelfileUtility eutil = new ExcelfileUtility ();
		String data = eutil.readDataFromExcel("Contact", 0, 1);
		System.out.println(data);
		
		JavaUtility jutil = new JavaUtility();
		int r = jutil.getRandomNumber();
		System.out.println(r);
		
		String date = jutil.getSystemdate();
		System.out.println(date);
	}

}
