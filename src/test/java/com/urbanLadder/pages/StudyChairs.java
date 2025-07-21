package com.urbanLadder.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudyChairs extends BasePage {
	public StudyChairs(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id='topnav_wrapper']/ul")
	WebElement topmenu;
	@FindBy(xpath = "//li[@class='topnav_item studyunit']")
	WebElement study;
	@FindBy(xpath = "//*[@id=\"topnav_wrapper\"]/ul/li[8]/div/div/ul/li[2]/ul/li[1]/a/span")
	WebElement studyChair;
	@FindBy(css = ".product.hovercard")
	WebElement firstThreeChairs;
	@FindBy(xpath = "(//div[@class='product-title product-title-sofa-mattresses']/span)[position()<=3]")
	List<WebElement> studyChairs;
	@FindBy(xpath = "(//div[@class='price-number']/span)[position()<=3]")
	List<WebElement> chairPrices;

	public static void explicitWait(WebElement element, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void moveToStudy() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", topmenu);
		Actions a = new Actions(driver);
		a.moveToElement(study).perform();
	}

	public void clickStudyChair() {
		// System.out.println(studyChair.getText());
		// explicitWait(studyChair,10);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", studyChair);
	}

	public void scrollToStudyChairs() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", firstThreeChairs);
	}

	public void DisplayChairsPrices() {
		for (int i = 0; i < 3; i++) {
			System.out.println(studyChairs.get(i).getText() + "-" + chairPrices.get(i).getText());

		}
	}

	public String[] name() {
		int i = 0;
		String[] res = new String[3];
		for (WebElement w : studyChairs) {
			res[i] = w.getText();
			i++;
		}
		return res;
	}

	public String[] price() {
		int i = 0;
		String[] res = new String[3];
		for (WebElement w : chairPrices) {
			res[i] = w.getText();
			i++;
		}
		return res;
	}
}
