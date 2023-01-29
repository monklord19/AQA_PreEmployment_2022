package stepDefinitions;

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

public class Luma {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    Actions actions = new Actions(driver);

    @Given("user is on homepage")
    public void onLumaWebsite() {
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
    }

    @When("clicks gear dropdown menu then Bags")
    public void clickGearDropdown() {
        Actions act = new Actions(driver);
        WebElement Gear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ui-id-6\"]/span[1]")));
        act.moveToElement(Gear).perform();
        WebElement Bags = driver.findElement(By.xpath("//*[@id=\"ui-id-25\"]"));
        Bags.click();
    }

    @And("scrolls to Savvy shoulder tote and adds it to cart")
    public void scrollToSavvy() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[5]/div/div/div[3]/div/div[1]/form/button"));
        actions.moveToElement(element);
        actions.perform();

        WebElement hoverPinkBag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[5]/div/a/span/span/img")));
        actions.moveToElement(hoverPinkBag).perform();

        WebElement AddToCart = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[5]/div/div/div[3]/div/div[1]/form/button"));
        AddToCart.click();
    }

    @And("checks cart")
    public void checkCart() {
        WebElement checkCart = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a/span[1]"));
        actions.moveToElement(checkCart);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a")));
        actions.click().perform();
        checkCart.click();
    }

    @Then("the item should be in the cart")
    public void assertCart() {
        String checkSavvyBag = "Proceed to checkout";
        Assert.assertEquals(driver.getPageSource().contains("Proceed to checkout"), checkSavvyBag);
    }
}
