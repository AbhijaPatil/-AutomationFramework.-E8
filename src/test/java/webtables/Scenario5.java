package webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Scenario5 
{
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
		
		//Step 4: Click on the 6th check box
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[6]/td[1]/input")).click();
		
		//Step 5: Capture the organization name 
		String orgName = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[6]/td[3]/a")).getText();
		System.out.println(orgName);
		Thread.sleep(2000);
		
		//Step 6: Delete the selected organization
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[6]/td[8]/a[text() = 'del']")).click();
		
		driver.switchTo().alert().accept();
		
		//Step 7: close the browser
		driver.quit();
	}

}
