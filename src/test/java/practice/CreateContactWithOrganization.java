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

public class CreateContactWithOrganization 
{
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
				
				String ORGNAME = eUtil.readDataFromExcel("Contacts", 7, 3)+jUtil.getRandomNumber();
				String LASTNAME = eUtil.readDataFromExcel("Contacts", 7, 2);
				
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
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				//Step 6: Navigate to organization link 
				driver.findElement(By.linkText("Organizations")).click();
				
				// Step 6: Navigate to organization link
				driver.findElement(By.xpath("//img[@title ='Create Organization...']")).click();
				
				//Step 7: Create organization with mandatory field
				driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
				
				//Step 8: Save
				driver.findElement(By.xpath("//input[@title = 'Save [Alt+S]']")).click();
				
				//Step 9: Validate for Organization
				String orgHeader = driver.findElement(By.xpath("//span[@class = 'dvHeaderText']")).getText();;
						
				if(orgHeader.contains(ORGNAME))
				{
					System.out.println(orgHeader);
					System.out.println("Organization created succesfully");
				}
				else
				{
					System.out.println("FAIL");
				}
				
				//Step 10: Navigate to contacts 
				driver.findElement(By.linkText("Contacts")).click();
				
				//Step 11: Click on create contact look up image
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				
				//Step 12: Create contact with mandatory fields
				driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
				
				//Step 13: Click on organization look up image 
				driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
				
				wUtil.switchToWindow(driver, "Accounts");
				
				driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
				
				driver.findElement(By.name("search")).click();
				driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click(); //org name is dynamic 
									                                 //xpath is changing - dynamic xpath
				
				wUtil.switchToWindow(driver, "Contacts");
				//Step 14: Validate for organization
				String contactHeader = driver.findElement(By.xpath("//span[@class = 'dvHeaderText']")).getText();
						
				if(contactHeader.contains(LASTNAME))
				{
					System.out.println(contactHeader);
					System.out.println("Organization created successfully");
				}
				else
				{
					System.out.println("FAIL");
				}
				
				//Step 15: Log out of Application
				WebElement ele = driver.findElement(By.xpath("//img[@src = 'themes/softed/images/user.PNG']"));
				wUtil.mouseHover(driver, ele);
				
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("Signout successful");
				
				
				
	}

}
