package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SnapDealLoginPage {
	
	//Declaration
		
		@FindBy(id = "j_id0:navbar:txtUserName") private WebElement emailTxtFld;
		
		@FindBy(id = "j_id0:navbar:txtPassword") private WebElement pwdTxtFld;
		
		@FindBy(name = "j_id0:navbar:j_id27") private WebElement loginBtn;
		
	//Initialization
		public SnapDealLoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

	//Utilization
		
		public WebElement getEmailTxtFld() {
			return emailTxtFld;
		}

		public WebElement getPwdTxtFld() {
			return pwdTxtFld;
		}

		public WebElement getLoginBtn() {
			return loginBtn;
		}

//BUSINESS LIBRARY
	public void loginToApp(String emailId, String pwd) {  
		emailTxtFld.sendKeys("emailId");
		pwdTxtFld.sendKeys("pwd");
		loginBtn.click();
		
	}
}

