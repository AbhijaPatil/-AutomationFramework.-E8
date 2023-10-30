package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario2 {

	public static void main(String[] args) throws InterruptedException 
	{
		//Launch browser
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
				driver.findElement(By.name("accountname")).sendKeys("Porche");
				driver.findElement(By.name("button")).click();
				//Log out of the application
				//using mouse hover for logging out
				
				  Thread.sleep(3000);
				  WebElement logout = driver.findElement(By.xpath("//img[@src = 'themes/softed/images/user.PNG']"));
				  
				  Actions a = new Actions(driver); a.moveToElement(logout).perform();
				  driver.findElement(By.linkText("Sign Out")).click();
				  
				  //Close the application
				  Thread.sleep(3000);
				  driver.close();

	}

}
