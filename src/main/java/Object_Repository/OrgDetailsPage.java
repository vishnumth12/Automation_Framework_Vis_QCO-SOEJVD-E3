package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgDetailsPage {

	@FindBy(className = "recordLabel  pushDown") private WebElement orgNameText;
	
	@FindBy(xpath = "(//ul[@class='module-qtip'])[4]") private WebElement cntctIcnBtn;
	
	public OrgDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameText() {
		return orgNameText;
	}

	public WebElement getCntctIcnBtn() {
		return cntctIcnBtn;
	}
	
	//business library
	public void getOrgName() {
		orgNameText.getText();
	}
	
	public void navToContactsPage() {
		cntctIcnBtn.click();
	}
}
