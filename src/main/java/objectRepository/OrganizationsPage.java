package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage 
{
	//Declaration 
	@FindBy(xpath = "") 
	private WebElement CreateOrgLookUpImg;
		
	//Initialization 
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public WebElement getCreateOrgLookUpImg()
	{
		return CreateOrgLookUpImg;
	}
		
	//Business Library
	/**
	 * This method will click on create org look up image
	 */
	public void clickOnOrganizationLookUpImg()
	{
		CreateOrgLookUpImg.click();
	}

}
