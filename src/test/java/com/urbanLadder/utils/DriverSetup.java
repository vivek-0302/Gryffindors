package com.urbanLadder.utils;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverSetup {
	private WebDriver driver;

	@SuppressWarnings("deprecation")
	public WebDriver driverInstance(String browser) throws IOException {
		String fileName = System.getProperty("user.dir") + "/src/test/resources/DataSet.xlsx";
		String sheet = "Sheet4";
		String executionEnv = ConfigReader.getProperty("environment").toLowerCase();
		String browserType = ConfigReader.getProperty("browserType").toLowerCase();
		String os = ConfigReader.getProperty("os").toLowerCase();

		if (executionEnv.equals("remote")) {
		    DesiredCapabilities capabilities = new DesiredCapabilities();

		    switch (os) {
		        case "windows":
		            capabilities.setPlatform(Platform.WINDOWS);
		            break;
		        case "mac":
		            capabilities.setPlatform(Platform.MAC);
		            break;
		        case "linux":
		            capabilities.setPlatform(Platform.LINUX);
		            break;
		        default:
		            throw new IllegalArgumentException("Unsupported OS: " + os);
		    }

		    switch (browserType) {
		        case "chrome":
		            capabilities.setBrowserName("chrome");
		            break;
		        case "edge":
		            capabilities.setBrowserName("MicrosoftEdge");
		            break;
		        default:
		            throw new IllegalArgumentException("Unsupported browser: " + browser);
		    }

		    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

		}else if (executionEnv.equals("local")) {
		    if (browser.equalsIgnoreCase("chrome")) {
		        driver = new ChromeDriver();
		    } else if (browser.equalsIgnoreCase("edge")) {
		        driver = new EdgeDriver();
		    } else {
		        throw new IllegalArgumentException("Unsupported browser: " + browser);
		    }

		    
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(ExcelUtils.getCellData(fileName, sheet, 1, 0));

		return driver;
	}

	public void driverTearDown() {
		driver.quit();
	}

}


