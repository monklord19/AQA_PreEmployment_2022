package step.definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.objects.LoginPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;
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
        loginPage = new LoginPage(driver);
    }


    @After
    public void close_browser() {
        driver.close();
    }

    @Given("user navigates to {string}")
    public void user_navigates_to(String url) {
        driver.get(url);
    }

    @When("user enters username as {string} and password as {string}")
    public void user_enters_username_as_and_password_as(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @When("user clicks on login")
    public void user_clicks_on_login() {
        loginPage.clickLogin();
    }

    @Then("Home page opens")
    public void home_page_opens() {
        loginPage.checkHomePageOpened();
    }

    @Then("error message is displayed {string}")
    public void error_message_is_displayed(String msg) {
        loginPage.checkErrorMessage(msg);
    }

    @When("user presses Enter key")
    public void user_presses_enter_key() {
        loginPage.enterKeyLogin();
    }

    @Given("user is logged in")
    public void user_is_logged_in() {
        user_navigates_to("https://www.saucedemo.com/");
        user_enters_username_as_and_password_as("standard_user", "secret_sauce");
        user_clicks_on_login();
        home_page_opens();
    }

    @When("user clicks on hamburger button")
    public void user_clicks_on_hamburger_button() {
        loginPage.clickHamburgerBtn();
    }

    @When("user clicks on Logout button")
    public void user_clicks_on_logout_button() {
        loginPage.clickLogoutButton();
    }

    @Then("Login page reopens")
    public void login_page_reopens() {
        loginPage.checkLoginPageOpened();
    }

    @When("user signs out")
    public void user_signs_out() {
        loginPage.clickHamburgerBtn();
        loginPage.clickLogoutButton();
    }

    @When("user clicks on Go back button")
    public void user_clicks_on_go_back_button() {
        driver.navigate().back();
    }

    @Then("user remains on Login page")
    public void user_remains_on_login_page() {
        loginPage.checkLoginPageOpened();
    }
}
