package practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Demo1 {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo7.vtexperts.com/vtigercrm7demo/");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("username")).sendKeys("demo");
		driver.findElement(By.id("password")).sendKeys("demo");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.findElement(By.xpath("(//span[@class='app-icon fa fa-bars'])[1]")).click();
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//span[text()=' MARKETING']"))).perform();
		driver.findElement(By.xpath("(//span[text()=' Contacts'])[1]")).click();
		driver.findElement(By.id("Contacts_listView_basicAction_LBL_ADD_RECORD")).click();
		driver.findElement(By.id("Contacts_editView_fieldName_lastname")).sendKeys("Nick4");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Contact Id: "+driver.findElement(By.xpath("(//span[@class='value'])[2]")).getText());
		driver.findElement(By.xpath("//span[@class='fa fa-user']")).click();
		driver.findElement(By.id("menubar_item_right_LBL_SIGN_OUT")).click();
		driver.close();

	}

}
