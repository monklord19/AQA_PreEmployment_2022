package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LunaSteps{
    WebDriver driver = new ChromeDriver();
    Actions action = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    By gearButton = By.xpath("//li/a[@id='ui-id-6']");
    By bagsButton = By.xpath("//ul/li/a[@id='ui-id-25']");
    By productToCart = By.xpath("//img[@alt='Savvy Shoulder Tote']");

    By addCartButton = By.xpath("//button[@title='Add to Cart']");


    public void LunaStepsMainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Given("user is on page")
    public void onLunaWebsite() {
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @When("user hovers over the Gear button")
    public void userHoversOverTheGearButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(gearButton));
        WebElement gearButtonElement = driver.findElement(gearButton);
        action.moveToElement(gearButtonElement).perform();
    }

    @And("user clicks on Bags button")
    public void userClicksOnBagsButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bagsButton));
        WebElement bagsButtonElement = driver.findElement(bagsButton);
        bagsButtonElement.click();
    }

    @And("user scrolls down to element")
    public void userScrollsDownToElement() {
        WebElement productToCartElement = driver.findElement(productToCart);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productToCartElement);
    }

    @And("user hovers over product")
    public void userHoversOverProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productToCart));
        WebElement productToCartElement = driver.findElement(productToCart);
        action.moveToElement(productToCartElement).perform();
    }

    @And("user clicks add to cart")
    public void userClicksAddToCart() {
        WebElement addCartButtonElement = driver.findElement(addCartButton);
        Assert.assertTrue(addCartButtonElement.isDisplayed());
    }
}