package StepDefinitions;

import Pages.Homepage;
import Pages.SpotifyHomepage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpotifyAuthenticationSteps {

    WebDriver driver = new ChromeDriver();

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Given("On Spotify website")
    public void onSpotifyWebsite() {
        driver.get("https://open.spotify.com/");

    }

    @When("User clicks on Login button accounts page is displayed")
    public void userClicksOnLoginButtonAccountsPageIsDisplayed() {
        SpotifyHomepage homepage = new SpotifyHomepage(driver);
        homepage.clickOnLoginButton();
    }

    @And("User selects continue with Google, enters invalid mail and  invalid password")
    public void userSelectsContinueWithGoogleEntersInvalidMailAndInvalidPassword() {
        WebElement continueWithGoogle = driver.findElement(By.cssSelector(".Type__TypeElement-goli3j-0.cWkmRE.sc-hKwDye.sc-kDTinF.fXzRSj.iSqHJa"));
        continueWithGoogle.click();
        WebElement emailOrNr = driver.findElement(By.id("identifierId"));
        emailOrNr.sendKeys("test@test.gmail");
        WebElement next = driver.findElement(By.cssSelector(".VfPpkd-LgbsSe.VfPpkd-LgbsSe-OWXEXe-k8QpJ.VfPpkd-LgbsSe-OWXEXe-dgl2Hf.nCP5yc.AjY5Oe.DuMIQc.LQeN7.qIypjc.TrZEUc.lw1w4b"));
        next.click();
        WebElement password = driver.findElement(By.cssSelector(".whsOnd.zHQkBf"));
        password.sendKeys("asd");
        next.click();
    }

    @Then("User can not login and error message is displayed")
    public void userCanNotLoginAndErrorMessageIsDisplayed() {
        String errorMsg = "Wrong password. Try again or click Forgot password to reset it.";
        WebElement errorMessage = driver.findElement(By.cssSelector(".OyEIQ.uSvLId"));
        Assertions.assertEquals(errorMsg, errorMessage.getText());
    }

    @And("User enters invalid mail and  invalid password for Spotify account")
    public void userEntersInvalidMailAndInvalidPasswordForSpotifyAccount() {
    }
}
