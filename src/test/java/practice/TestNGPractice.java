package practice;

import org.testng.Assert;
import org.testng.annotations.Test;



public class TestNGPractice {

	@Test(invocationCount = 2, priority = 1)
	public  void createCustomer() {
		//Assert.fail();
		System.out.println("create");
	}
	
	@Test(priority =2, dependsOnMethods = "createCustomer", enabled = true)
	public  void modifyCustomer() {
		Assert.fail();
		System.out.println("modify");
	}
	
	@Test(priority =3, dependsOnMethods = "modifyCustomer")
	public  void deleteCustomer() {

		System.out.println("delete");
	}
}
