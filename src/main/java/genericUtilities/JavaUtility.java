package genericUtilities;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * This class consists of generic methods related to java
 * @author vishnu
 */
public class JavaUtility {
	/**
	 * 
	 * @return
	 */
	public int getRandomNumber() {
		Random ran = new Random();
		int r = ran.nextInt(10000);
		return r;
	}
	
	/**
	 * This method will capture the current date
	 * @return
	 */
	
	public String getSystemDate() {
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");//to change the format of default format of date class
		String date = formatter.format(d);
		return date;
	}
	
	public void openBrowser(String url) {
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
	}
}
