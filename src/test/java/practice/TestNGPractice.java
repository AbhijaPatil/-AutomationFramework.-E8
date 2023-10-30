package practice;

import org.testng.annotations.Test;

public class TestNGPractice
{
	@Test(priority = 2)
	public void createCustomer()
	{
		System.out.println("Customer");
	}
	
	@Test(priority = -2)
	public void modifyCustomer()
	{
		System.out.println("modify");
	}
	
	@Test(priority = -3)
	public void deleteCustomer()
	{
		System.out.println("Delete");
	}

}
