package Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrgPage {

	@FindBy(id = "Accounts_editView_fieldName_accountname") private WebElement orgNameFld;
	
	@FindBy(id = "s2id_autogen1") private WebElement industryDd;
	
	//@FindBy(xpath = "//div[text()='Apparel']") private WebElement apparelDdOptn;
	
	@FindBy(id = "s2id_autogen5") private WebElement typeDd;
	
	//@FindBy(xpath = "//div[text()='Analyst']") private WebElement analystDdOptn;
	
	@FindBy(xpath = "//button[@type='submit']") private WebElement saveBtn;
	
	public CreateNewOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameFld() {
		return orgNameFld;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//business library
	/**
	 * Create organization with only mandatory field
	 * @param orgName
	 */
	public void createOrg(String orgName) {
		orgNameFld.sendKeys(orgName);
		saveBtn.click();
	}
	/**
	 * Create organization with Industry
	 * @param orgName
	 * @param IndustryName
	 */
	public void createOrg(WebDriver driver, String orgName, String IndustryName) {
		orgNameFld.sendKeys(orgName);
		industryDd.click();
		driver.findElement(By.xpath("//div[text()='"+IndustryName+"']")).click();
		saveBtn.click();
	}
	/**
	 * Create organization with industry and type
	 * @param orgName
	 * @param IndustryName
	 * @param Type
	 */
	public void createOrg(WebDriver driver, String orgName, String IndustryName, String Type) {
		orgNameFld.sendKeys(orgName);
		industryDd.click();
		driver.findElement(By.xpath("//div[text()='"+IndustryName+"']")).click();
		typeDd.click();
		driver.findElement(By.xpath("//div[text()='"+Type+"']")).click();
		saveBtn.click();
	}
	
	
	
}
