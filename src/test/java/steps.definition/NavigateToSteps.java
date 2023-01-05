package steps.definition;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.objects.LoginFlow;
import page.objects.NavigateToFlow;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class NavigateToSteps {
    NavigateToFlow navigateToFlow;
    WebDriver driver;
    public Properties configProperties;
    LoginFlow loginFlow;
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
        navigateToFlow = new NavigateToFlow(driver);
    }
    @Given("User logged in {string}")
    public void userLoggedIn(String url) {
        navigateToFlow.Login(
                url,
                "standard_user",
                "secret_sauce"
        );
    }


    @When("User click on Shopping Cart")
    public void userClickOnShoppingCart() {

    navigateToFlow.ClickOnShoppingCart();

    }

    @Then("User should see his cart")
    public void userShouldSeeHisCart() {
        navigateToFlow.CheckShoppingCartItems();
    }


}
