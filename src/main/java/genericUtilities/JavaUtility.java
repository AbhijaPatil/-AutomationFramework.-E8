package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consists of generic methods related to java
 * @author Abhija
 *
 */
public class JavaUtility 
{
	/*
	 * This method will generate a random number for every run and return it to the caller
	 */
	public int getRandomNumber()
	{
		Random ran = new Random();
		int r = ran.nextInt(1000);
		return r;
	}
	
	/**
	 * This method will capture 
	 * @return 
	 */
	public String getSystemdate()
	{
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String date = formatter.format(d);
		return date;
	}
	

}
