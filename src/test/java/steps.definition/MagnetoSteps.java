package steps.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import page.objects.MagnetoFlow;
import page.objects.SpotifyFlow;
import utils.BaseClass;
import utils.BrowserReader;

import java.io.FileReader;

public class MagnetoSteps extends BaseClass {

    WebDriver driver;
    MagnetoFlow magnetoFlow;

    public MagnetoSteps(BrowserReader readear) {
        this.driver = readear.driver;
        magnetoFlow = new MagnetoFlow(driver);
    }
    @Given("User opens magneto website")
    public void userOpensMagnetoWebsite() {

        String baseURL = "https://magento.softwaretestingboard.com";
        driver.get(baseURL);
        
    }

    @And("User hoover over Gears drop down list")
    public void userHooverOverGearsDropDownList() {
        magnetoFlow.hooverOver();
        magnetoFlow.hooverOver();
    }

    @And("User selects Bags")
    public void userSelectsBags() {
        magnetoFlow.selectBags();
    }

    @When("User scrolls down to Savvy Shoulder Tote")
    public void userScrollsDownToSavvyShoulderTote() {
        magnetoFlow.scrollTo();
    }

    @And("User click Add to Cart")
    public void userClickAddToCart() {
        magnetoFlow.clicksOn();
        
    }

    @Then("User should see his product in cart")
    public void userShouldSeeHisProductInCart() {
        magnetoFlow.onShoppingCart();
    }

}
