package practice;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CalendarPopUpCurrentDate {
	
		public static void main(String[] args) throws InterruptedException {
			
			Date d = new Date();
			String[] dArr = d.toString().split(" ");
			String currentDate = dArr[0]+" "+dArr[1]+" "+dArr[2]+" "+dArr[5];
			System.out.println(currentDate);
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.makemytrip.com/");
			Actions a = new Actions(driver);
			a.moveByOffset(10, 10).click().perform();
			driver.findElement(By.xpath("//div[@class='fsw_inputBox dates inactiveWidget ']")).click();
			
			driver.findElement(By.xpath("//div[@aria-label='"+currentDate+"']")).click();
			
			Thread.sleep(5000);
			driver.close();
	}
}
