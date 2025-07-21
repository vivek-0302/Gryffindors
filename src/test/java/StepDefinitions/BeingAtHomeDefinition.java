package StepDefinitions;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.urbanLadder.hooks.*;
import org.openqa.selenium.WebDriver;

import com.urbanLadder.pages.BeingAtHome;
import com.urbanLadder.utils.ExcelUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class BeingAtHomeDefinition {
	WebDriver driver;
    BeingAtHome beingatHomePage;
    String xlFile = System.getProperty("user.dir") + "/src/test/resources/DataSet.xlsx", beingAtHomesSheet = "Sheet2";
	String[] beingAtHome;
    private static final Logger logger=LogManager.getLogger(BeingAtHomeDefinition.class);

    @Given("I search for {string}")
    public void i_search_for(String searchTerm) throws IOException {
       // driver = new ChromeDriver(); // Or use your driver setup method
        //driver.get("https://www.urbanladder.com"); // Replace with actual URL
    	driver = Hook.driver;
        beingatHomePage = new BeingAtHome(driver);
        beingatHomePage.searchBeingatHome(); // This uses hardcoded "being at home"
        beingatHomePage.clickSearch();
    }
 
    @When("the search results are displayed")
    public void the_search_results_are_displayed() {
        beingatHomePage.selectCategory(); // Hover over category
    }
 
    @Then("I should see a list of categories under Being At Home")
    public void i_should_see_a_list_of_categories_under_being_at_home() throws IOException{
        beingatHomePage.DisplaySubItems(); // Print categories to console
        logger.info("Retrieving all the sub-menu items of Being at Home");
        beingAtHome = beingatHomePage.DisplaySubItems();
        for(int i = 0 ; i < beingAtHome.length ; i++) {
        	ExcelUtils.setCellData(xlFile, beingAtHomesSheet, i+1, 1, beingAtHome[i]);
        }
        //driver.quit(); // Clean up
    }
}
