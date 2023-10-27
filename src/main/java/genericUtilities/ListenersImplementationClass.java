package genericUtilities;

import java.io.IOException;

import javax.swing.text.html.HTML;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//listeners is applied to every class all tests in the class will be applied or can 
/**This class provides implementation to ITestListener interface of testNG
 * @author vishnu
 */
public class ListenersImplementationClass implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println("------------TEST script execution has STARTED-----------");
		
		//create a testscript - recognise each @Test
		test = report.createTest(testScriptName);
	}

	
	public void onTestSuccess(ITestResult result) {
		String testScriptName = result.getMethod().getMethodName();
		System.out.println("------------PASSED-----------");
		
		//log the sucess
		test.log(Status.PASS, testScriptName+"===PASS===");
	}

	
	public void onTestFailure(ITestResult result){
		
		//screenshot
		//exception for failure
		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println("------------FAILED------------");
		
		//screenshot
		String screenShotName  = testScriptName + new JavaUtility().getSystemDate();
		WebDriverUtility wutil  = new WebDriverUtility();
		try {
			
			String path = wutil.takeScreenshot(BaseClass.sDriver, screenShotName);
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//exception for failure
		System.out.println(result.getThrowable());
		
		//log for failure
		test.log(Status.FAIL, testScriptName+"===FAIL===");
		test.log(Status.INFO, result.getThrowable());
	}

	
	public void onTestSkipped(ITestResult result) {
		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println("------------SKIPPED------------");
		
		//exception for failure
		System.out.println(result.getThrowable());
		
		//log the SKIP
		test.log(Status.SKIP, testScriptName+"===SKIPPED===");
		test.log(Status.INFO, result.getThrowable());
	}

	
	public void onStart(ITestContext context) {
		
		System.out.println("------------SUITE execution has STARTED------------");	
		
		//Basic report configuration  , Reportname-17-10-2023-20-04-20.html
		ExtentSparkReporter html = new ExtentSparkReporter("./ExtentReports/Report-"+new JavaUtility().getSystemDate()+".html");
		html.config().setTheme(Theme.DARK);
		html.config().setDocumentTitle("Execution Report");
		html.config().setReportName("Vtiger execution report");
		
		report = new ExtentReports();
		report.attachReporter(html);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Reporter Name", "Vishnu");
	}

	
	public void onFinish(ITestContext context) {
		System.out.println("------------SUITE execution has FINISHED------------");	
		
		//Report Generation
		report.flush();
	}

}
