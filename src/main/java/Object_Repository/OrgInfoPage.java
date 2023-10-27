package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage {

	@FindBy(xpath = "//span[@class='accountname']") private WebElement orgHeaderText;
	
	public OrgInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getOrgHeaderText() {
		return orgHeaderText;
	}
	
		//Business library
	/**
	 * This method will capture the header and return it to caller
	 * @return
	 */
		public String getHeaderText() {
			return orgHeaderText.getText();
		}
}
