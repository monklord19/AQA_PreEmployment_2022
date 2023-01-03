package SaucedemoTesting.StepDefinitions;

import SaucedemoTesting.pageobjects.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;


public class LoginDemoSteps  {
    WebDriver driver;
    LoginPage login;
    @Before
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @After
    public void teardown() {
        driver.quit();
    }
    @Given("User opens login page")
    public void userOpensLoginPage() {
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @When("User input {string} and {string}")
    public void userInputAnd(String username, String password) {
        login = new LoginPage(driver);
        login.enterUsername(username);
        login.enterPassword(password);
    }

    @And("User click on Login button")
    public void userClickOnLoginButton() {
        login.clickLogin();
    }

    @Then("User is successfully logged in")
    public void userIsSuccessfullyLoggedIn() {
        login.checkHamburgerButtonIsDisplayed();
    }

    @And("Press Enter key")
    public void pressEnterKey() {
        login.pressEnter();
    }

}
   
