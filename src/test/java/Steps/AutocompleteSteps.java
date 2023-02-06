package Steps;

import Pages.Autocomplete;
import Pages.BookStoreApplication;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutocompleteSteps {
    WebDriver driver = new ChromeDriver();
    Autocomplete autocomplete = new Autocomplete(driver);

    @Given("The user is on DemoQa page {string}")
    public void theUserIsOnDemoQaPage(String url){
        driver.get(url);
    }

    @When("User is on the Widgets category")
    public void userIsOnTheWidgetsCategory(){
        autocomplete.clickOnWidgets();
    }

    @And("User access Autocomplte subcategory")
    public void userAccessAutocompleteSubcategory(){
        autocomplete.clickAutocomplete();
    }

    @Then("User type colours in the fields")
    public void userTypeColoursInTheField(){
        autocomplete.enterTwoColours();
    }

}
