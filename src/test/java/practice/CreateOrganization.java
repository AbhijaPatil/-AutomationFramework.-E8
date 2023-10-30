package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.ExcelfileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import objectRepository.LoginPage;

public class CreateOrganization {

	public static void main(String[] args) throws IOException
	{
		//Step 1: Create all the required objects 
		JavaUtility jUtil = new JavaUtility();
		ExcelfileUtility  eUtil = new ExcelfileUtility();
		PropertyFileUtility  pUtil = new PropertyFileUtility ();
		WebDriverUtility  wUtil = new WebDriverUtility ();
		WebDriver driver = null;
		
		
		//Step 2: Read the required data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
		
		//Step 3: Launch the browser
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
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		
		//Step 4: Load the URL 
		driver.get(URL);

		
		//Step 5: Login to application 
		/*
		 * driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 * driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 * driver.findElement(By.id("submitButton")).click();
		 */
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		/*
		 * lp.getUsernameEdt().sendKeys(USERNAME);
		 * lp.getPasswordEdt().sendKeys(PASSWORD); lp.getLoginBtn().click();
		 */
		
		//Step 6: Navigate to organization link 
		driver.findElement(By.linkText("Organizations")).click();
		
		// Step 7: Click on create organization look up Image 
		driver.findElement(By.xpath("//img[@title ='Create Organization...']")).click();
		
		//Step 8: Create organization with mandatory field
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//Step 9: Save
		driver.findElement(By.xpath("//input[@title = 'Save [Alt+S]']")).click();
		
		//Step 10: Validate for organization
		String orgHeader = driver.findElement(By.xpath("//span[@class = 'dvHeaderText']")).getText();
				
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println(orgHeader);
			System.out.println("Organization created successfully");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//Step 10: Log out of Application
		WebElement ele = driver.findElement(By.xpath("//img[@src = 'themes/softed/images/user.PNG']"));
		wUtil.mouseHover(driver, ele);
		
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Signout successful");
		
		

	}

}
