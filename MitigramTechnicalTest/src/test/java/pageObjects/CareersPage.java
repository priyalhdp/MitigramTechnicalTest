package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CareersPage {
	WebDriver driver;

	public CareersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//nav[@class='menu']//ul//li//a[contains(text(),'Careers')]")
	private WebElement lnkCareersPage;

	@FindBy(xpath = "//a[contains(text(),'careers@mitigram.com')]")
	private WebElement lnkemail;

	@FindBy(xpath = "//input[@id='first_name']")
	private WebElement txtFName;

	@FindBy(xpath = "//input[@id='last_name']")
	private WebElement txtLName;

	@FindBy(xpath = "//input[@id='country']")
	private WebElement txtCountry;

	@FindBy(id = "email")
	private WebElement txtEMail;

	@FindBy(xpath = "//input[@id='phone']")
	private WebElement txtPhone;

	@FindBy(xpath = "//span[@class='file-msg']")
	private WebElement btnFile;

	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	private WebElement btnSubmit;

	@FindBy(xpath = "//a[contains(text(),'Privacy Policy')]")
	private WebElement lnkPrivacy;

	@FindBy(xpath = "//a[contains(text(),'Terms of Service')]")
	private WebElement lnkTerms;

	@FindBy(xpath = "//div[@class='mat-form-field-subscript-wrapper']")
	private WebElement msgPdfFile;

	public void clickCareersPageLink() {
		System.out.println("Inside 123");
		lnkCareersPage.click();
	}

	public void clickContactUsEmail() {
		lnkemail.click();
	}

	public void clearFirstName() {
		txtFName.clear();
	}

	public void SetFirstName(String fName) {
		txtFName.sendKeys(fName);
	}

	public void clearlastName() {
		txtLName.clear();
	}

	public void SetLastName(String lName) {
		txtLName.sendKeys(lName);
	}

	public void clearCountry() {
		txtCountry.clear();
	}

	public void SetCountry(String country) {
		txtCountry.sendKeys(country);
	}

	public void clearEMail() {
		txtEMail.clear();
	}

	public void setEMail(String email) {
		txtEMail.sendKeys(email);
	}

	public void clearPhone() {
		txtPhone.clear();
	}

	public void setPhone(String phone) {
		txtPhone.sendKeys(phone);
	}

	public void selectFile(String path) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		List<WebElement> allItems = driver
				.findElements(By.xpath("//input[@type='file']"));
		for (WebElement oneItem : allItems) {
			if (oneItem.isDisplayed()) {
				js.executeScript("arguments[0].removeAttribute('disabled','disabled')", oneItem);
				js.executeScript("arguments[0].removeAttribute('hidden','hidden')", oneItem);
				oneItem.sendKeys(path);
				break;
			}
		}
	}

	public void clickSubmit() {
		btnSubmit.click();
	}

	public void clcikPrivacySPolicy() {
		lnkPrivacy.click();
	}

	public void clickTermsofService() {
		lnkTerms.click();
	}
	
	public String getPDFWarning() {
		String msg= msgPdfFile.getText();

		return msg;
	}

}
