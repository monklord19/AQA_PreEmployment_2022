package StepsDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class MyStepsDefinitions {

    WebDriver driver = new ChromeDriver();

    //ValidLogin
    @Given("User is on URL")
    public void user_is_on_https_www_saucedemo_com() {
        driver.get("https://www.saucedemo.com/");
    }
    @When("^User enters (.*) and (.*)$")
    public void user_enters_username_and_password(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }
    @And("User clicks on login button")
    public void user_clicks_on_login_button() {
        driver.findElement(By.id("login-button")).click();
    }
    @Then("User is successfully logged in")
    public void user_is_successfully_logged_in() {
        Assert.assertTrue(driver.findElement(By.className("title")).isDisplayed());
        driver.quit();
    }

    //LockedOutUser
    @When("User enters credentials")
    public void user_enters_credentials() {
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @Then("Failed sign-in with error msg")
    public void failed_sign_in_with_error_msg() {
        driver.quit();
    }

    //NoPassword
    @Then("Failed sign-in. Password required")
    public void failed_sign_in_password_required() {
        driver.quit();
    }

    //WrongPassword
    @Then("Failed sign-in with error. Wrong password")
    public void failed_sign_in_with_error_wrong_password() {
        driver.quit();
    }

    //NoUsername
    @Then("Failed sign-in with error. Username is required")
    public void failed_sign_in_with_error_username_is_required() {
        driver.quit();
    }


}
