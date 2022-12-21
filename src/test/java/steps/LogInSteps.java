package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LogInPage;
import pages.ProductsPage;

public class LogInSteps {
    WebDriver driver = new ChromeDriver();
    LogInPage logInPage;
    ProductsPage productsPage;

    @Given("You are on the login page")
    public void youAreOnTheLoginPage() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

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


}
