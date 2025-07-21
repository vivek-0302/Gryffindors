package StepDefinitions;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.urbanLadder.hooks.Hook;
import com.urbanLadder.pages.BeingAtHome;
import com.urbanLadder.pages.CheckOutPage;
import com.urbanLadder.pages.ConnectWithUs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ConnectWithUsDefinition {
	WebDriver driver;
	ConnectWithUs cnct;
	BeingAtHome b;
	CheckOutPage c;

	private static final Logger logger = LogManager.getLogger(ConnectWithUsDefinition.class);

	@Given("Click on the UrbanLadder logo")
	public void click_on_the_urban_ladder_logo() throws IOException {
//		driver = new ChromeDriver(); // Or use your driver setup method
//        driver.get("https://www.urbanladder.com");
		driver = Hook.driver;
		// BeingAtHome b= new BeingAtHome(driver);
		b = new BeingAtHome(driver); // ✅ THEN create page objects
		c = new CheckOutPage(driver);
		cnct = new ConnectWithUs(driver);

		b.searchBeingatHome();
		b.clickSearch();
		c.clickProduct();
		c.moveToCart();
		c.DoCheckOut();
		// c.passEmail();
		// c.DisplayErrorMsg();
		cnct.ClickOnLogo();
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
	}

	@Then("Scroll to the {string} section")
	public void scroll_to_the_section(String string) {
		cnct.Connect();
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
	}

	@Then("Display list of social media platforms with their URLs")
	public void display_list_of_social_media_platforms_with_their_ur_ls() {
		// Write code here that turns the phrase above into concrete actions
		cnct.DisplayConnections();
		// throw new io.cucumber.java.PendingException();
		logger.info("Displaying The list of social media Platforms");

	}
}
