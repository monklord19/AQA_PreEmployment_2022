package UITests.Steps;

import UITests.PageObjects.LoginPage;
import io.cucumber.java.en.*;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tema2 {
    LoginPage loginpage;
    WebDriver driver;
    String x;
    @Given("user opens website")
    public void userOpensWebsite() {
        loginpage = new LoginPage();
        driver = LoginPage.driver;
    }
    @Given("user enters a valid username as standard_user")
    public void userEntersAValidUsernameAsStandard_user() {
        loginpage.put_user_name("standard_user");
    }
    @And("user enters a valid password")
    public void userEntersAValidPassword() {
        loginpage.put_password("secret_sauce");
    }
    @When("user clicks on login")
    public void userClicksOnLogin() {

        loginpage.click_login();
    }

    @Then("the product page should open")
    public void theProductPageShouldOpen() {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.equals("https://www.saucedemo.com/inventory.html"));

    }


    @Given("user enters invalid username and invalid password")
    public void userEntersInvalidUsernameAndInvalidPassword() {
     loginpage.put_credentials("username", "password");
    }

    @Then("product page shouldn't open")
    public void productPageShouldnTOpen() {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.equals("https://www.saucedemo.com/"));

    }

    @And("error message is displayed {string}")
    public void errorMessageIsDisplayed(String arg0) {
         WebElement errordiv = driver.findElement(By.xpath("//h3[@data-test = 'error']"));
         Assert.assertTrue(errordiv.isDisplayed());

    }
     @Given("user doesn't enters username and password")
    public void userDoesnTEntersUsernameAndPassword() {
      loginpage.put_credentials("","");
    }

    @Then("product page doesn't open")
    public void productPageDoesnTOpen() {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.equals("https://www.saucedemo.com/"));
    }

    @Given("user enters valid username and invalid password")
    public void userEntersValidUsernameAndInvalidPassword() {
        loginpage.put_credentials("standard_user","password");
    }

    @Given("user enters invalid username and valid password")
    public void userEntersInvalidUsernameAndValidPassword() {
        loginpage.put_credentials("standarduser","secret_sauce");
    }

    @Given("user enters valid username and empty password")
    public void userEntersValidUsernameAndEmptyPassword() {
        loginpage.put_credentials("standard_user","");
    }

    @Given("user enters empty username and valid password")
    public void userEntersEmptyUsernameAndValidPassword() {
        loginpage.put_credentials("","secret_sauce");
    }

    @Given("user enters valid username as locked_out_user")
    public void userEntersValidUsernameAsLocked_out_user() {
        loginpage.put_user_name("locked_out_user");
    }

    @And("user enters valid password as secret_sauce")
    public void userEntersValidPasswordAsSecret_sauce() {
        loginpage.put_password("secret_sauce");
    }

    @Then("the product page shouldn't open")
    public void theProductPageShouldnTOpen() {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.equals("https://www.saucedemo.com/"));
    }

    @Given("user enters the product page")
    public void userEntersTheProductPage() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("the user clicks the {string} button")
    public void theUserClicksTheButton(String arg0) {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        x = driver.findElement(By.id("item_4_title_link")).getText();
    }

    @Then("user checks if the product is added to cart")
    public void userChecksIfTheProductIsAddedToCart() {
        driver.findElement(By.id("shopping_cart_container")).click();
        String y = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
        System.out.println(x);
        System.out.println(y);
        Assert.assertTrue(x.equals(y));

    }



   /* @Given("user wants to retype username")
    public void userWantsToRetypeUsername() {
    }

    @When("user wants to press the x icon to delete")
    public void userWantsToPressTheXIconToDelete() {
    }

    @Then("username should be deleted so that the user can rewrite")
    public void usernameShouldBeDeletedSoThatTheUserCanRewrite() {
    }

    @But("doesn't work to delete the username")
    public void doesnTWorkToDeleteTheUsername() {
    }*/
}
