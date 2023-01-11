import UITests.PageObjects.AppleLoginPage;
import UITests.PageObjects.FacebookLoginPage;
import UITests.PageObjects.SpotifyPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Tema4 {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    SpotifyPage spotifyPage = new SpotifyPage(driver);
    FacebookLoginPage facebookLoginPage;
    AppleLoginPage appleLoginPage;

    @Before
    public void init()
    {
        SpotifyPage.driver.get("https://open.spotify.com/");
    }

    @Given("user enters e-mail address and invalid password")
    public void userEntersEMailAddressAndInvalidPassword() {
        spotifyPage.acceptCookies();
        spotifyPage.clickFirstLoginButton();
        spotifyPage.putCredentials("stefanaa29@yahoo.com","parolagresita");

    }

    @When("user clicks on login button")
    public void userClicksOnLoginButtton() {
        spotifyPage.clickSpotifyLogin();
    }

    @Then("the error message is displayed {string}")
    public void theErrorMessageIsDisplayed(String arg0) {
        spotifyPage.checkIfErrorMessageDisplay();
        spotifyPage.checkErrorMessage("Nume utilizator sau parolă incorectă.");
    }

    @Given("user enters google account")
    public void userEntersGoogleAccount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("onetrust-accept-btn-handler")));
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/header/div[5]/button[2]/span")));
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/header/div[5]/button[2]/span")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/ul/li[3]/button")));
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/ul/li[3]/button")).click();
        driver.findElement(By.id("identifierId")).sendKeys("asa@asa.com");

    }

    @When("user clicks on next button")
    public void userClicksOnNextButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"identifierNext\"]/div/button")));
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button")).click();
    }

    @Then("the message is displayed {string}")
    public void theMessageIsDisplayed(String arg0) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"headingText\"]/span")));
        WebElement message = driver.findElement(By.xpath("//*[@id=\"headingText\"]/span"));
        Assert.assertTrue(message.isDisplayed());
    }

    @Given("user enters invalid facebook account")
    public void userEntersInvalidFacebookAccount() {
        spotifyPage.acceptCookies();
        spotifyPage.clickFirstLoginButton();
        spotifyPage.clickLoginWithFacebook();
        facebookLoginPage = new FacebookLoginPage(driver);
        facebookLoginPage.acceptCookies();
        facebookLoginPage.putCredentials("stef@yahoo.com", "parolagresita");
    }

    @When("user clicks on facebook login button")
    public void userClicksOnFacebookLoginButton() {
       facebookLoginPage.clickLoginButton();
    }

    @Then("message is displayed {string}")
    public void messageIsDisplayed(String arg0) {
        facebookLoginPage.checkErrorMessage();

    }

    @Given("user enters invalid id apple and invalid password")
    public void userEntersInvalidIdAppleAndInvalidPassword() {
        spotifyPage.acceptCookies();
        spotifyPage.clickFirstLoginButton();
        spotifyPage.clickLoginWithApple();
        appleLoginPage = new AppleLoginPage(driver);
        appleLoginPage.putUsername("cd");
        appleLoginPage.clickNext();
        appleLoginPage.putPassword("cd");

    }

    @When("user clicks on apple next button")
    public void userClicksOnAppleNextButton() {
        appleLoginPage.clickNext();
    }

    @Then("the message displayed is that the user is blocked")
    public void theMessageDisplayedIsThatTheUserIsBlocked() {
        appleLoginPage.checkErrorMessage();
    }
    @After
    public void close(){
        driver.quit();
    }
}

