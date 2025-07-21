package StepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.urbanLadder.hooks.Hook;
import com.urbanLadder.pages.Showcases;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShowCasesDefinition {
	WebDriver driver;
	Showcases showcasePage;
	private static final Logger logger = LogManager.getLogger(StudyChairsDefinition.class);

	@Given("the user is on the Urban Ladder homepage")
	public void the_user_is_on_the_urban_ladder_homepage() {
		driver = Hook.driver;
		showcasePage = new Showcases(driver);
	}

	@When("the user hovers over the {string} menu")
	public void the_user_hovers_over_the_menu(String menuName) {
		// Assuming menuName is "Living"
		showcasePage.moveToLiving();
	}

	@When("the user clicks on {string}")
	public void the_user_clicks_on(String linkText) {
		// Assuming linkText is "Showcases"
		showcasePage.clickshowcases();
	}

	@When("the user selects {string} under storage type filter")
	public void the_user_selects_under_storage_type_filter(String storageType) {
		// Assuming storageType is "Closed"
		showcasePage.closedType();
	}

	@When("the user excludes out-of-stock items")
	public void the_user_excludes_out_of_stock_items() {
		showcasePage.clickExcludeStock();
	}

	@Then("the user should see the names and prices of the top {int} showcase items")
	public void the_user_should_see_the_names_and_prices_of_the_top_showcase_items(Integer count) {
		showcasePage.displayNamesandPrices();
		logger.info("Displaying The Top Three Show cases");

	}
}
