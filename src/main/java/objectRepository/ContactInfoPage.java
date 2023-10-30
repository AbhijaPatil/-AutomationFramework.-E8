package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage
{
	//Declaration
	@FindBy(xpath = "//span[@class= 'dvHeaderText']")
	private WebElement ContactHeaderText;
	
	//Initialization
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public WebElement getContactHeaderText()
	{
		return ContactHeaderText;
	}
	
	//Business library 
	/**
	 * This method will capture the header text and return it to the caller
	 * @return
	 */
	public String getHeaderText()
	{
		return ContactHeaderText.getText();
	}
	
	
	
	

}
