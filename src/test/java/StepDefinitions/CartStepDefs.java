package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartStepDefs {

    WebDriver driver;
    Actions actions = new Actions(driver);

    @Given("I am logged in on the Luma website")
    public void iAmLoggedInOnTheLumaWebsite() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
    }

    @When("I hover over the Gear menu item and select Bags")
    public void iHoverOverTheGearMenuItemAndSelectBags() throws InterruptedException {
        Thread.sleep(2000);
        WebElement mainMenu = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/nav/ul/li[4]/a/span[2]"));
        actions.moveToElement(mainMenu);
        WebElement subMenu = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/nav/ul/li[4]/a"));
        actions.moveToElement(subMenu);
        actions.moveToElement(subMenu).perform();
        actions.click().build().perform();
    }

    @And("I scroll down to Savvy Shoulder Tote and click Add to Cart")
    public void iScrollDownToSavvyShoulderToteAndClickAddToCart() throws InterruptedException {
        Thread.sleep(2000);
        WebElement bag = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[5]/div/a"));
        actions.moveToElement(bag);
        WebElement addToCart = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[5]/div/div/div[3]/div/div[1]/form/button/span"));
        actions.moveToElement(addToCart);
        actions.click().build().perform();

    }

    @Then("The {string} product is added to the cart and {string} message is displayed.")
    public void theSavvyShoulderToteProductIsAddedToTheCartAndYouAddedSavvyShoulderToteToYourShoppingCartMessageIsDisplayed() { String confirmation = "Proceed to Checkout";
        assertEquals(driver.getPageSource().contains("Proceed to checkout"), confirmation, "Produsul nu este in cos");
    }

}
