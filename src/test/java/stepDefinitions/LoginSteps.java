package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LoginSteps {
    WebDriver driver = new ChromeDriver();

    @Given("On sauce website")
    public void onSauceWebsite() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @When("User enters username")
    public void userEntersStandardUser() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Password")
    public void userEntersPass() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Clicks the login button")
    public void userClicksLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User should be logged in")
    public void userShouldBeLoggedIn() {
    }

    //2nd scenario
    @Given("On sauce website2")
    public void onSauceWebsite2() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @When("User enters username2")
    public void userEntersUsername() {
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
    }

    @And("Wrong password")
    public void userEntersPassword() {
        driver.findElement(By.id("password")).sendKeys("secret");
    }

    @And("Clicks the login button2")
    public void userClicksLoginButton2() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User should not be logged in")
    public void userShouldNotBeLoggedIn2() {
//        driver.findElement(By.id("shopping_cart_container")).click();
    }
}

