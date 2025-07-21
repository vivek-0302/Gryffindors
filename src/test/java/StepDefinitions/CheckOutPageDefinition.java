package StepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.urbanLadder.hooks.*;
import com.urbanLadder.pages.BeingAtHome;
import com.urbanLadder.pages.CheckOutPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckOutPageDefinition {
	WebDriver driver;
	CheckOutPage chk;
	private static final Logger logger = LogManager.getLogger(CheckOutPageDefinition.class);

	@Given("click on a specific Being At Home carpet item")
	public void click_on_a_specific_being_at_home_carpet_item() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		driver = Hook.driver;
//		driver = new ChromeDriver(); // Or use your driver setup method
//        driver.get("https://www.urbanladder.com");
		BeingAtHome b = new BeingAtHome(driver);
		b.searchBeingatHome();
		b.clickSearch();
		chk = new CheckOutPage(driver);
		chk.clickProduct();
		// throw new io.cucumber.java.PendingException();
	}

	@When("I add the item to the cart")
	public void i_add_the_item_to_the_cart() {
		// Write code here that turns the phrase above into concrete actions
		chk.moveToCart();
		// throw new io.cucumber.java.PendingException();
	}

	@When("I proceed to checkout")
	public void i_proceed_to_checkout() {
		// Write code here that turns the phrase above into concrete actions
		chk.DoCheckOut();
		// throw new io.cucumber.java.PendingException();
	}

	@When("I enter an invalid email address")
	public void i_enter_an_invalid_email_address() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		chk.passEmail();
		// throw new io.cucumber.java.PendingException();
	}

	@Then("I should see an error message indicating invalid email")
	public void i_should_see_an_error_message_indicating_invalid_email() {
		// Write code here that turns the phrase above into concrete actions
		chk.DisplayErrorMsg();
		// throw new io.cucumber.java.PendingException();
		logger.info("Displaying Invalid Error Message");

	}

}
