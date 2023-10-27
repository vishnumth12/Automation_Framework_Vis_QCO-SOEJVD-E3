package genericUtilities;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import Object_Repository.HomePage;
import Object_Repository.LoginPage;

/**This class consists of all the basic configuration of testNg
 * @author vishnu
 */
public class BaseClass {
	
	public JavaUtility jUtil = new JavaUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public WebDriver driver = null;
	//used in listeners
	public static WebDriver sDriver;
	
	
//	@BeforeSuite (groups = {"SmokeSuite", "RegressionSuite"})
	@BeforeSuite (alwaysRun = true)
	public void bsConfig() {
		System.out.println("-------------DB connection sucessful----------------");
	}
//	@Parameters("browser")
//	@BeforeTest //for parallel run
	@BeforeClass (alwaysRun = true)
	public void bcConfig(/*String BROWSER*/) throws Throwable {
		String BROWSER = pUtil.readDataFromStringPropertyFileString("browser");
		String URL = pUtil.readDataFromStringPropertyFileString("url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{ 
			driver = new ChromeDriver();
			System.out.println(BROWSER+" launched");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			//WebDriverManager.firefoxdriver().setup();
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
		
		//used in listeners
		sDriver = driver;
		//Step 3: Load the Application
		driver.get(URL);
		
	}
	@BeforeMethod (alwaysRun = true)
	public void bmConfig() throws Throwable {
		
		String USERNAME = pUtil.readDataFromStringPropertyFileString("username");
		String PASSWORD = pUtil.readDataFromStringPropertyFileString("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("-------------Login Successful----------------");
		
	}
	@AfterMethod (alwaysRun = true)
	public void amConfig() {
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		
		System.out.println("-------------Logout Successful----------------");
	}
	
//	@AfterTest //for parallel run
	@AfterClass (alwaysRun = true)
	public void acConfig() {
		driver.close();
		
		System.out.println("-------------Browser Closed----------------");
		
	}
	
	
	@AfterSuite (alwaysRun = true)
	public void asConfig() {
		System.out.println("-------------DB connection Closed----------------");
	}

}
