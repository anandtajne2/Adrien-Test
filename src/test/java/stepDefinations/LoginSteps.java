package stepDefinations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.LoginPage;
import pages.WelcomePage;

public class LoginSteps extends BaseClass {

	WebDriver driver = getDriver();

	// launching chrome browser

	// @Before
	// public void setup() throws IOException {
	// driver.manage().window().maximize(); // driver.manage().deleteAllCookies();
	// driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	// }

	@Given("Patient navigate to the welcome study page")
	public void patient_navigate_to_the_welcome_study_page() {
		driver.get(getPropertyValue("url"));
		// driver.get("https://mystudy.qa.medable.com/?org=pawabqaauto");
	}

	@When("Patient click on I have an accound button in welcome page")
	public void patient_click_on_I_have_an_accound_button_in_welcome_page() {
		welcomePage = new WelcomePage(driver);
		welcomePage.clickSignInButton();
	}

	@And("Patient should see the login page")
	public void patient_should_see_the_login_page() {
		// verify user is in login page or not
		loginPage = new LoginPage(driver);
		String actualValue = loginPage.verifyLoginPage();
		String expectedValue = "Log in to PAWEB QA Automation";
		// expectedValue is match then consider patient should see the login page
		Assert.assertEquals(expectedValue, actualValue);
	}

	@And("^Patient enter the email \"([^\"]*)\" in login page$")
	public void patient_enter_the_email_in_login_page(String email) {
		loginPage.setUserName(email);
	}

	@And("^Patient enter the password \"([^\"]*)\" in login page$")
	public void patient_enter_the_password_in_login_page(String password) {
		loginPage.setPassword(password);
	}

	@And("Patient click login button in login page")
	public void patient_click_login_button_in_login_page() {
		loginPage.clickLogin();

		// 1st time application ask for time zone before entering into Task page list
		loginPage.updateTimeZone();

	}

	@Then("Patient navigate to the activity list page")
	public void patient_navigate_to_the_activity_list_page() {
		String actualValue = driver.getCurrentUrl();
		String expectedValue = "https://mystudy.qa.medable.com/home";
		// if assert matches the consider patient navigated to the activity list page
		Assert.assertEquals(expectedValue, actualValue);
//		formSteps = new FormSteps();
	}

}
