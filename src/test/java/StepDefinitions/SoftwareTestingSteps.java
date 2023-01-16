package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SoftwareTestingSteps {

    WebDriver driver = new ChromeDriver();

    @Given("On site")
    public void onSite() {
        driver.get("https://magento.softwaretestingboard.com/");
    }
    @When("User selects gear and then selects bags")
    public void userSelectsGearAndThenSelectsBags() {
        Actions action = new Actions(driver);
        WebElement gear = driver.findElement(By.cssSelector("#ui-id-6.level-top.ui-corner-all"));
        action.moveToElement(gear).perform();
        WebElement bags = driver.findElement(By.cssSelector("#ui-id-25"));
        action.moveToElement(bags).click().perform();
    }

    @And("User adds product to cart")
    public void userAddsProductToCart() {
        Actions action = new Actions(driver);
        WebElement product = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[5]/div/div/strong"));
        action.moveToElement(product).perform();
        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[5]/div/div/div[3]/div/div[1]/form/button"));
        action.moveToElement(addToCart).click().perform();
    }

    @Then("Product is in cart")
    public void productIsInCart() {
    }
}
