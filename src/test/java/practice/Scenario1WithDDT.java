package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1WithDDT 
{
	
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		//Step 1: Read all the necessary data
		/*read data from property file*/
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		Properties p = new Properties();
		p.load(fisp);
		String URL = p.getProperty("url");
		String BROWSER = p.getProperty("browser");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		/*read data from excel file */
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
	    String LASTNAME = wb.getSheet("Contact").getRow(1).getCell(2).getStringCellValue();
	    
	    WebDriver driver = null;
	    
	    //Step 2: launch the browser // RUn time polymorphism - driver
	    if(BROWSER.equalsIgnoreCase("chrome"))
	    {
	    	driver = new ChromeDriver();
	    	System.out.println(BROWSER+ "launched");
	   
	    }
	    else if(BROWSER.equalsIgnoreCase("edge"))
	    {
	    	driver = new EdgeDriver();
	    	System.out.println(BROWSER+ "launched");
	   
	    }
	    else if(BROWSER.equalsIgnoreCase("firefox"))
	    {
	    	driver = new FirefoxDriver();
	    	System.out.println(BROWSER+ "launched");
	   
	    }
	    else
	    {
	    	System.out.println("Invalid browser");
	    }
	    
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	//Step 2: Load the application
	driver.get(URL);
	
	//Step 3: Login to application
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	//Step 4: Navigate to contacts link
	driver.findElement(By.linkText("Contacts")).click();
	
	//Step 5: Click on create contact lookup image 
	driver.findElement(By.xpath("//img[@alt = 'Create Contact...']")).click();
	
	//Step 6: Create contact
	driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
	
	//Step 7: Save
	driver.findElement(By.name("button")).click();
	
	//Validate
	String contactHeader = driver.findElement(By.xpath("//span[@class = 'dvHeaderText']")).getText();
	if(contactHeader.contains(LASTNAME))
	{
		System.out.println("PASS");
	}
	else
	{
		System.out.println("FAIL");
	}
	
	//Log out of the application
	//using mouse hover for logging out
	
	  Thread.sleep(3000);
	  WebElement ele = driver.findElement(By.xpath("//img[@src = 'themes/softed/images/user.PNG']"));
	  
	  Actions a = new Actions(driver); 
	  a.moveToElement(ele).perform();
	  driver.findElement(By.linkText("Sign Out")).click();
	  
	  //Close the application
	  Thread.sleep(3000);
	  driver.close();
}

}
