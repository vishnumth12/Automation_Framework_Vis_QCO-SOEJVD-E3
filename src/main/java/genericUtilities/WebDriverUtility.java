package genericUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author vishnu
 * This Class consists of all generic methods related to webdriver actions
 */
public class WebDriverUtility {
	
	//WebDriver driver = null; //Option 1 not helpful as driver value will be always null

	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) { //if we give driver as parameter then we can specify the updated driver executable as per requirement
		driver.manage().window().maximize();//driver launched and maximized
	}
	
	/**
	 * This method is going to minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();//driver launched and maximized
	}
	/**
	 * This method will wait for page to be loaded
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method will wait for a particular element to be visible in DOM
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will wait for a particular element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will handle dropdown by index
	 * @param dropdown
	 * @param index
	 */
	public void handleDropdown(WebElement dropdown, int index) {// here no need or driver as we are not using it
		Select s = new Select(dropdown);
		s.selectByIndex(index);
	}
	
	/**
	 * This method will handle dropdown by value
	 * @param dropdown
	 * @param value
	 */
	public void handleDropdown(WebElement dropdown, String value) {// here no need or driver as we are not using it
		Select s = new Select(dropdown);
		s.selectByValue(value);
	}
	
	/**
	 * This method will handle dropdown by visible text value
	 * @param text
	 * @param dropdown
	 */
	public void handleDropdown(String text, WebElement dropdown) {// here no need or driver as we are not using it
		Select s = new Select(dropdown);
		s.selectByVisibleText(text);
	}
	/**
	 * This method will double click on the webelement mentioned
	 * @param driver
	 * @param ele
	 */
	public void doubleClick(WebDriver driver,  WebElement ele) {
		Actions a = new Actions(driver);
		a.doubleClick().perform();
	}
	/**
	 * THis method will right click on the mentioned webelement
	 * @param driver
	 * @param ele
	 */
	public void rightClick(WebDriver driver,  WebElement ele) {
		Actions a = new Actions(driver);
		a.contextClick(ele).perform();
	}
	/**
	 * This method will perform drag and drop operation on a webelement
	 * @param driver
	 * @param ele1
	 * @param ele2
	 */
	public void dragAndDrop(WebDriver driver,  WebElement srcEle, WebElement destEle) {
		Actions a = new Actions(driver);
		a.dragAndDrop(srcEle, destEle).perform();
	}
	//complete actions class , javascript, frames etc h/w
	/**
	 * This method will move the cursor to the webelement
	 * @param driver
	 * @param ele
	 */
	public void mouseHoverAction(WebDriver driver,  WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();
	}
	/**
	 * This method will move the cursor based on offset and click on webelement
	 * @param driver
	 */
	public void moveAndClick(WebDriver driver) {
		Actions a = new Actions(driver);
		a.moveByOffset(10, 10).click().perform();
	}
	/**
	 * This method will move the cursor using actions class and click on webelement
	 * @param driver
	 * @param ele
	 */
	public void moveAndClick(WebDriver driver, WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).click().perform();
	}
	/**
	 * This method will click on the webelement using javascript
	 * @param driver
	 * @param ele
	 */
	public void javaScriptClick(WebDriver driver,  WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click;", ele);
	}
	
	/**
	 * This method will scroll the scroll bar to the webelement using javascript
	 * @param driver
	 * @param ele
	 */
	public void javaScriptScroll(WebDriver driver,  WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}
	
	/**
	 * This method will scroll the scroll bar to the webelement coordinates using javascript
	 * @param driver
	 * @param ele
	 */
	public void javaScriptScroll( WebElement ele, WebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Point p = ele.getLocation();
		int x= p.getX();
		int y= p.getY();
		js.executeScript("window.scrollBy(\" + x + \",\" + y + \")", ele);
	}
	
	/**
	 * This method will scroll the scroll bar down by 500 to the webelement using javascript
	 * @param driver
	 * @param ele
	 */
	public void javaScriptScrollDown(WebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 500)");
	}
	
	/**
	 * This method will scroll the scroll bar up by -500 to the webelement using javascript
	 * @param driver
	 * @param ele
	 */
	public void javaScriptScrollUp(WebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, -500)");
	}
	/**
	 * This method will dismiss the alert pop up
	 * @param driver
	 */
	public void alertPopUpAccept(WebDriver driver){
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will accept the alert pop up
	 * @param driver
	 */
	public void alertPopUpDismiss(WebDriver driver){
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will getText of the alert pop up 
	 * @param driver
	 */
	public String alertPopUpGetText(WebDriver driver){
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will handle the frame frame by frame index
	 * @param driver
	 * @param ele
	 */
	public void switchToFrame(WebDriver driver,  int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle the frame by frame String name or Id
	 * @param driver
	 * @param ele
	 */
	public void switchToFrame(WebDriver driver,  String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This method will handle the frame by using Webelement
	 * @param driver
	 * @param ele
	 */
	public void switchToFrame(WebDriver driver,  WebElement ele) {
		driver.switchTo().frame(ele);
	}
	
	/**
	 * This method will transfer the control to immediate parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will transfer the control from child frames or nested frames to the default webpage
	 * @param driver
	 */
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method is a generic method to switch control to a particular window based on its window title name
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle) {
		//Step 1: Get all window ids
		Set<String> allWindIds = driver.getWindowHandles();
		
		//Step 2: Navigate through all windows
		for (String winId : allWindIds) {
			
		//Step 3: Switch to each window and capture the title
		String winTitle = driver.switchTo().window(winId).getTitle();
		
		//Step 4: Compare actual title with expected partial title
		if (winTitle.contains(partialWinTitle)) {
			break;
		} 
	}
}

	/**
	 * This method will take screenshot and return the dst path
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenshot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE); //temporary location
		File dest = new File("./Screenshots/"+screenshotName+".png"); //system location
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath(); //used for extent reports
	}
}
