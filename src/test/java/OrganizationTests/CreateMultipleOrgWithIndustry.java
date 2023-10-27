package OrganizationTests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
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

public class CreateMultipleOrgWithIndustry extends BaseClass{
	//Preconditions should be automated first - so first we have to create Organization
	
		@Test(dataProvider = "getData")
		public void createMultipleOrg(String ORG, String INDUSTRYNAME) throws IOException, InterruptedException {
			
		// Step 1: Create all the required Objects
		JavaUtility jUtil = new JavaUtility();
//		ExcelFileUtility eUtil = new ExcelFileUtility();
//		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();	
//		WebDriver driver = null;
		
//		// Step 2: Read The Required Data
//		String BROWSER = pUtil.readDataFromStringPropertyFileString("browser");
//		String URL = pUtil.readDataFromStringPropertyFileString("url");
//		String USERNAME = pUtil.readDataFromStringPropertyFileString("username");
//		String PASSWORD = pUtil.readDataFromStringPropertyFileString("password");
		
		String ORGNAME = ORG+jUtil.getRandomNumber();

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
//		wUtil.maximizeWindow(driver);
//		wUtil.waitForPageLoad(driver);
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
		wUtil.takeScreenshot(driver, ORGNAME);
	
		// Step 9: Validate for Organization
		OrgInfoPage oip = new OrgInfoPage(driver);
		String orgHeader = oip.getHeaderText();
		if (orgHeader.contains(ORGNAME)) {
			System.out.println(orgHeader);
			System.out.println("Organization Created");
		} else {
			System.out.println("FAIL");
		}
		
//		//Step 10: logout of application
//		hp.logoutOfApp(driver);
//		
//		driver.close();	
		}

		@DataProvider
		public Object[][] getData() throws Throwable {
			return eUtil.readMultipleData("MultipleOrganizations");
		}

	}
