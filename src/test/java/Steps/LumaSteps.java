package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LumaSteps {
    WebDriver driver = new ChromeDriver();

    @Given("User open the webpage of Luma")
    public void userOpenTheWebpageOfLuna() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @And("User access the Gear category")
    public void userAccessTheGearCategory() {

        driver.findElement(By.xpath("//*[@id=\"ui-id-6\"]/span[1]")).click();
    }

    @And("User access the Bag subcategory")
    public void userAccesTheBagSubcategory() {

        driver.findElement(By.xpath("//*[@id=\"ui-id-2\"]/li[4]/ul/li[2]")).click();
    }

    @When("User add the pink bag to the cart")
    public void userAddThePinkBagToTheCart() {
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[5]/div/div/div[3]/div/div[1]/form/button/span")).click();

    }

    @Then("User check the shopping cart")
    public void userCheckTheShoppingCart() {
        driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a")).click();
    }
}