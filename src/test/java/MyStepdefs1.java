import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Vector;

public class MyStepdefs1 {
    /*@Given("On sauce website")
    public void onSauceWebsite() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }*/
    WebDriver driver = new ChromeDriver();

    @Given("user open the login page")
    public void userOpenTheLoginPage() {
       driver.get("https://www.saucedemo.com/");
    }

    @And("the Username text box is empty")
    public void theUsernameTextBoxIsEmpty() {
        driver.findElement(By.name("user-name")).sendKeys("");

    }

    @And("the Password text box is empty")
    public void thePasswordTextBoxIsEmpty() {
        driver.findElement(By.name("password")).sendKeys("");
    }

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("user enters username and password")
    public void userEntersUsernameAndPassword() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
    }

    @And("user clicks on login")
    public void userClicksOnLogin() {
       WebElement loginButton = driver.findElement(By.name("login-button"));
       loginButton.click();
    }

    @Then("user is navigated to the home page")
    public void userIsNavigatedToTheHomePage() {
        driver.navigate().to("https://www.saucedemo.com/inventory.html");
    }

    @Given("On sauce website")
    public void onSauceWebsite() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }
    @When("user enter username as standard_user")
    public void user_enter_username_as_standard_user() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        //throw new io.cucumber.java.PendingException();
    }
    @And("user enter password as secret_sauce")
    public void user_enter_password_as_secret_sauce() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //throw new io.cucumber.java.PendingException();
    }
    @Then("user clicks on login button")
    public void user_clicks_on_login_button() {
        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();
        //throw new io.cucumber.java.PendingException();
    }


    @When("user type valid username and add a white space")
    public void user_type_valid_username_and_add_a_white_space() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user ");
        // throw new io.cucumber.java.PendingException();
    }
    @And("user type valid password for the current user")
    public void user_type_valid_password_for_the_current_user() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //  throw new io.cucumber.java.PendingException();
    }
    @And("user click on login button")
    public void user_click_on_login_button() {
        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();
        //throw new io.cucumber.java.PendingException();
    }
    @Then("username text box should show an error")
    public void username_text_box_should_show_an_error() {

        //throw new io.cucumber.java.PendingException();
    }
    @And("password text box should show an error")
    public void password_text_box_should_show_an_error() {
         // throw new io.cucumber.java.PendingException();
    }
    @And("a red pop-up text box containing {string} should appear")
    public void a_red_pop_up_text_box_containing_should_appear(String string) {
        // throw new io.cucumber.java.PendingException();
    }


    @When("user type anything in username text box")
    public void user_type_anything_in_username_text_box() {
        driver.findElement(By.name("user-name")).sendKeys("abcdef ");

        // throw new io.cucumber.java.PendingException();
    }
    @And("password text box is empty")
    public void password_text_box_is_empty() {
        driver.findElement(By.name("password")).sendKeys("");

        // throw new io.cucumber.java.PendingException();
    }

    @When("user type anything in password text box")
    public void user_type_anything_in_password_text_box() {
        driver.findElement(By.name("password")).sendKeys("abcdef");

        // throw new io.cucumber.java.PendingException();
    }
    @And("username text box is empty")
    public void username_text_box_is_empty() {
        driver.findElement(By.name("user-name")).sendKeys("");

        //throw new io.cucumber.java.PendingException();
    }

    @When("user type a valid username")
    public void user_type_a_valid_username() {
        driver.findElement(By.name("user-name")).sendKeys("problem_user");

        //throw new io.cucumber.java.PendingException();
    }
    @And("user type a different password that the correct one")
    public void user_type_a_different_password_that_the_correct_one() {
        driver.findElement(By.name("password")).sendKeys("abcdef");

        //throw new io.cucumber.java.PendingException();
    }
    @When("user type a different username that the correct one")
    public void user_type_a_different_username_that_the_correct_one() {
        driver.findElement(By.name("user-name")).sendKeys("problem_userabcd");

        //throw new io.cucumber.java.PendingException();
    }
    @When("user type a valid password")
    public void user_type_a_valid_password() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        //throw new io.cucumber.java.PendingException();
    }


}
