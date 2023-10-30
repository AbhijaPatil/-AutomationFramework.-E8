package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of all generic methods related to webdriver actions
 * @author Abhija
 *
 */
public class WebDriverUtility 
{
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
		
	}
	
	/**
	 * This method is going to minimize the window	
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
		
	}
	
	/**
	 * This method will wait for the page to load
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait for a particular element to be visible in the DOM
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait for a particular element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method is used to select a drop down using index 
	 * @param driver
	 * @param index
	 */
	public void handleDropDown(WebElement driver, int index)
	{
		Select sel = new Select(driver);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method is used to select a drop down using value
	 * @param driver
	 * @param value
	 */
	public void handleDropDown(WebElement driver, String value)
	{
		Select sel = new Select(driver);
		sel.selectByValue(value);
	}
	
	/**
	 * This method is used to select a drop down using visible text
	 * @param driver
	 * @param value
	 */
	public void selectByVisibleText(String text, WebElement driver)
	{
		Select sel = new Select(driver);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * This method will perform mouse hover action
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will move the cursor based on the offset and click on web page 
	 * @param driver
	 */
	public void moveAndClick(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveByOffset(10, 10).perform();
	}
	/**
	 * This method is used to right click
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}
	
	/**
	 * This method is used to double click on the element
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	/**
	 * this method is used to drag and drop an element
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver, WebElement srcEle, WebElement dstEle)
	{
		Actions a = new Actions(driver);
		a.dragAndDrop(srcEle, dstEle).perform();
	}
	
	/**
	 * This method will handle the frame by name or ID
	 * @param driver
	 * @param nameorID
	 */
	public void switchToFrame(WebDriver driver, String nameorID)
	{
		driver.switchTo().frame(nameorID);
	}
	/**
	 * This method will handle the frame by index
	 * @param driver
	 * @param nameorID
	 * @param index 
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method will handle the frame by index
	 * @param driver
	 * @param nameorID
	 * @param index 
	 * @param element 
	 */
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * 	This method will scroll down by 500 units
	 * @param driver
	 */
	public void scrollDownAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", driver);
	}
	/**
	 * 	This method will scroll down by 500 units
	 * @param driver
	 */
	public void scrollUpAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-500)", driver);
	}
	
	/**
	 * This method is used to scroll using element reference
	 * @param driver
	 * @param element
	 */
	public void scrollToElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("argument[0].scrollIntoView(true)",element);
	}
	
	/**
	 * This method will accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

	/**
	 * This method will cancel the alert popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will fetch the alert text andd return it to the caller
	 * @param driver
	 * @return 
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	
	
	/**
	 * this method will take screenshot and return the dst path
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenshot(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshots"+screenshotName+".png");
		Files.copy(src, dst);
		return dst.getAbsolutePath(); // used for extent reports
	}
	
	/**
	 * This method will switch window from one window to another based on window title
	 * 
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		//Step 1: get all the window ID's
		Set<String> allWinIds = driver.getWindowHandles();
		
		//Step 2: Navigate through each window
		for(String winID: allWinIds)
		{
			//Step 3: Switch to each window and capture the title
			String actTitle = driver.switchTo().window(winID).getTitle();
			
			//Step 4: Compare actual title with expected partial title
			if(actTitle.contains(partialWinTitle))
			{
				break;
			}
		}
		
	}

}
