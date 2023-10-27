package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import Object_Repository.LoginPage;
import genericUtilities.WebDriverUtility;

//CreateContact
public class Scenario1WithDDT{
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		//Step 1: Read all the necessary Data
		
		 /*read data from property file-common data*/
		FileInputStream fisp = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties p = new Properties();
		p.load(fisp);
		String URL = p.getProperty("url");
		String BROWSER = p.getProperty("browser");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		 /*read data from excel-test data*/
		FileInputStream fise = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String LASTNAME = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
		
		WebDriver driver=null;
		
		//Step 2: Launch the Browser // Run Time Polymorphism - driver
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
		
		
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Step 2: Load the Application
		driver.get(URL);
		
		//Step 3: Login to Application
		
//		driver.findElement(By.id("username")).clear();
//		driver.findElement(By.id("password")).clear();
//		driver.findElement(By.id("username")).sendKeys(USERNAME);
//		driver.findElement(By.id("password")).sendKeys(PASSWORD);
//		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		LoginPage lp = new LoginPage(driver);
//		lp.getUserNameEdt().clear();
//		lp.getPwdEdt().clear();
//		lp.getUserNameEdt().sendKeys(USERNAME);
//		lp.getPwdEdt().sendKeys(PASSWORD);
//		lp.getSignInBtn().click();
		
		lp.loginToApp(USERNAME, PASSWORD); //Business library method for code optimization - not mandatory - cannot use if elements are from different web pages or POM CLASS
		
		//Step 4: Navigate to Contacts Link
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//span[@class='app-icon fa fa-bars'])[1]")));
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//span[text()=' MARKETING']")));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//span[text()=' Contacts'])[1]")));
		
		//Step 5: Click on create conatct look up Image
		js.executeScript("arguments[0].click();", driver.findElement(By.id("Contacts_listView_basicAction_LBL_ADD_RECORD")));
		
		//Step 6: create conatct
		driver.findElement(By.id("Contacts_editView_fieldName_lastname")).sendKeys(LASTNAME);
		
		//Step 7: Save
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@type='submit']")));
		
		//Step 8: Validate
		String contactHeader = driver.findElement(By.xpath("//span[@class='lastname']")).getText();
		
		if(contactHeader.contains(LASTNAME))
		{
			System.out.println("PASS");
			System.out.println(contactHeader);
		}
		else
		{
			System.out.println("FAIL");
		}
		
		
		//Step 9: Logout
		WebElement ele = driver.findElement(By.xpath("//img[@src='test/logo/vtiger-crm-logo.png']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		Thread.sleep(1000);
		
		js.executeScript("arguments[0].click();", driver.findElement(By.id("menubar_item_right_LBL_SIGN_OUT")));
		Thread.sleep(5000);
		
		System.out.println("SignOut successful");
		driver.close();
	}

}
