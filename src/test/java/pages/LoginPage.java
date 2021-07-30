package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	@FindBy(xpath = "//input[@name='email' and @placeholder='Username']")
	@CacheLookup
	private WebElement txtEmail;

	@FindBy(xpath = "//input[@name='password' and @placeholder='Password']")
	@CacheLookup
	private WebElement txtPassword;

	@FindBy(xpath = "//button[text()='Log In']")
	@CacheLookup
	private WebElement loginButton;

	@FindBy(xpath = "//p[starts-with(text(),'Log in')]")
	private WebElement loginVerifyPage;

	@FindBy(xpath = "//div[@data-focus-lock-disabled='false']//button[text()='Update']")
	private WebElement timeZoneUpdate;

	protected WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String username) {
		txtEmail.clear();
		txtEmail.sendKeys(username);
	}

	public void setPassword(String password) {
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}

	public void clickLogin() {
		loginButton.click();
	}

	public String verifyLoginPage() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[starts-with(text(),'Log in')]")));
		return loginVerifyPage.getText();
	}

	public void updateTimeZone() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@data-focus-lock-disabled='false']//button[text()='Update']")));
			timeZoneUpdate.click();
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException its been handle " + e);
		} catch (TimeoutException e) {
			System.out.println("TimeoutException! its been handle " + e);
		}
	}

}
