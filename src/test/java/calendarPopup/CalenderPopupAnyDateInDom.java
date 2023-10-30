package calendarPopup;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class CalenderPopupAnyDateInDom 
{

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.booking.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("onetrust-reject-all-handler")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder = 'Where are you going?']")).sendKeys("Berlin");
		driver.findElement(By.linkText("Berlin")).click();
		Actions a = new Actions(driver);
		a.moveByOffset(10, 10).click().perform();
		driver.findElement(By.linkText("Check-out Date")).click();

	}

}
