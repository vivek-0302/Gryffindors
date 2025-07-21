package com.urbanLadder.hooks;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.urbanLadder.utils.*;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class Hook {
	public static WebDriver driver;
	static DriverSetup setup;
	public static String browser;
	public Logger logger;

	@Before
	public void setUp(Scenario scenario) {
		logger = LogManager.getLogger(this.getClass());
		browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
		setup = new DriverSetup();
		try {
			driver = setup.driverInstance(browser);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Reads URL from Excel

	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			Allure.addAttachment("Screenshot on Failure", new ByteArrayInputStream(screenshot));
		}
		if (driver != null) {
			setup.driverTearDown(); // Quits the browser
		}
	}

}
