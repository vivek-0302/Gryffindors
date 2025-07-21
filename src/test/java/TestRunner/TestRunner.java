package TestRunner;

import org.testng.annotations.AfterSuite;

import com.urbanLadder.utils.AllureReportOpener;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = { "StepDefinitions",
		"com.urbanLadder.hooks" }, plugin = { "pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"html:target/htmlreport.html" }, monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {
	@AfterSuite
	public void afterSuite() {
		AllureReportOpener.openAllureReport();
	}
}
