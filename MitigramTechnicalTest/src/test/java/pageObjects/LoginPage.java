package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver loginDriver() {
		return this.driver;
	}
	
	@FindBy(xpath = "//nav[@class='menu']//ul//li//a[contains(text(),'Login')]")
	private WebElement lnkLogin;
	
	@FindBy(xpath = "//nav[@class='menu']//ul//li//a[contains(text(),'Careers')]")
	private WebElement lnkCareers;

	@FindBy(name = "Email")
	private WebElement txtEmail;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement txtPassword;

	@FindBy(id = "loginBtn")
	private WebElement btnLogin;

	@FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
	private WebElement lnkForgotpwd;

	@FindBy(xpath = "//a[@href='https://apps.apple.com/app/mitigram/id1453993945']//img[@class='img-responsive']")
	private WebElement imgApple;

	@FindBy(xpath = "//a[@href='https://play.google.com/store/apps/details?id=com.mitigram.marketplace']//img[@class='img-responsive']")
	private WebElement imgGooglePlay;

	@FindBy(xpath = "//a[@target='_blank']")
	private WebElement lnkContactUs;
	
	@FindBy(xpath = "//div[@class='noty_body']")
	private WebElement lblWarningMsg;
	
	@FindBy(xpath = "//input[@value='Email Link']")
	private WebElement btnEmailLink;
	
	@FindBy(id = "Email")
	private WebElement txtEmailForgot;
	
	public void clickLogin() {
		lnkLogin.click();
	}
	
	public void clickCareersPageLink() {
		lnkCareers.click();
	}

	public void clearEmail() {
		txtEmail.clear();
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clearPassword() {
		txtPassword.clear();
	}
	
	public void clickLogintoPortal() {
		btnLogin.click();
	}

	public void clickForgotPassword() {
		lnkForgotpwd.click();
	}

	public void clickAppStore() {
		imgApple.click();
	}

	public void clickGooglePlay() {
		imgGooglePlay.click();
	}
	
	public void clickContactUs() {
		lnkContactUs.click();
	}
	
	public String getWarningMessage() {
		String warningMsg = lblWarningMsg.getText();
		return warningMsg;
	}
	
	public void clearForgotEmail() {
		txtEmailForgot.clear();
	}
	
	public void setForgotEmail(String email) {
		txtEmailForgot.sendKeys(email);
	}
	
	public void clickEmailLink() {
		btnEmailLink.click();
	}

}
