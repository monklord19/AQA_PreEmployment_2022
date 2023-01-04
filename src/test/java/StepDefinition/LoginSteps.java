package StepDefinition;

import Objects.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginSteps {

    WebDriver driver = new ChromeDriver();
    LoginPage loginPage;
    public Properties configProperties;

    @Before
    public void setup() throws IOException {
        configProperties = new Properties();
        FileInputStream configPropFile = new FileInputStream("config.properties");
        configProperties.load(configPropFile);

        String browser = configProperties.getProperty("browser");
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", configProperties.getProperty("chromepath"));
            driver = new ChromeDriver();
        } else
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
    public void userEntersUsernameAsAndPasswordAs(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @And("user clicks on login")
    public void userClicksOnLogin() {
        loginPage.clickLogin();
    }

    @Then("Home page opens")
    public void homePageOpens() {
        loginPage.checkHomePageOpened();
    }

    @And("user clicks on login button")
    public void userClicksOnLoginButton() {
        loginPage.clickLogin();
    }

    @Then("error message is displayed \"Epic sadface: Username and password do not match any user in this")
    public void errorMessageIsDisplayedEpicSadfaceUsernameAndPasswordDoNotMatchAnyUserInThis(String msg) throws Throwable {
        loginPage.checkErrorMessage(msg);
    }

    @And("a red pop-up text box containing {string} should appear")
    public void aRedPopUpTextBoxContainingShouldAppear(String arg0) {

    }

    @Given("user is logged in")
    public void userIsLoggedIn() {
        user_navigates_to("https://www.saucedemo.com/");
        userEntersUsernameAsAndPasswordAs("standard_user", "secret_sauce");
        userClicksOnLoginButton();
        homePageOpens();
    }

    @When("user clicks on hamburger button")
    public void userClicksOnHamburgerButton() {
        loginPage.clickHamburgerBtn();
    }

    @And("user clicks on logout button")
    public void userClicksOnLogoutButton() {
        loginPage.clickLogoutButton();
    }

    @Then("Login page should reopens")
    public void loginPageShouldReopens() {
        loginPage.checkLoginPageOpened();
    }

    @And("user presses Enter key")
    public void userPressesEnterKey() {
        loginPage.enterKeyLogin();
    }

    @When("user click on add to cart button")
    public void userClickOnAddToCartButton() {loginPage.clickAddToCartButton();
    }

    @When("user click on cart button")
    public void userClickOnCartButton() {
    }
    @Then("product should appear in cart")
    public void productShouldAppearInCart() {
    }
    @And("cart page opens")
    public void cartPageOpens() {
        driver.navigate().to("https://www.saucedemo.com/cart.html");
    }
}
