package organizationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.ExcelfileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;

public class CreateMulOrgWithIndustryTest 
{
	ExcelfileUtility eUtil = new ExcelfileUtility();
	PropertyFileUtility pUtil = new PropertyFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	JavaUtility jUtil = new JavaUtility();
	
	@Test(dataProvider = "getData")
	public void createMultipleOrg(String ORG, String INDUSTRYNAME) throws IOException, InterruptedException
	{
        WebDriver driver = null;
		
		
		//Step 2: Read the required data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME = ORG+jUtil.getRandomNumber();
				
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
		
		//Step 5: Login to the application 
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//Step 6: Click on Organization
		HomePage hp =new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//Step 7: Click on create organization look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnOrganizationLookUpImg();
		
		//Step 8: Create new Organization with mandatory fields
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.CreateNewOrganization(ORGNAME, INDUSTRYNAME);
		wUtil.captureScreenshot(driver, ORGNAME);
		
		//Step 9: Validate for organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getHeaderText();
		
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println(orgHeader);
			System.out.println("Organization Created");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		
		//Step10: Log out of application
		hp.logoutOfApp(driver);
		
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		return eUtil.readMultipleData("MultipleOrganizations");
	}

}
