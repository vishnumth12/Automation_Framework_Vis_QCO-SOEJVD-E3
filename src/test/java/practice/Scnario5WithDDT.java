package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import Object_Repository.LoginPage;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;

public class Scnario5WithDDT {

	public static void main(String[] args) throws IOException, Throwable {
	//Preconditions should be automated first - so first we have to create Organization
		
		// Step 1: Create all the required Objects
		JavaUtility jUtil = new JavaUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		WebDriver driver = null;
		
		// Step 2: Read The Required Data
		String BROWSER = pUtil.readDataFromStringPropertyFileString("browser");
		String URL = pUtil.readDataFromStringPropertyFileString("url");
		String USERNAME = pUtil.readDataFromStringPropertyFileString("username");
		String PASSWORD = pUtil.readDataFromStringPropertyFileString("password");
		
		String ORGNAME = eUtil.readDataFromExcelFile("Contacts", 7, 3) + jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 7, 2) + jUtil.getRandomNumber();
	
		// Step 3: Launch the browser
		if (BROWSER.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
			System.out.println(BROWSER + " launched");
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
			System.out.println(BROWSER + " launched");
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
			System.out.println(BROWSER + " launched");
		} else {
			System.out.println("Invalid Browser Name");
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);

		// Step 4: Load the URL
		driver.get(URL);
		
		// Step 5: Login to Application
		
//		driver.findElement(By.id("username")).clear();
//		driver.findElement(By.id("password")).clear();
//		driver.findElement(By.id("username")).sendKeys(USERNAME);
//		driver.findElement(By.id("password")).sendKeys(PASSWORD);
//		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		
		//here we are not optimizing compared to above for that we need Business LIbrary
		LoginPage lp = new LoginPage(driver);
//		lp.getUserNameEdt().clear();
//		lp.getPwdEdt().clear();
//		lp.getUserNameEdt().sendKeys(USERNAME);
//		lp.getPwdEdt().sendKeys(PASSWORD);
//		lp.getSignInBtn().click();
		
		lp.loginToApp(USERNAME, PASSWORD);
		
		//Step 6: Navigate to Organizations Link
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Actions a = new Actions(driver);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//span[@class='app-icon fa fa-bars'])[1]")));
		a.moveToElement(driver.findElement(By.xpath("//span[text()=' MARKETING']")));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//span[text()=' Organizations'])[1]")));
		
		//Step 7: Create Organization
		js.executeScript("arguments[0].click();", driver.findElement(By.id("Accounts_listView_basicAction_LBL_ADD_RECORD")));
		driver.findElement(By.id("Accounts_editView_fieldName_accountname")).sendKeys(ORGNAME);
		
		//Step 8: Save
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
		
		//Step 10: Navigate to Contacts LInk
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//span[@class='app-icon fa fa-bars'])[1]")));
		a.moveToElement(driver.findElement(By.xpath("//span[text()=' MARKETING']")));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//span[text()=' Contacts'])[1]")));
		
		//Step 11: Click on create conatct look up Image
		js.executeScript("arguments[0].click();", driver.findElement(By.id("Contacts_listView_basicAction_LBL_ADD_RECORD")));
		
		//Step 12: create conatct
		driver.findElement(By.id("Contacts_editView_fieldName_lastname")).sendKeys(LASTNAME);
		
		// Step 13: click on Organization look Up Image
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//i[@id='Contacts_editView_fieldName_account_id_select']")));
		
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@class='btn btn-success']")));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[contains(text(),'"+ORGNAME+"')]")));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@data-bb-handler='confirm']")));
		
		// Orgname is dynamic
		// xpath is changing dynamically - dynamic xpath
		// a[text()='"+varible+"']
		
		
		//Step 14: Save
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@type='submit']")));
		
		//Step 15: Validate
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
		
		//Step  : Logout of application
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[@class='fa fa-user']")));
		js.executeScript("arguments[0].click();", driver.findElement(By.id("menubar_item_right_LBL_SIGN_OUT")));
		Thread.sleep(5000);
		driver.close();
		
	}

}
