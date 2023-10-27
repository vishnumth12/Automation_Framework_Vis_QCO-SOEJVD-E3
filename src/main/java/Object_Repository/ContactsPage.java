package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	@FindBy(id = "Contacts_listView_basicAction_LBL_ADD_RECORD") private WebElement addContactsBtn;
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddContactsBtn() {
		return addContactsBtn;
	}
	
}
