package UITests.stepsDefinitions;


import UITests.pageObjects.LoginSpotifyPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpotifyDefinitions {
    WebDriver driver;
    LoginSpotifyPage loginPage = new LoginSpotifyPage();

    @Given("Open spotify login page")
    public void openSpotifyLoginPage() {
        driver = new ChromeDriver();
        driver.get(loginPage.url);
    }

    // Scenario 1 - page should contain login-container to have possibility to login
    @Then("Spotify login page should be displayed")
    public void spotifyPageShouldBeDisplayed() {
        Assert
            .assertTrue(
                driver
                    .findElement(loginPage.loginContainer)
                    .isDisplayed()
            );
    }

    // Scenario 2 - page should send a error message when credentials are wrong

    @When("I enter username {word}")
    public void enterUsername(String username) {
        driver
            .findElement(loginPage.usernameInput)
            .sendKeys(username);
    }

    @And("I enter password {word}")
    public void enterPassword(String password) {
        driver
            .findElement(loginPage.passwordInput)
            .sendKeys(password);
    }
    @And("I press login button")
    public void pressLoginButton() {
        driver
            .findElement(loginPage.loginButton)
            .click();
    }

    @Then("Error message should be displayed")
    public void checkErrorMessageIsDisplayed() {
        var element = driver
            .findElement(loginPage.errorMessageContainer);

        // check if the span exists
        Assert.assertTrue(element.isDisplayed());
        // check if the message exists
        Assert.assertFalse(element.getText().isEmpty());
    }
}
