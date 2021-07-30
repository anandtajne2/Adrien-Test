package stepDefinations;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import pages.ActivityListPage;
import pages.FormPage;

public class FormSteps extends BaseClass {

	// WebDriver driver = getDriver();

	@Given("^Patient navigate to activity list as \"([^\"]*)\"$")
	public void patient_navigate_to_activity_list_as(String username) {
		System.out.println("patient_navigate_to_activity_list_as " + username);
		activityListPage = new ActivityListPage(driver);
		System.out.println(activityListPage.getText_Tasks());
	}

	@And("Patient select Form Step Task on activity list page")
	public void patient_select_Form_Step_Task_on_activity_list_page() throws InterruptedException {
		javasriptExecutor.executeScript("window.scrollBy(0,1200)");
		Thread.sleep(3000);
		activityListPage.click_On_Form_Step_Task();
	}

	@And("Patient should see Form Step Task task ready to start")
	public void patient_should_see_Form_Step_Task_task_ready_to_start() {
		formPage = new FormPage(driver);
		String actualText = formPage.getForm_Step_Task_Text();
		String expectedText = "Form Step Task";
		Assert.assertEquals(actualText, expectedText);
		System.out.println(actualText);
	}

	@And("Patient completes Form Step with values")
	public void patient_completes_Form_Step_with_values(DataTable dataTable) {
		List<Map<String, String>> formStepValuesList = dataTable.asMaps(String.class, String.class);

		// System.out.println(formStepValuesList);
		for (Map<String, String> map : formStepValuesList) {
			System.out.println(map.get("Type") + " " + map.get("Value"));
			switch (map.get("Type")) {
			case "Email Step":
				formPage.setEmailFormStep1(map.get("Value"));
				break;
			case "Text Step":
				formPage.setTextFormStep1(map.get("Value"));
				break;
			case "Numeric Step":
				formPage.setNumericFormStep1(map.get("Value"));
				break;
			case "Value Picker Step":
				formPage.setNumericFormStep1(map.get("Value"));
				break;
			default:
				break;
			}
		}
	}

	@And("Patient click next button is step page")
	public void patient_click_next_button_is_step_page() {
		System.out.println("Patient click next button is step page");
	}

	@And("Patient click skip button in step page")
	public void patient_click_skip_button_in_step_page() {
		System.out.println("Patient click skip button in step page");
	}

	@And("Patient should see the completion step page")
	public void patient_should_see_the_completion_step_page() {
		System.out.println("Patient should see the completion step page");
	}

	@And("Patient click done button in step page")
	public void patient_click_done_button_in_step_page() {
		System.out.println("Patient click done button in step page");
	}

	@Then("Patient should see the Activity list page")
	public void patient_should_see_the_Activity_list_page() {
		System.out.println("Patient should see the Activity list page");
	}

	@And("Patient should see Form Step Task completed")
	public void patient_should_see_Form_Step_Task_completed() {
		System.out.println("Patient should see Form Step Task completed");
	}

}
