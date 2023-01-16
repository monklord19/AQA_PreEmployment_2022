package StepDefinitions;

import Pages.SpotifyHomepage;
import dataProvider.ConfigFileReader;
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

public class SpotifyAuthentication{

    WebDriver driver = new ChromeDriver();
    SpotifyHomepage homepage = new SpotifyHomepage(driver);

    ConfigFileReader configFileReader;

    @Given("On Spotify website")
    public void onSpotifyWebsite() {
        System.out.println("User is on homepage");
//        driver.get("https://open.spotify.com/");
    }

    @When("User clicks on Login button accounts page is displayed")
    public void userClicksOnLoginButtonAccountsPageIsDisplayed() {
        homepage.waitUntilElementIsVisible(3000);
        homepage.acceptAllCookies().click();
        homepage.clickOnLoginButton().click();
    }

    @And("User selects continue with Google, enters invalid mail and invalid password")
    public void userSelectsContinueWithGoogleEntersInvalidMailAndInvalidPassword() {
        homepage.waitUntilElementIsVisible(3000);
        WebElement continueWithGoogle = driver.findElement(By.cssSelector(".Type__TypeElement-goli3j-0.cWkmRE.sc-hKwDye.sc-kDTinF.fXzRSj.iSqHJa"));
        continueWithGoogle.click();
        WebElement googleEmailOrNr = driver.findElement(By.cssSelector("#identifierId"));
        googleEmailOrNr.sendKeys(configFileReader.getEmail());
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
        homepage.waitUntilElementIsVisible(3000);

        WebElement spotifyEmailOrNr = driver.findElement(By.cssSelector("#login-username"));
        spotifyEmailOrNr.sendKeys(configFileReader.getEmail());
        WebElement spotifyPsw = driver.findElement(By.cssSelector("#login-password"));
        spotifyPsw.sendKeys(configFileReader.getPassword());
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        Actions action = new Actions(driver);
        action.moveToElement(loginButton).click().perform();
    }

    @Then("User can not login and error message is displayed")
    public void userCanNotLoginAndErrorMessageIsDisplayed() {

        homepage.waitUntilElementIsVisible(2000);
        WebElement errorMessage = driver.findElement(By.cssSelector(".Message-sc-15vkh7g-0.jHItEP"));
        String errorMsg = "Incorrect username or password.";
        Assert.assertEquals(errorMsg, configFileReader.getSpotifyErrorMsg());
    }

    @And("User selects continue with Apple, enters invalid mail and invalid password")
    public void userSelectsContinueWithAppleEntersInvalidMailAndInvalidPassword() {
        homepage.waitUntilElementIsVisible(3000);
        WebElement continueWithApple = driver.findElement(By.cssSelector(".Button-y0gtbx-0.hpTULc.sc-dlVxhl.lxEME"));
        continueWithApple.click();
        WebElement appleId = driver.findElement(By.cssSelector("#account_name_text_field"));
        appleId.sendKeys("test@test.icloud.com");
        WebElement nextIcon = driver.findElement(By.cssSelector("#sign-in"));
        nextIcon.click();
        WebElement applePsw = driver.findElement(By.cssSelector("#password_text_field"));
        applePsw.sendKeys("asd");
        homepage.waitUntilElementIsVisible(2000);
        nextIcon.click();
    }

    @Then("User can not login and error message for Apple account is displayed")
    public void userCanNotLoginAndErrorMessageForAppleAccountIsDisplayed() {
        String appleAlertMessage = "Your Apple ID or password was incorrect.";
        WebElement alert = driver.findElement(By.cssSelector("#errMsg"));
        Assert.assertEquals(appleAlertMessage, alert.getText());
    }

    @And("User selects continue with Facebook, enters invalid mail and invalid password")
    public void userSelectsContinueWithFacebookEntersInvalidMailAndInvalidPassword() {
        WebElement continueWithFacebook = driver.findElement(By.cssSelector(".Button-y0gtbx-0.hpTULc.sc-dJjYzT.dQmJFP"));
        continueWithFacebook.click();
        homepage.waitUntilElementIsVisible(3000);

        WebElement acceptFbCookies = driver.findElement(By.cssSelector("._42ft._4jy0._9xo7._4jy3._4jy1.selected._51sy"));
        Actions action = new Actions(driver);
        action.moveToElement(acceptFbCookies).click().perform();
        WebElement fbEmailOrNr = driver.findElement(By.cssSelector("#email.inputtext._55r1._1kbt"));
        fbEmailOrNr.sendKeys("test@test.gmail.com");
        WebElement fbPsw = driver.findElement(By.cssSelector("#pass.inputtext._55r1._1kbt"));
        fbPsw.sendKeys("asd");
        WebElement loginBtn = driver.findElement(By.cssSelector("#loginbutton"));
        loginBtn.click();
    }

    @Then("User can not login and error message for Facebook account is displayed")
    public void userCanNotLoginAndErrorMessageForFacebookAccountIsDisplayed() {
        String fbAlertMessage = "The password you’ve entered is incorrect. Forgot Password? Close popup and return";
        WebElement alert = driver.findElement(By.cssSelector(".uiContextualLayer.uiContextualLayerRight"));
        Assert.assertEquals(fbAlertMessage, alert.getText());
    }

}
