package StepDefinitions;

import Pages.SpotifyHomepage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SpotifyAuthentication {

    WebDriver driver = new ChromeDriver();
    SpotifyHomepage homepage = new SpotifyHomepage(driver);
    @Given("On Spotify website")
    public void onSpotifyWebsite() {
        driver.get("https://open.spotify.com/");
    }

    @When("User clicks on Login button accounts page is displayed")
    public void userClicksOnLoginButtonAccountsPageIsDisplayed() {
        homepage.acceptAllCookies().click();
        homepage.clickOnLoginButton().click();
    }

    @And("User selects continue with Google, enters invalid mail and invalid password")
    public void userSelectsContinueWithGoogleEntersInvalidMailAndInvalidPassword() {
        WebElement continueWithGoogle = driver.findElement(By.cssSelector(".Type__TypeElement-goli3j-0.cWkmRE.sc-hKwDye.sc-kDTinF.fXzRSj.iSqHJa"));
        continueWithGoogle.click();
        WebElement googleEmailOrNr = driver.findElement(By.cssSelector("#identifierId"));
        googleEmailOrNr.sendKeys("test@test.gmail");
        WebElement next = driver.findElement(By.cssSelector(".VfPpkd-LgbsSe.VfPpkd-LgbsSe-OWXEXe-k8QpJ.VfPpkd-LgbsSe-OWXEXe-dgl2Hf.nCP5yc.AjY5Oe.DuMIQc.LQeN7.qIypjc.TrZEUc.lw1w4b"));
        next.click();
        WebElement googlePsw = driver.findElement(By.cssSelector(".whsOnd.zHQkBf"));
        googlePsw.sendKeys("asd");
        next.click();
    }

    @Then("User can not login and error message for Google account is displayed")
    public void userCanNotLoginAndErrorMessageForGoogleAccountIsDisplayed() {
        WebElement errorMessage = driver.findElement(By.cssSelector(".OyEIQ.uSvLId"));
        String errorMsg = "Wrong password. Try again or click Forgot password to reset it.";
        Assert.assertEquals(errorMsg, errorMessage.getText());
    }

    @And("User enters invalid mail and invalid password for Spotify account")
    public void userEntersInvalidMailAndInvalidPasswordForSpotifyAccount() {
        WebElement spotifyEmailOrNr = driver.findElement(By.cssSelector("#login-username"));
        spotifyEmailOrNr.sendKeys("test@test.gmail");
        WebElement spotifyPsw = driver.findElement(By.cssSelector("#login-password"));
        spotifyPsw.sendKeys("asd");
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        Actions action = new Actions(driver);
        action.moveToElement(loginButton).click();
    }

    @Then("User can not login and error message is displayed")
    public void userCanNotLoginAndErrorMessageIsDisplayed() {
        WebElement errorMessage = driver.findElement(By.cssSelector(".Message-sc-15vkh7g-0.jHItEP"));
        Actions action = new Actions(driver);
        action.moveToElement(errorMessage);
        String errorMsg = "Incorrect username or password.";
        Assert.assertEquals(errorMsg, errorMessage.getText());
    }
}
