package StepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LumaSteps {
    WebDriver driver = new ChromeDriver();
    @Given("I open Browser")
    public void iOpenBrowser() {
                String test_url ="https://magento.softwaretestingboard.com/gear.html";

        driver.manage().window().maximize();
        driver.get(test_url);


    }

    @And("Select Gear, Bags")
    public void selectGearBags() {
//        Actions builder = new Actions(driver);
//        WebElement element = driver.findElement(By.id("ui-id-25"));
//        builder.moveToElement(element).build().perform();
        //Select drpCountry = new Select(driver.findElement(By.className("level-top ui-corner-all")));
        //drpCountry.selectByVisibleText("Bags");
        //driver.findElement(By.className("level-top ui-corner-all")).click();

        WebElement element = driver.findElement(By.id("ui-id-25"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        element.click();



    }

    @When("I add the bag to Cart")
    public void iAddTheBagToCart() {
    }

    @And("I open my shopping cart")
    public void iOpenMyShoppingCart() {
    }

    @Then("I should see the product in my shopping cart")
    public void iShouldSeeTheProductInMyShoppingCart() {
    }
}
