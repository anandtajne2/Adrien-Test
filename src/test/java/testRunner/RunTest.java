package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "./src/test/resources/Features/1_Patient_Login.feature",
		"./src/test/resources/Features/2_Form_Step.feature" }, glue = { "stepDefinations" }, plugin = { "pretty",
				"html:target/HTMLReports", "json:target/JSONReports/report.json",
				"junit:target/JUNITReports/reports.xml" }, monochrome = true, dryRun = false, strict = false)
public class RunTest {

}