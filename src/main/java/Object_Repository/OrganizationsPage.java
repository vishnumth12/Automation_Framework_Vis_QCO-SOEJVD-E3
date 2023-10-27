package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	@FindBy(id = "Accounts_listView_basicAction_LBL_ADD_RECORD") private WebElement addOrgBtn;
	
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddOrgBtn() {
		return addOrgBtn;
	}
	
}
