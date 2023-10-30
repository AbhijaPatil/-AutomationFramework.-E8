package webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Scenario4 {

	public static void main(String[] args) throws InterruptedException 
	{
		//Step 1: Launch the browser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		//Step 2: Navigate to Vtiger application
		driver.get("http://localhost:8888/");
		
		//Login to the application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3: navigate to organizations page
		driver.findElement(By.linkText("Organizations")).click();
		Thread.sleep(2000);
		
		//Step 4: Check in the 5th check box
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[7]/td[1]/input")).click();
		
		//Step 5: Close the page
		driver.quit();

	}

}
