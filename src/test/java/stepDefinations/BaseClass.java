package stepDefinations;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ActivityListPage;
import pages.FormPage;
import pages.LoginPage;
import pages.WelcomePage;
import utilities.Helper;

public class BaseClass {

	protected static WebDriver driver;

	// Page Object Model's
	WelcomePage welcomePage;
	LoginPage loginPage;
	FormSteps formSteps;
	ActivityListPage activityListPage;
	FormPage formPage;

	// using javascript executor for page scroll
	JavascriptExecutor javasriptExecutor = (JavascriptExecutor) driver;

	// use property config file
	// Properties properties;

	// for adding cookies
	// Cookie cookie1, cookie2;

	@Before
	protected WebDriver getDriver() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			// WebDriverManager.firefoxdriver().setup();
			// driver = new FirefoxDriver();
			// WebDriverManager.edgedriver().setup();
			// driver = new EdgeDriver();

			// keep showing me exception for invalid cookies
			// cookie1 = new Cookie("x-md-web-apps-deployment", "production");
			// cookie2 = new Cookie("x-md-web-apps-version", "1.3.2-rc.5");
			// driver.manage().addCookie(cookie1);
			// driver.manage().addCookie(cookie2);
		}
		return driver;
	}

	protected String getPropertyValue(String property) {
		return Helper.getProperty(property);
	}
}