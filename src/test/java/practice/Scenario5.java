package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario5 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Navigation to contacts module
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title = 'Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("Sharma");
		driver.findElement(By.xpath("//input[@value ='  Save  ']")).click();
		
		//navigating to organization module
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt = 'Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("Lexus7");
		driver.findElement(By.xpath("//input[@title = 'Save [Alt+S]']")).click();
		
		//using mouse hover for logging out
		
		  Thread.sleep(3000);
		  WebElement logout = driver.findElement(By.xpath("//img[@src = 'themes/softed/images/user.PNG']"));
		  
		  Actions a = new Actions(driver); a.moveToElement(logout).perform();
		  driver.findElement(By.linkText("Sign Out")).click();
		 

		/*
		 * driver.findElement(By.xpath("//img[@src = 'themes/softed/images/user.PNG']"))
		 * .click(); driver.findElement(By.linkText("Sign Out")).click();
		 */
		Thread.sleep(3000);
		driver.close();
	}

}
