package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class CreateOrganization {

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
		a.moveToElement(driver.findElement(By.xpath("//span[text()=' MARKETING']")));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//span[text()=' Organizations'])[1]")));
		js.executeScript("arguments[0].click();", driver.findElement(By.id("Accounts_listView_basicAction_LBL_ADD_RECORD")));
		driver.findElement(By.id("Accounts_editView_fieldName_accountname")).sendKeys("ACL");
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@type='submit']")));
		System.out.println("Organization Number: "+driver.findElement(By.xpath("(//span[@class='value'])[2]")).getText());
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[@class='fa fa-user']")));
		js.executeScript("arguments[0].click();", driver.findElement(By.id("menubar_item_right_LBL_SIGN_OUT")));
		Thread.sleep(5000);
		driver.close();
		
	}

}
