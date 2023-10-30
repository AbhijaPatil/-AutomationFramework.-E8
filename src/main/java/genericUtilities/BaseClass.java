package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectRepository.HomePage;
import objectRepository.LoginPage;

/**
 * This class consists of all basic Configuration Annotations of TestNG
 * @author Abhija 
 *
 */
public class BaseClass
{
	public PropertyFileUtility  pUtil = new PropertyFileUtility();
	public ExcelfileUtility eUtil = new ExcelfileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility  wUtil = new WebDriverUtility();
	
	public WebDriver driver = null;
	
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig()
	{
		System.out.println("----DB COnnection Successful");
	}
	
	@BeforeClass(groups = {"SmokeSuite","ReggressionSuite"})
	public void bcConfig() throws IOException
	{
        String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
	    {
	    	driver = new ChromeDriver();
	    	System.out.println(BROWSER+ "------launched------");
	   
	    }
	    else if(BROWSER.equalsIgnoreCase("edge"))
	    {
	    	driver = new EdgeDriver();
	    	System.out.println(BROWSER+ "------launched------");
	   
	    }
	    else if(BROWSER.equalsIgnoreCase("firefox"))
	    {
	    	driver = new FirefoxDriver();
	    	System.out.println(BROWSER+ "------launched------");
	   
	    }
	    else
	    {
	    	System.out.println("Invalid browser");
	    }
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("----Login Successful");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("----Logout Successful");
	}
	
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("---Browser Closed----");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("----DB Connection closed");
	}
}
