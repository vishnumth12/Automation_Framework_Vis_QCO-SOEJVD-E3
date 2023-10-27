package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactDetailsPage {

	@FindBy(xpath = "//span[@class='lastname']") private WebElement contactNameTxt;
	
	@FindBy(id = "Contacts_detailView_fieldValue_account_id") private WebElement orgNameTxt;
	
	public ContactDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactNameTxt() {
		return contactNameTxt;
	}

	public WebElement getOrgNameTxt() {
		return orgNameTxt;
	}
	
	//business library
	public void getOrgNameAndContact() {
		contactNameTxt.getText();
		orgNameTxt.getText();
	}
}
