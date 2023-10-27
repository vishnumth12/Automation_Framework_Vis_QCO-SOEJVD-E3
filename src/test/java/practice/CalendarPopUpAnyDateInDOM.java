package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtilities.WebDriverUtility;

public class CalendarPopUpAnyDateInDOM extends WebDriverUtility{

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		Actions a = new Actions(driver);
		a.moveByOffset(10, 10).click().perform();
		driver.findElement(By.xpath("//div[@class='fsw_inputBox dates inactiveWidget ']")).click();
		driver.findElement(By.xpath("//div[contains(@aria-label,'Oct 02 2023')]")).click();
		
		Thread.sleep(3000);
		driver.close();
	}
}
