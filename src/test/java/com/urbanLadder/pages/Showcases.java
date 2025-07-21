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

public class Showcases extends BasePage {

	public Showcases(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//li[@class='topnav_item livingunit']//span[@class='topnav_itemname']")
	WebElement living;
	@FindBy(xpath = "//*[@id=\"topnav_wrapper\"]/ul/li[4]/div/div/ul/li[2]/ul/li[5]/a")
	WebElement showCases;
	@FindBy(xpath = "//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[3]/div[1]")
	WebElement showcaseStorageType;
	@FindBy(xpath = "//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[3]/div[2]/div/div/div/ul/li[1]/label")
	WebElement showcaseClosed;
	@FindBy(xpath = "//*[@id=\"filters-form\"]/div[2]/div/label")
	WebElement showcaseexcludeStock;
	@FindBy(xpath = "(//div[@class='product-title product-title-sofa-mattresses']/span)[position()<=3]")
	List<WebElement> showcaseitemname;
	@FindBy(xpath = "(//div[@class='price-number']/span)[position()<=3]")
	List<WebElement> showcaseprice;

	public static void explicitWait(WebElement element, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void moveToLiving() {
		Actions a = new Actions(driver);
		a.moveToElement(living).perform();
	}

	public void clickshowcases() {

		explicitWait(showCases, 10);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", showCases);

	}

	public void closedType() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", showcaseStorageType);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(showcaseStorageType)).click();

		wait.until(ExpectedConditions.visibilityOf(showcaseClosed));
		wait.until(ExpectedConditions.elementToBeClickable(showcaseClosed));

		js.executeScript("arguments[0].click();", showcaseClosed);

	}

	public void clickExcludeStock() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true);", showcaseexcludeStock);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(showcaseexcludeStock));

		js.executeScript("arguments[0].click();", showcaseexcludeStock);

	}

	public void displayNamesandPrices() {

		for (int i = 0; i < 2; i++) {
			explicitWait(showcaseitemname.get(i), 10);
			System.out.println(showcaseitemname.get(i).getText() + "-" + showcaseprice.get(i).getText());
		}
	}
}
