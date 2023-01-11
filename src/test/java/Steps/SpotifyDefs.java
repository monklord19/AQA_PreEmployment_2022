package Steps;

import PageObjects.LoginSpotifyPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SpotifyDefs {
    LoginSpotifyPage loginSpotifyPage;
    SingletonClass singleton = SingletonClass.getInstance();
    WebDriver driver = singleton.getDriver();

    @Before
    public void setUpSpotify() {
        loginSpotifyPage = new LoginSpotifyPage(driver);
    }

//    @After
//    public void tearDownSpotify() {
//        driver.quit();
//    }

    @Given("On spotify website")
    public void onSpotifyWebsite() {
        driver.get("https://accounts.spotify.com/en/login");
    }

    @When("User enters credentials {string} and {string}")
    public void enterCredentials(String email, String password) {
        loginSpotifyPage.enterSpotifyEmail().sendKeys(email);
        loginSpotifyPage.enterSpotifyPassword().sendKeys(password);
        loginSpotifyPage.clickLoginButtonOnSpotify().click();
    }
    @Then("User need to be logged in with success {string}")
    public void verifyLoggedIn(String success) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> elements = driver.findElements(By.xpath("//div[@role='alert']"));
        boolean isPresent = !elements.isEmpty();
        boolean shouldBeWithSuccess = Boolean.parseBoolean(success);

        if (shouldBeWithSuccess) {
            // Assert that the element is present
            Assert.assertFalse(isPresent);
        } else {
            // Assert that the element is not present
            Assert.assertTrue(isPresent);
        }
    }
    @When ("User goes to login with google")
    public void loginWithGoogle(){
      WebElement button =  loginSpotifyPage.getGoogleButton();
      button.click();
    }

    @And ("User enter valid google an email {string}")
    public void enterGoogleEmail (String email) {
        loginSpotifyPage.enterGoogleEmail().sendKeys(email);
        loginSpotifyPage.getGoogleNextButton().click();
    }

    @Then("User should allowed to enter password {string}")
    public void goToNextStep(String success){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> elements = driver.findElements(By.id("view_container"));
        boolean isPresent = !elements.isEmpty();
        boolean shouldAllowToContinue = Boolean.parseBoolean(success);

        if (shouldAllowToContinue) {
            Assert.assertFalse(isPresent);
        } else {
            Assert.assertTrue(isPresent);
        }
    }
    @When ("User goes to login with apple")
    public void loginWithApple(){
        WebElement button = loginSpotifyPage.getAppleButton();
        button.click();
    }

    @And ("User enter apple id {string}")
    public void enterAppleId (String id){
        loginSpotifyPage.enterAppleId().sendKeys(id);
        loginSpotifyPage.getSignInAppleButton().click();
    }

    @And ("User enter apple password {string}")
    public void enterApplePassword (String password){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginSpotifyPage.enterApplePassword().sendKeys(password);
        loginSpotifyPage.getSignInAppleButton().click();
    }

    @Then ("User should be logged in with apple account {string}")
        public void userLoggedInWithApple(String success){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        List<WebElement> elements = driver.findElements(By.xpath("//a[@href='https://iforgot.apple.com/password/verify/appleid']"));
        boolean isPresent = !elements.isEmpty();
        boolean shouldBeWithSuccess = Boolean.parseBoolean(success);
        if (shouldBeWithSuccess) {
            Assert.assertFalse(isPresent);
        } else {
            Assert.assertTrue(isPresent);
        }
        // Refresh page to try another credentials
        loginSpotifyPage.refreshPage();
    }

    @When("User goes to login with facebook")
        public void loginWithFacebook () {
        WebElement button =  loginSpotifyPage.getFacebookButton();
        button.click();
    }

    @And("Allow cookies")
        public void allowCookies(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginSpotifyPage.getAllowFacebookCookies().click();
    }

    @And ("User enter facebook credentials {string} and {string}")
        public void enterFacebookCredentials(String email, String password) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            loginSpotifyPage.enterFacebookEmail().sendKeys(email);
            loginSpotifyPage.enterFacebookPassword().sendKeys(password);
            loginSpotifyPage.getLoginFacebookButton().click();

    }

    @Then("User should be logged in with facebook account {string}")
        public void verifyFacebookLoggedIn(String success) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        List<WebElement> elements = driver.findElements(By.id("error_box"));
        boolean isPresent = !elements.isEmpty();
        boolean shouldAllowToContinue = Boolean.parseBoolean(success);
        if (shouldAllowToContinue) {
            Assert.assertFalse(isPresent);
        } else {
            Assert.assertTrue(isPresent);
        }
    }

    @And ("Refresh page to try another password")
        public void refreshFacebookPage(){
        loginSpotifyPage.pleaseWait(5);
        // Refresh page to try another password
        loginSpotifyPage.refreshPage();
    }

    @And ("Enter another facebook password {string}")
        public void enterFacebookPassword(String password){
        loginSpotifyPage.enterFacebookPassword().sendKeys(password);
        loginSpotifyPage.getLoginFacebookButton().click();
    }
}