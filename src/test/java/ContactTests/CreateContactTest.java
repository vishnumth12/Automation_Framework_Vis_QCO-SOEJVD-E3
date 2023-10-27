package ContactTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Object_Repository.ContactInfoPage;
import Object_Repository.CreateNewContactPage;
import Object_Repository.HomePage;
import Object_Repository.LoginPage;
import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;

@Listeners(genericUtilities.ListenersImplementationClass.class)
public class CreateContactTest extends BaseClass{

	@Test(groups = {"SmokeSuite", "RegressionSuite"})//(retryAnalyzer = genericUtilities.RetryAnalyzerImplementation.class)
	public void createContactTest() throws Throwable, InterruptedException {

	//Preconditions should be automated first - so first we have to create Organization
		
		// Step 1: Create all the required Objects
//		JavaUtility jUtil = new JavaUtility();
//		ExcelFileUtility eUtil = new ExcelFileUtility();
//		PropertyFileUtility pUtil = new PropertyFileUtility();
//		WebDriverUtility wUtil = new WebDriverUtility();
//		WebDriver driver = null;
		
		// Step 2: Read The Required Data
//		String BROWSER = pUtil.readDataFromStringPropertyFileString("browser");
//		String URL = pUtil.readDataFromStringPropertyFileString("url");
//		String USERNAME = pUtil.readDataFromStringPropertyFileString("username");
//		String PASSWORD = pUtil.readDataFromStringPropertyFileString("password");

		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 7, 2) + jUtil.getRandomNumber();
//
//		//Step 2: Launch the Browser // Run Time Polymorphism - driver
//		if(BROWSER.equalsIgnoreCase("chrome"))
//		{ 
//			driver = new ChromeDriver();
//			System.out.println(BROWSER+" launched");
//		}
//		else if(BROWSER.equalsIgnoreCase("firefox"))
//		{
//			driver = new FirefoxDriver();
//			System.out.println(BROWSER+" launched");
//		}
//		else if(BROWSER.equalsIgnoreCase("edge"))
//		{
//			driver = new EdgeDriver();
//			System.out.println(BROWSER+" launched");
//		}
//		else
//		{
//			System.out.println("Invalid Browser Name");
//		}
//		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//		//Step 3: Load the Application
//		driver.get(URL);
//
//		//Step 4: Log in to the Application
//		LoginPage lp = new LoginPage(driver);
//		lp.loginToApp(USERNAME, PASSWORD);
		
		//Step 6: Navigate to Contacts page
		HomePage hp = new HomePage(driver);
		hp.navToContactsPage(driver);
		Reporter.log("clicked create contacts link");
		
		
		//Step 9: Create new contact
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(driver, LASTNAME);
		Reporter.log("created new contact");
		
		//Step 10: validation
		ContactInfoPage cip = new ContactInfoPage(driver);
		Reporter.log("header captured");
		String contactHeader = cip.getHeaderText();
		System.out.println(cip.getHeaderText());
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		Reporter.log("header validated sucessfully");  //not shown in messages hence we can understand the part which is failed
//		Assert.fail();
//		//Step 10: logout of application
//		hp.logoutOfApp(driver);
//		
//		driver.close();
	}
	
//	@Test
//	public void name() {
//		System.out.println("name");
//	}
}
