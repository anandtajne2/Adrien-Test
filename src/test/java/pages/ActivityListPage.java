package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActivityListPage {

	protected WebDriver driver;

	@FindBy(xpath = "//a//p[text()='Form Step Task']")
	WebElement form_Step_Task;

	// @FindBy(xpath = "//div//h1[text()='Tasks']")
	// @FindBy(xpath = "//div[contains(@class,
	// 'commonStyles__StyledContainer')]/h1[text()='Tasks']")
	@FindBy(xpath = "//div[contains(@class, 'src__BackgroundContainer')]//h1[text()='Tasks']")
	WebElement text_Tasks;

	public ActivityListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void click_On_Form_Step_Task() throws InterruptedException {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", form_Step_Task);
		Thread.sleep(2000);
		form_Step_Task.click();
	}

	public String getText_Tasks() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class, 'src__BackgroundContainer')]//h1[text()='Tasks']")));
		return text_Tasks.getText();
	}

}