package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility 
{
	//Declaration
	@FindBy(name = "accountname") 
	private WebElement OrgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement IndustryDropDwn;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//Initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public WebElement getOrgNameEdt()
	{
		return OrgNameEdt;
	}
	
	public WebElement getIndustryDropDwn()
	{
		return IndustryDropDwn;
	}
	
	public WebElement gettypeDropDown()
	{
		return typeDropDown;
	}
	
	public WebElement getSaveBtn()
	{
		return SaveBtn;
	}
	//Business libraries
	/**
	 * This method will create new organization with mandatory fields
	 * @param ORGNAME
	 */
	public void CreateNewOrganization(String ORGNAME)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		SaveBtn.click();
	}
	
	/**
	 * This method will create organization with Industry drop down
	 * * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void CreateNewOrganization(String ORGNAME, String INDUSTRY)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropDown(IndustryDropDwn,INDUSTRY);
		SaveBtn.click();
	}
	
	/**
	 * This method will create organization with Industry and type drop down
	 * @param ORGNAME
	 * @param INDUSTRY
	 * @param TYPE
	 */
	public void CreateNewOrganization(String ORGNAME, String INDUSTRY, String TYPE)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropDown(IndustryDropDwn,INDUSTRY);
		handleDropDown(typeDropDown, TYPE);
		SaveBtn.click();
	}

}
