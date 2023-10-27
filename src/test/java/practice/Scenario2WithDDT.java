package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;

public class Scenario2WithDDT {

	public static void main(String[] args) throws Throwable  {
		
		//Step 1: Create all required Objects
		WebDriver driver= null;
		JavaUtility jUtil = new JavaUtility();
		ExcelFileUtility exUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		
		//Step 2: Read the required Objects
		String BROWSER = pUtil.readDataFromStringPropertyFileString("browser");
		String URL = pUtil.readDataFromStringPropertyFileString("url");
		String USERNAME = pUtil.readDataFromStringPropertyFileString("username");
		String PASSWORD = pUtil.readDataFromStringPropertyFileString("password");
		
		String ORGNAME = exUtil.readDataFromExcelFile("Organizations", 1, 2) + jUtil.getRandomNumber();
		
		//Step 3: Launch the browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			System.out.println(BROWSER+" launched");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			System.out.println(BROWSER+" launched");
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
			System.out.println(BROWSER+" launched");
		}
		else
		{
			System.out.println("Invalid Browser Name");
		}
	
        wUtil.maximizeWindow(driver);
        wUtil.waitForPageLoad(driver);
        
        //Step 4: Load the url
        driver.get(URL);
        
        //Step 5: Login to application
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		//Step 5: Navigate to Orhanizations Link
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Actions a = new Actions(driver);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//span[@class='app-icon fa fa-bars'])[1]")));
		a.moveToElement(driver.findElement(By.xpath("//span[text()=' MARKETING']")));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//span[text()=' Organizations'])[1]")));
		
		//Step  : Create Organization
		js.executeScript("arguments[0].click();", driver.findElement(By.id("Accounts_listView_basicAction_LBL_ADD_RECORD")));
		driver.findElement(By.id("Accounts_editView_fieldName_accountname")).sendKeys(ORGNAME);
		
		//Step  : Save
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@type='submit']")));
		
		//Step  : Validate
		String orgName = driver.findElement(By.xpath("(//span[@class='value'])[1]")).getText();
		System.out.println("Organization Number: "+driver.findElement(By.xpath("(//span[@class='value'])[2]")).getText());
		if(orgName.contains(ORGNAME))
		{
			System.out.println("PASS");
			System.out.println(orgName);
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//Step  : Logout of application
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[@class='fa fa-user']")));
		js.executeScript("arguments[0].click();", driver.findElement(By.id("menubar_item_right_LBL_SIGN_OUT")));
		Thread.sleep(5000);
		driver.close();
	}

	}

