package Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{

	@FindBy(xpath = "(//span[@class='app-icon fa fa-bars'])[1]") private WebElement appNavigator;
	
	@FindBy(xpath = "//span[text()=' MARKETING']") private WebElement marketingDd;
	
	@FindBy(xpath = "(//span[@class='module-name textOverflowEllipsis'])[4]") private WebElement contactsLink;
	
	@FindBy(xpath = "(//span[@class='module-name textOverflowEllipsis'])[1]") private WebElement orgLink;
	
	@FindBy(xpath = "//a[@class='userName dropdown-toggle']") private WebElement signOutDd;
	
	@FindBy(id = "menubar_item_right_LBL_SIGN_OUT") private WebElement signOutBtn;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getAppNavigator() {
		return appNavigator;
	}


	public WebElement getMarketingDd() {
		return marketingDd;
	}


	public WebElement getContactsLink() {
		return contactsLink;
	}


	public WebElement getSignOutDd() {
		return signOutDd;
	}


	public WebElement getSignOutBtn() {
		return signOutBtn;
	}
	
	//Business library
	/*
	 * 
	 */
	public void navToContactsPage(WebDriver driver){
//		JavascriptExecutor js = (JavascriptExecutor)driver;
		appNavigator.click();
//		js.executeScript("arguments[0].click();", driver.findElement(By.id("appNavigator")));
		mouseHoverAction(driver, marketingDd);
		contactsLink.click();
	}
	
	public void navToOrgPage(WebDriver driver){
//		JavascriptExecutor js = (JavascriptExecutor)driver;
		appNavigator.click();
//		js.executeScript("arguments[0].click();", driver.findElement(By.id("appNavigator")));
		mouseHoverAction(driver, marketingDd);
		orgLink.click();
	}
	
	public void logoutOfApp(WebDriver driver){
		signOutDd.click();
		signOutBtn.click();
	}
}
