package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CareersPage;
import pageObjects.LoginPage;
import utilities.ReadConfig;
import utilities.ScreenshotCapture;

public class LoginSteps {

	public WebDriver driver;
	public LoginPage login;
	public CareersPage careers;
	public ReadConfig config = new ReadConfig();
	public Logger logger;
	public ScreenshotCapture screenShot = new ScreenshotCapture();

	@Given("User Launch {string}")
	public void user_launch(String webBrowser) {
		logger = Logger.getLogger("MitigramTestLogger");
		PropertyConfigurator.configure("log4j.properties");

		switch (webBrowser) {
		case "Chrome": {
			System.setProperty("webdriver.chrome.driver", config.getChromePath());
			driver = new ChromeDriver();
			logger.info("Chrome Browser is loaded");
			break;
		}
		case "Firefox": {
			System.setProperty("webdriver.gecko.driver", config.getFirefoxPath());
			driver = new FirefoxDriver();
			logger.info("FireFox Browser is loaded");
			break;
		}
		case "IExplorer": {
			System.setProperty("webdriver.ie.driver", config.getIEPath());
			driver = new InternetExplorerDriver();
			logger.info("Internet Explorer Browser is loaded");
			break;
		}
		default:
			System.setProperty("webdriver.gecko.driver", config.getFirefoxPath());
			driver = new FirefoxDriver();
			logger.info("Firefox Browser is loaded");
			break;
		}
		driver.manage().window().maximize();
		logger.info("Maximize the " + webBrowser + " browser");

		login = new LoginPage(driver);
		careers = new CareersPage(driver);
	}

	@When("User Opens URL {string}")
	public void user_opens_url(String url) {
		if (url != null) {
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			logger.info("Navigate to the URL");
		}
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
		if (title != null) {
			try {
				Assert.assertEquals(driver.getTitle(), title);
				logger.info("Validate Title of the webpage is success");

			} catch (Exception e) {
				logger.info("Validate Title of the webpage is Failure");
				screenShot.captureScreenshot(driver, "LoginSteps");
			}
		}
	}

	@When("User click LOGIN link")
	public void user_click_login_link() {
		try {
			login.clickLogin();
			logger.info("Clicked Login link");
		} catch (Exception e) {
			screenShot.captureScreenshot(driver, "Login");
		}
	}

	@Then("URL should be {string}")
	public void url_should_be(String url) {
		try {
			Assert.assertEquals(url, driver.getCurrentUrl());
			logger.info("Verify current URL is Success");
		} catch (Exception e) {
			logger.info("Verify current URL is Failure");
			screenShot.captureScreenshot(driver, "LoginSteps");
		}

	}

	@When("User Enters {string} to email")
	public void user_enters_email(String data) throws Exception {
		if (data != null) {
			login.clearEmail();
			login.setEmail(data);
			logger.info("Given " + data + " as e-mail address");
		}
		Thread.sleep(500);
	}

	@And("User Enters {string} to password")
	public void user_enters_password(String data) throws Exception {
		if (data != null) {
			login.clearPassword();
			login.setPassword(data);
			logger.info("Given password");
		}
		Thread.sleep(500);
	}

	@When("User click Login Button")
	public void user_click_login_button() {
		login.clickLogintoPortal();
		logger.info("clicked loggin");
	}

	@Then("Verify the Portal with {string}")
	public void navigate_to_mitigram_portal(String msg) {
		if (msg != null) {
			try {
				Assert.assertEquals(login.getWarningMessage(), msg);
				logger.info("Verify the warning message is success");
			} catch (AssertionError e) {
				logger.info("Verify the warning message is Failure");
				screenShot.captureScreenshot(driver, "LoginSteps");
			}
		}	
	}

	// Step Definitions of CareersTest Features

	@Then("User click CAREERS Link")
	public void user_click_careers_link() {
		careers.clickCareersPageLink();
		logger.info("Loading Career Page");		
	}

	@When("User Enters {string} to firstName")
	public void user_enters_to_first_name(String fName) {
		if (fName != null) {
			try {
				careers.clearFirstName();
				careers.SetFirstName(fName);
				logger.info("Defined " + fName + " as First Name");
			} catch (Exception e) {
				screenShot.captureScreenshot(driver, "CareersFirstName");
			}
		}
	}

	@When("User Enters {string} to lastName")
	public void user_enters_to_last_name(String lName) {
		if (lName != null) {
			try {
				careers.clearlastName();
				careers.SetLastName(lName);
				logger.info("Defined " + lName + " as Last Name");
			} catch (Exception e) {
				screenShot.captureScreenshot(driver, "CareersLastName");
			}
		}
	}

	@When("User Enters {string} to country")
	public void user_enters_to_country(String country) {
		if (country != null) {
			try {
				careers.clearCountry();
				careers.SetCountry(country);
				logger.info("Defined " + country + " as the Country");
			} catch (Exception e) {
				screenShot.captureScreenshot(driver, "CareersCountry");
			}
		}
	}

	@When("User Enters his {string} to email")
	public void user_enters_to_email(String email) {
		if (email != null) {
			try {
				careers.clearEMail();
				careers.setEMail(email);
				logger.info("Defined " + email + " as his Email");
			} catch (Exception e) {
				screenShot.captureScreenshot(driver, "CareersEmail");
			}
		}
	}

	@When("User Enters {string} to phone")
	public void user_enters_to_phone(String phone) {
		if (phone != null) {
			try {
				careers.clearPhone();
				careers.setPhone(phone);
				logger.info("Defined " + phone + " Phone No");
			} catch (Exception e) {
				screenShot.captureScreenshot(driver, "CareersPhone");
			}
		}
	}

	@When("User click Select {string} pdf file")
	public void user_click_select_pdf_file(String path) {
		try {
			Thread.sleep(500);
			careers.selectFile(path);
			Thread.sleep(500);
			logger.info("Uploaded PDF File");
			Thread.sleep(500);
		} catch (Exception e) {
			screenShot.captureScreenshot(driver, "CareersPDF");
		}
	}

	@When("user click Submit")
	public void user_click_submit() {
		try {
			careers.clickSubmit();
			logger.info("Submit the information");
			Thread.sleep(500);
		} catch (Exception e) {
			screenShot.captureScreenshot(driver, "CareersSubmit");
		}
	}
	
	@Then("Verify the Career Page with {string}")
	public void verify_the_career_page_with_messages(String msg) {
		if (msg != null) {
			try {
				Assert.assertEquals(careers.getPDFWarning(), msg);
				logger.info("Verify the warning message is success");
			} catch (AssertionError e) {
				logger.info("Verify the warning message is Failure");
				screenShot.captureScreenshot(driver, "CareersWarning");
			}
		}
	}
	
	@After
	public void tearoff() {
		driver.close();
		logger.info("Close the web browser");
	}
}
