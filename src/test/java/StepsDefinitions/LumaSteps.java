package StepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Pages.LumaPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LumaSteps {
    WebDriver driver = new ChromeDriver();
    LumaPage objects= new LumaPage(driver);

    @Given("I open website")
    public void iOpenWebsite() {
        String test_url ="https://magento.softwaretestingboard.com/gear.html";

        driver.manage().window().maximize();
        driver.get(test_url);
    }

    @And("I hoover over Gears drop down")
    public void iHooverOverGearsDropDown() {
        objects.hooverOver();
    }

    @And("I select Bags")
    public void iSelectBags() {
        objects.selectBags();
    }

    @When("I select  Savvy Shoulder Tote")
    public void iSelectSavvyShoulderTote() {
        objects.scrollTo();
    }

    @And("I click Add to Cart")
    public void iClickAddToCart() {
        objects.clicksOn();
    }

    @Then("I should see Bag in cart")
    public void iShouldSeeBagInCart() {
        objects.onShoppingCart();
    }
}
