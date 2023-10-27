package OrganizationTests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Object_Repository.CreateNewOrgPage;
import Object_Repository.HomePage;
import Object_Repository.LoginPage;
import Object_Repository.OrgInfoPage;
import Object_Repository.OrganizationsPage;
import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;

public class CreateOrgWithIndustryTest extends BaseClass{
	
	@Test
	public void createOrgWithIndustryTest() throws Throwable {
		
	//Preconditions should be automated first - so first we have to create Organization
		
		// Step 1: Create all the required Objects
		JavaUtility jUtil = new JavaUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
//		PropertyFileUtility pUtil = new PropertyFileUtility();
//		WebDriverUtility wUtil = new WebDriverUtility();
//		WebDriver driver = null;
		
		// Step 2: Read The Required Data
//		String BROWSER = pUtil.readDataFromStringPropertyFileString("browser");
//		String URL = pUtil.readDataFromStringPropertyFileString("url");
//		String USERNAME = pUtil.readDataFromStringPropertyFileString("username");
//		String PASSWORD = pUtil.readDataFromStringPropertyFileString("password");
		
		String ORGNAME = eUtil.readDataFromExcelFile("Organizations", 4, 2) + jUtil.getRandomNumber();
		String INDUSTRYNAME = eUtil.readDataFromExcelFile("Organizations", 4, 3);

		//Step 2: Launch the Browser // Run Time Polymorphism - driver
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
//		lp.loginToApp(USERNAME, PASSWORD); //Business library method for code optimization - not mandatory - cannot use if elements are from different web pages or POM CLASS

		//Step 5: Navigate to Organization page
		HomePage hp = new HomePage(driver);
		hp.navToOrgPage(driver);
		
		//Step 6: Click on add org button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getAddOrgBtn().click();
		
		//Step 7: Create new org
		CreateNewOrgPage cnop = new CreateNewOrgPage(driver);
		cnop.createOrg(driver, ORGNAME, INDUSTRYNAME);
		
		//Step 10: validation
		OrgInfoPage oip = new OrgInfoPage(driver);
		System.out.println(oip.getHeaderText());
		jUtil.getSystemDate();
		
		//Step 10: logout of application
//		hp.logoutOfApp(driver);
//		
//		driver.close();

	}
}
