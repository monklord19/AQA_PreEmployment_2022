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

    @After
    public void tearDownSpotify() {
        driver.quit();
    }

    @Given("On spotify website")
    public void onSpotifyWebsite() {
        driver.get("https://accounts.spotify.com/en/login");
    }

    @When("User enters credentials {string} and {string}")
    public void enterCredentials(String email, String password) {
        loginSpotifyPage.enterEmail().sendKeys(email);
        loginSpotifyPage.enterPassword().sendKeys(password);
        loginSpotifyPage.clickLoginButton().click();
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
        loginSpotifyPage.getNextButton().click();
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
}