package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericUtilities.WebDriverUtility;

public class CreateContactandSelectOrganization {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo7.vtexperts.com/vtigercrm7demo/");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("username")).sendKeys("demo");
		driver.findElement(By.id("password")).sendKeys("demo");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//span[@class='app-icon fa fa-bars'])[1]")));
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//span[text()=' MARKETING']"))).perform();
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//span[text()=' Contacts'])[1]")));
		js.executeScript("arguments[0].click();", driver.findElement(By.id("Contacts_listView_basicAction_LBL_ADD_RECORD")));
		driver.findElement(By.id("Contacts_editView_fieldName_lastname")).sendKeys("Nick4");
		a.moveToElement(driver.findElement(By.xpath("(//span[@class='input-group-addon relatedPopup cursorPointer'])[1]"))).click().perform();
		WebDriverUtility utilitiesDriverUtility= new WebDriverUtility();
		utilitiesDriverUtility.takeScreenshot(driver, "screen");
		a.moveToElement(driver.findElement(By.xpath("(//td[@title='GCL'])[1]"))).click().perform();
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@type='submit']")));
		Thread.sleep(10000);
		System.out.println("Contact Id: "+driver.findElement(By.xpath("(//span[@class='value'])[2]")).getText());
		
		driver.close();
	}

}
