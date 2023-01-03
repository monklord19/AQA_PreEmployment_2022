import UITests.Homepage;
import UITests.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class StepDef {

    @Before
    public void LaunchBrowser() {
        System.setProperty("webdriver.chrome.driver", "C://Users//franc//drivers//chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    WebDriver driver = new ChromeDriver();
    LoginPage loginPage;
    Homepage homepage;


    @After
    public void closeBrowser() {
        driver.close();
    }

    @Given("User navigates to website {string}")
    public void user_navigates_to_website(String url) {
     driver.get(url);
    }
    @When("User enters partially valid username {string} and partially valid password {string}")
    public void user_enters_partially_valid_username_and_partially_valid_password(String username, String password) {
     loginPage.setUsername(username);
     loginPage.setPassword(password);
    }
    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {
    loginPage.clickOnLoginButton();
    }
    @Then("User can`t login and error message is displayed")
    public void user_can_t_login_and_error_message_is_displayed() {
      String errorMsg = "Epic sadface: Username and password do not match any user in this service";
        Assertions.assertEquals(errorMsg, loginPage.checkErrorMessage());
    }

}