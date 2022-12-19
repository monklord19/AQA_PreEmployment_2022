import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs1 {
   WebDriver driver;

    @Given("On sauce website")
    public void onSauceWebsite() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("User enters valid credentials")
    public void userEntersValidCredentials() {
    }

    @Then("User should be logged in")
    public void userShouldBeLoggedIn() {
        driver.quit();
    }

    @Given("I open https:\\/\\/www.saucedemo.com\\/")
    public void i_open_https_www_saucedemo_com() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }
    @When("I click Login")
    public void i_click_login() {

    }
    @Then("I am unable to log in")
    public void i_am_unable_to_log_in() {

    }
    @Then("Error message is displayed {string}")
    public void error_message_is_displayed(String string) {

    }
}
