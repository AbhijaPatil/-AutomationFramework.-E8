package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage 
{
	
	//Declaration 
	@FindBy(xpath = "//span[@class = 'dvHeaderText']") 
	private WebElement OrgHeaderText;
	
	//Initialization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public WebElement getOrgHeaderText()
	{
		return OrgHeaderText;
	}
	
	//Business libraries
	/**
	 * This method will capture the header text and return it to the caller
	 * @return
	 */
	public String getHeaderText()
	{
		return OrgHeaderText.getText();
	}
	


}
