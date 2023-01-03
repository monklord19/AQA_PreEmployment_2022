package UITests;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {

    WebDriver driver = new ChromeDriver();

    @Given("I go to {string}")
    public void i_go_to(String url) {
        driver.get(url);

    }
    @When("I type username as {string} and I type password  as {string}")
    public void i_type_username_as_and_i_type_password_as(String usern, String pass) {
        WebElement username= driver.findElement(By.id("user-name"));
        username.clear();
        username.sendKeys(usern);
        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys(pass);

    }

    @Then("I should be logged in")
    public void i_should_be_logged_in() {
         WebElement element= driver.findElement(By.className("bm-burger-button"));

        Assert.assertTrue(element.isDisplayed());
    }

    @When("i click on refresh button")
    public void i_click_on_refresh_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("page should be refreshed")
    public void page_should_be_refreshed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    @Then("login shouldn't work")
    public void login_shouldn_t_work() {
        WebElement errortext= driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/div/form/div[3]/h3"));
        Assert.assertEquals(errortext.getText(),"Epic sadface: Password is required");


    }

    @Given("I don't enter anything on username")
    public void i_don_t_enter_anything_on_username() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("i don't enter anything on password")
    public void i_don_t_enter_anything_on_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("an error pop-up is displayed")
    public void an_error_pop_up_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("I write wrong credentials")
    public void i_write_wrong_credentials() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("an error pop-up is displayed {string}")
    public void an_error_pop_up_is_displayed(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("valid username as standard user and blank password")
    public void valid_username_as_standard_user_and_blank_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I click on login")
    public void i_click_on_login() throws InterruptedException {
         WebElement logButton = driver.findElement(By.id("login-button"));
         logButton.click();
         wait(1000);
    }

    @Then("error message is displayed {string}")
    public void error_message_is_displayed(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
