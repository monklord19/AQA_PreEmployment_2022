package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.CartPage;
import pages.LogInPage;
import pages.ProductsPage;
import utils.TestRunner;

public class LogInSteps {
    WebDriver driver = new ChromeDriver();
    LogInPage logInPage;
    ProductsPage productsPage;
    CartPage cartPage;
    @Before
    public void beforeTests() {
       driver.manage().window().maximize();
    }

    @After
    public void afterTests() {

        driver.quit();
    }


    @Given("You are on the login page")
    public void youAreOnTheLoginPage() {
        driver.get("https://www.saucedemo.com/");


    }


    @Given("entering valid credentials")
    public void iEnterUserNameAndPassword() {
        logInPage = new LogInPage(driver);
        logInPage.enterUsernameField("standard_user");
        logInPage.enterPasswordField("secret_sauce");
    }

    @When("I click the login button")
    public void iClickTheLoginButton() {
        logInPage.clickLoginButton();
    }

    @Then("The product page is displayed")
    public void theProductPageIsDisplayed() {
        productsPage = new ProductsPage(driver);
        productsPage.LogoIsDisplayed();

    }

    //scenario 2
    @Given("input {string} and {string}")
    public void inputInvalidUsernameAndInvalidPassword(String InvalidUsername, String InvalidPassword) {
        logInPage = new LogInPage(driver);
        logInPage.enterUsernameField(InvalidUsername);
        logInPage.enterPasswordField(InvalidPassword);
    }


    @When("click on login button")
    public void clickOnLoginButton() {
        logInPage.clickLoginButton();
    }

    @Then("display {string}")
    public void displayErrorMessage(String errorMessage) {
        logInPage.usernameAndPassWrongError(errorMessage);

    }


//Scenario 3

    @Given("input valid username {string}  and empty password field")
    public void inputAndEmptyPasswordField(String username) {
        logInPage = new LogInPage(driver);
        logInPage.enterUsernameField(username);

    }

    @When("click login button")
    public void clickLoginButton() {
        logInPage.clickLoginButton();
    }


    @Then("display the error {string}")
    public void displayThe(String arg0) {
        logInPage.passwordIsRequiredError(arg0);
    }

}
