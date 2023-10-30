package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility 
{
	//Declaration - dropdowns, frames, windows,text fields, pop ups
	@FindBy(linkText = "Organizations") 
	private WebElement organizationLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText = "Products")
	private WebElement producttLnk;
	
	@FindBy(xpath = "//img[@src = 'themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLnk;
	
	//Initialization 
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public WebElement getOrganizationLnk()
	{
		return organizationLnk;
	}
	
	public WebElement getContactsLnk()
	{
		return contactsLnk;
	}
	
	public WebElement getProductLnk()
	{
		return producttLnk;
	}
	
	public WebElement getAdministratorImg()
	{
		return administratorImg;
	}
	
	public WebElement getSignoutLnk()
	{
		return signoutLnk;
	}
	
	//Business Library
	/**
	 * This method will click on organization link
	 */
	public void clickOnOrganizationLink()
	{
		organizationLnk.click();
	}
	
	/**
	 * This method will click on Contacts link
	 */
	public void clickOnContactsLink()
	{
		contactsLnk.click();
	}
	
	public void logoutOfApp(WebDriver driver) throws InterruptedException
	{
		mouseHover(driver, administratorImg);
		Thread.sleep(2000);
		signoutLnk.click();
	}
	
	
	
	

}
