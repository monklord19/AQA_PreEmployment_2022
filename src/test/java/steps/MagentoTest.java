package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MagentoTest {
    WebDriver driver = new ChromeDriver();
    Actions actions = new Actions(driver);

    @Given("I open magento website")
    public void i_open_magento_website(){
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
    }

    @When("I hover on Gear and i press on the bags button")
    public void iHoverOnGearAndIPressOnTheBagsButton() throws InterruptedException{

        WebElement mainMenu = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/nav/ul/li[4]/a/span[1]"));
        Thread.sleep(2000);
        actions.moveToElement(mainMenu).moveToElement(driver.findElement(By.cssSelector("li:nth-of-type(4) > ul[role='menu'] > li:nth-of-type(1) > a[role='menuitem'] > span"))).click().build().perform();
    }

    @Then("I add to cart Savvy Shoulder Tote")
    public void i_add_to_cart_savvy_shoulder_tote() throws InterruptedException{
        WebElement bag = driver.findElement(By.cssSelector("li:nth-of-type(5) > .product-item-info .product-item-link"));
        actions.moveToElement(bag).moveToElement(driver.findElement((By.cssSelector("li:nth-of-type(5) > .product-item-info form[method='post'] > button[title='Add to Cart'] > span")))).click().build().perform();
        Thread.sleep(2000);
    }

    @Then("The bag should be in my cart")
    public void the_bag_should_be_in_my_cart(){
        WebElement cart = driver.findElement(By.xpath("/html/body//div[@class='minicart-wrapper']/a[@href='https://magento.softwaretestingboard.com/checkout/cart/']"));
        cart.click();

        driver.close();
    }


}
