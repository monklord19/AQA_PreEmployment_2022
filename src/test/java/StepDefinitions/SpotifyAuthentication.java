package StepDefinitions;

import Pages.Page;
import Pages.SpotifyHomepage;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
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

import java.time.Duration;

public class SpotifyAuthentication {

    WebDriver driver = new ChromeDriver();
    SpotifyHomepage homepage = new SpotifyHomepage(driver);


    @Before
    public void maximizeWindow() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Given("On Spotify website")
    public void onSpotifyWebsite() {
        System.out.println("User is on homepage");
        driver.get("https://open.spotify.com/");
    }

    @When("User clicks on Login button accounts page is displayed")
    public void userClicksOnLoginButtonAccountsPageIsDisplayed() {
        //will wait for accept cookies pop-up to finish fade-in (animation from bottom to top rise)
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

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
        action.moveToElement(loginButton).click().perform();
    }

    @Then("User can not login and error message is displayed")
    public void userCanNotLoginAndErrorMessageIsDisplayed() {
        WebElement errorMessage = driver.findElement(By.cssSelector(".Message-sc-15vkh7g-0.jHItEP"));
        //Actions action = new Actions(driver);
        //action.moveToElement(errorMessage);
        String errorMsg = "Incorrect username or password.";
        Assert.assertEquals(errorMsg, errorMessage.getText());
    }

    @And("User selects continue with Apple, enters invalid mail and invalid password")
    public void userSelectsContinueWithAppleEntersInvalidMailAndInvalidPassword() {
        WebElement continueWithApple = driver.findElement(By.cssSelector(".Button-y0gtbx-0.hpTULc.sc-dlVxhl.lxEME"));
        continueWithApple.click();
        WebElement appleId = driver.findElement(By.cssSelector("#account_name_text_field"));
        appleId.sendKeys("test@test.icloud.com");
        WebElement nextIcon = driver.findElement(By.cssSelector("#sign-in.si-button.btn.fed-ui.fed-ui-animation-show"));
        nextIcon.click();
        WebElement applePsw = driver.findElement(By.cssSelector("#password_text_field"));
        applePsw.sendKeys("asd");
        nextIcon.click();
    }

    @Then("User can not login and error message for Apple account is displayed")
    public void userCanNotLoginAndErrorMessageForAppleAccountIsDisplayed() {
        String appleAlertMessage = "This Apple ID has been locked for security reasons.";
        WebElement alert = driver.findElement(By.cssSelector("#alertInfo"));
        Assert.assertEquals(appleAlertMessage, alert.getText());
    }

    @And("User selects continue with Facebook, enters invalid mail and invalid password")
    public void userSelectsContinueWithFacebookEntersInvalidMailAndInvalidPassword() {
        WebElement continueWithFacebook = driver.findElement(By.cssSelector(".Button-y0gtbx-0.hpTULc.sc-dJjYzT.dQmJFP"));
        continueWithFacebook.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement acceptFbCookies = driver.findElement(By.cssSelector("#u_0_e_Ex._42ft._4jy0._9xo7._4jy3._4jy1.selected._51sy"));
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
        String fbAlertMessage = "The password you’ve entered is incorrect. Forgot Password?";
        WebElement alert = driver.findElement(By.cssSelector(".uiContextualLayer.uiContextualLayerRight"));
        Assert.assertEquals(fbAlertMessage, alert.getText());
    }
}
