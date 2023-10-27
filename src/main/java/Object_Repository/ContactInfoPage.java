package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	@FindBy(xpath = "//span[@class='lastname']") private WebElement contactHeaderText;
	
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getContactHeaderText() {
		return contactHeaderText;
	}
	
		//Business library
	/**
	 * This method will capture the header and return it to caller
	 * @return
	 */
		public String getHeaderText() {
			return contactHeaderText.getText();
		}
	}

