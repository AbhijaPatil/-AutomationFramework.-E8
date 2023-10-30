package contactsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
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

public class CreateContactWithOrganizationTest extends BaseClass
{
	
	
	@Test(groups = {"SmokeSuite","ReggressionSuite"})
	public void createContactWithOrgTest() throws IOException, InterruptedException
	{
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 7, 3)+jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 7, 2);
		
			
		//Step 6: Click on Organization
		HomePage hp =new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//Step 7: Click on create organization look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnOrganizationLookUpImg();
		
		//Step 8: Create new Organization with mandatory fields
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.CreateNewOrganization(ORGNAME);
		
		//Step 9: Validate for organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getHeaderText();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader);
		
		
		//Step 10: Click on Contacts link
		hp.clickOnContactsLink();
		
		//Step 11: Click on create contact look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookupImg();
		
		//Step 12: Create contact with organization
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(driver, LASTNAME, ORGNAME);
		
		//Step 13: Validation 
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getHeaderText();
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);
		
	}

}
