package steps.definition;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.objects.LogOutFlow;
import page.objects.LoginFlow;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LogoutSteps {
    LogOutFlow logoutFlow;
    WebDriver driver;
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
        logoutFlow = new LogOutFlow(driver);
    }

    @Given("User is logged in {string}")
    public void userIsLoggedIn(String url) {
        logoutFlow.Login(
                 url,
                "standard_user",
                "secret_sauce"
        );
    }

    @When("User navigates to side menu")
    public void userNavigatesToSideMenu() {
        logoutFlow.goToSideMenu();
    }

    @And("User click on logout button")
    public void userClickOnLogoutButton() {
        logoutFlow.Logout();
    }

    @Then("User is redirected to login page")
    public void userIsRedirectedToLoginPage() {
        logoutFlow.CheckLoginPageOpened();
    }

}
