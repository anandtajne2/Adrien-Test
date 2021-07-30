package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage {

	protected WebDriver driver;

	@FindBy(xpath = "//div[contains(@class,'styled__StyledWrapper')]//h1[text()='Form Step Task']")
	WebElement form_Step_Task;

	@FindBy(xpath = "//input[contains(@id,'email')]")
	WebElement emailFormStep1;

	@FindBy(xpath = "//input[contains(@id,'_text')]")
	WebElement textFormStep1;

	@FindBy(xpath = "//input[contains(@id,'_numeric')]")
	WebElement numericFormStep1;

	@FindBy(xpath = "//button[contains(@id,'_value_picker')]")
	WebElement valuePickerFormStep1;

	@FindBy(xpath = "//button[contains(@id,'_boolean_0')]")
	WebElement booleanFormStep1;


	public FormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getForm_Step_Task_Text() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class,'styled__StyledWrapper')]//h1[text()='Form Step Task']")));
		return form_Step_Task.getText();
	}

	public void setEmailFormStep1(String email) {
		emailFormStep1.sendKeys(email);
	}

	public void setTextFormStep1(String textSubStep) {
		textFormStep1.sendKeys(textSubStep);
	}

	public void setNumericFormStep1(String numericValue) {
		numericFormStep1.sendKeys(numericValue);
	}

	public void setValuePickerFormStep1() {
		valuePickerFormStep1.click();
		
	}

	public void setBooleanFormStep1(WebElement booleanFormStep1) {
		this.booleanFormStep1 = booleanFormStep1;
	}
}