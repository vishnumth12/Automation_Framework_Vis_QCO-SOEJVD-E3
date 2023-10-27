package Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {

	@FindBy(xpath = "//input[@id='Contacts_editView_fieldName_lastname']") private WebElement conLastNameFld;

	@FindBy(id = "Contacts_editView_fieldName_account_id_select") private WebElement orgLkpIcn;

	@FindBy(xpath = "//input[@name='accountname']") private WebElement orgNameFld;

	@FindBy(xpath = "//button[@data-trigger='PopupListSearch']") private WebElement srchBtn;

	@FindBy(id = "Contacts_listView_basicAction_LBL_ADD_RECORD") private WebElement contSelct;

	@FindBy(id = "Contacts_listView_basicAction_LBL_ADD_RECORD") private WebElement orgClick;

	@FindBy(xpath = "//button[@data-bb-handler='confirm']") private WebElement popupYes;

	@FindBy(xpath = "//button[@type='submit']") private WebElement saveBtn;

	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNameFld() {
		return conLastNameFld;
	}

	public WebElement getOrgLkpIcn() {
		return orgLkpIcn;
	}

	public WebElement getOrgNameFld() {
		return orgNameFld;
	}

	public WebElement getSrchBtn() {
		return srchBtn;
	}

	public WebElement getOrgSelct() {
		return contSelct;
	}

	public WebElement getPopupYes() {
		return popupYes;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	//BUSINESS LIBRARY
	/**
	 * This method will create a contact selecting an organization
	 * @param driver
	 * @param LASTNAME
	 * @param newOrgName
	 */
	public void createContactWithOrg(WebDriver driver, String LASTNAME, String ORGNAME) {
		contSelct.click();
		conLastNameFld.sendKeys(LASTNAME);	
		orgLkpIcn.click();
		orgNameFld.sendKeys(ORGNAME);
		srchBtn.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")));
		popupYes.click();
		saveBtn.click();
	}

	public void createContact(WebDriver driver, String LASTNAME) {
		contSelct.click();
		conLastNameFld.sendKeys(LASTNAME);	
		saveBtn.click();
		}
	}

