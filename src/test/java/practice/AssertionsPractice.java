package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice 
{
	@Test
	public void practice()
	{
		SoftAssert sa = new SoftAssert();
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		sa.assertEquals(false, true); //failed
		
		
		System.out.println("Step 3");
		System.out.println("Step 4");
		
		Assert.assertEquals(0, 1); //failed
		
		sa.assertEquals("A", "A"); //passed
		sa.assertAll();
	}

}
