package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {  //rule 1

	//rule 2 : declaration
	@FindBy(id = "username") private WebElement userNameEdt;
	
	@FindBy(id = "password") private WebElement pwdEdt;
	
	@FindBy(xpath = "//button[text()='Sign in']") private WebElement signInBtn;
	
	//rule 3 - Initialization
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);  //its an extended design pattern of POM - IT UPDATES THE DRIVER IF SESSION ID OF DRIVER EXPIRES
	}
	
	//rule : 4 Utilization   right clck > source > generate getters and setters > select getters

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPwdEdt() {
		return pwdEdt;
	}

	public WebElement getSignInBtn() {
		return signInBtn;
	}
	
	//Business Library - generic methods according to the need of project  - project specific business library - 
	/**
	 * This method will login to application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME, String PASSWORD) {
		userNameEdt.clear();
		pwdEdt.clear();
		userNameEdt.sendKeys(USERNAME);
		pwdEdt.sendKeys(PASSWORD);
		signInBtn.click();
	}
	

}
