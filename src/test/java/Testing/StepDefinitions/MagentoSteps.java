package Testing.StepDefinitions;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MagentoSteps {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    Actions action = new Actions(driver);


    @Given("User is on magento site")
    public void userIsOnMagentoSite() {
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
    }

    @And("User Hover over Gear dropdown")
    public void userHoverOverGearDropdown() throws InterruptedException {
        Thread.sleep(1000);
        WebElement gearDropdown = driver.findElement(By.xpath("//span[normalize-space()='Gear']"));
        action.moveToElement(gearDropdown);
    }

    @And("User Select Bags")
    public void userSelectBags() throws InterruptedException {
        WebElement bagsBtn = driver.findElement(By.xpath("//span[normalize-space()='Bags']"));
        wait.until(ExpectedConditions.visibilityOf(bagsBtn));
        action.moveToElement(bagsBtn);
        action.click().build().perform();
    }

    @When("User scroll down and click add to cart button for Savy Shoulder Tote")
    public void userClickAddToCartButtonForSavyShoulderTote() throws InterruptedException {

        WebElement savyBag = driver.findElement(By.xpath("//a[@class='product photo product-item-photo']//img[@alt='Savvy Shoulder Tote']"));
        action.moveToElement(savyBag);
        WebElement addToCart = driver.findElement(By.xpath("//body[1]/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[5]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]/span[1]"));
        wait.until(ExpectedConditions.visibilityOf(addToCart));
        action.moveToElement(addToCart);
        action.click().build().perform();
    }

    @And("User click on cart icon")
    public void userClickOnCartIcon() throws InterruptedException {
        Thread.sleep(2000);
        WebElement cartIcon = driver.findElement(By.xpath("//a[@class='action showcart']"));
        wait.until(ExpectedConditions.visibilityOf(cartIcon));
        action.moveToElement(cartIcon);
        action.click().build().perform();
    }

    @Then("The product is added into cart")
    public void theProductIsAddedIntoCart() throws InterruptedException {
        Thread.sleep(2000);
        String itemSavy = driver.findElement(By.xpath("//a[@data-bind='attr: {href: product_url}, html: product_name']")).getText();
        Assert.assertEquals("Savvy Shoulder Tote", itemSavy);
    }
}
