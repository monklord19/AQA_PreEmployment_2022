package steps.definition;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.objects.LoginFlow;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginSteps {
    WebDriver driver;
    LoginFlow loginFlow;
    public Properties configProperties;

    @Before
    public void setup() throws IOException {
        //reading properties
        configProperties = new Properties();
        FileInputStream configPropFile = new FileInputStream("config.properties");
        configProperties.load(configPropFile);

        String browser = configProperties.getProperty("browser");
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", configProperties.getProperty("chromepath"));
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", configProperties.getProperty("firefoxpath"));
            driver = new FirefoxDriver();
        }
       loginFlow = new LoginFlow(driver);
    }
    @Given("user navigates to {string}")
    public void userNavigatesTo(String url) {
        driver.get(url);
    }

    @When("user enters username as {string} and password as {string}")
    public void userEntersUsernameAsAndPasswordAs(String username, String password) {
        loginFlow.setUsername(username);
        loginFlow.setPassword(password);
    }

    @And("user clicks on login")
    public void userClicksOnLogin() {
        loginFlow.clickLogin();
        
    }

    @Then("Home page opens")
    public void homePageOpens() {
        loginFlow.checkHomePageOpened();
    }

    @Then("Error message is displayed")
    public void errorMessageIsDisplayed() {
        loginFlow.checkErrorBtn();

    }

    @Then("error message is displayed {string}")
    public void errorMessageIsDisplayed(String errormsg) {
        loginFlow.errorMessage(errormsg);
    }

    @And("user hits RETURN\\/ENTER key")
    public void userHitsRETURNENTERKey() {
        loginFlow.hitReturnEnteKey();
    }
}
