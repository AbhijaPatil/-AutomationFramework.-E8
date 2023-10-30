package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario4 {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title ='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("BMW6");
		//Industry drop down
		WebElement dropDown = driver.findElement(By.name("industry"));
		Select s = new Select(dropDown);
		s.selectByValue("Energy");
		
		//Selecting Customer in the type dropdown
		WebElement type = driver.findElement(By.name("accounttype"));
		Select s1 = new Select(type);
		s1.selectByValue("Customer");
		
		//using mouse hover for logging out
		
		  Thread.sleep(3000);
		  WebElement logout = driver.findElement(By.xpath("//img[@src = 'themes/softed/images/user.PNG']"));
		  
		  Actions a = new Actions(driver);
		  a.moveToElement(logout).perform();
		  driver.findElement(By.linkText("Sign Out")).click();
		  
		  //Close the application
		  Thread.sleep(3000);
		  driver.close();
		 
		
	}

}
