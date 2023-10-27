package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(genericUtilities.ListenersImplementationClass.class)
public class AssertionsPractice {

	@Test
	public void practice(){
		System.out.println("Step 1");
		System.out.println("Step 2");
		
//		if (1==1) {
//			System.out.println("pass");
//		} else {
//			System.out.println("fail");
//		}
		
		Assert.assertEquals(1, 1);
//		Assert.assertEquals(false, true);
//		Assert.assertTrue(false);
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(1, 0);
		sa.assertAll();
		Assert.assertEquals(true, false);
		sa.assertEquals(true, false);
		System.out.println("Step 3");
		System.out.println("Step 4");
		sa.assertAll();//logs error of failing scripts
	}
}
