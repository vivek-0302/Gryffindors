package com.urbanLadder.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.urbanLadder.utils.*;

public class CheckOutPage extends BasePage {
	public CheckOutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//img[@title='Being At Home Furniture Yellow Abstract Wool 6 X 6 Feet Carpet']")
	WebElement item;
	@FindBy(xpath = "//button[@id='add-to-cart-button']")
	WebElement cart;
	@FindBy(xpath = "//div[@class='large-4 columns btn_wrap']//button[@id='checkout-link']")
	WebElement CheckOut;
	@FindBy(xpath = "//*[@id='order_email']")
	WebElement email;
	@FindBy(xpath = "//label[contains(@class, 'error') and contains(., 'valid email')]")
	WebElement errorMsg;

	public static void explicitWait(WebElement element, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void clickProduct() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", item);
		Set<String> windowId = driver.getWindowHandles();
		List<String> l = new ArrayList<>(windowId);
		driver.switchTo().window(l.get(1));
	}

	public void moveToCart() {
		// cart.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", cart);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(cart));
		js.executeScript("arguments[0].click();", cart);
	}

	public void DoCheckOut() {
		CheckOut.click();
	}

	public void passEmail() throws IOException {
		// email.sendKeys("123Zf0");
		ReadXML.readData();
		email.sendKeys(ReadXML.emailId);
		email.sendKeys(Keys.TAB);
	}

	public void DisplayErrorMsg() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement errorElement = wait.until(ExpectedConditions.visibilityOf(errorMsg));
		System.out.println(errorElement);
		System.out.println("---------------------------");
		System.out.println(errorMsg.getText());
		System.out.println("-----------------------------------");
	}

}
