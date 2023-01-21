package StepsDefinitions;

import Pages.SpotifyAppleLogin;
import Pages.SpotifyPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static Pages.ConfigReader.*;


public class SpotifyDefs extends BasePage
{
    WebDriver driver = new ChromeDriver();

    SpotifyPage spage = new SpotifyPage(driver);
    SpotifyAppleLogin appleL = new SpotifyAppleLogin(driver);

   // @Before
    public void IAmOnLoginPageAndAcceptCoockies() throws IOException {

        String test_url = getUrl();

        driver.manage().window().maximize();
        driver.get(test_url);
        System.out.println("completed");
    }

    @Given("Choose CONTINUE WITH GOOGLE")
    public void chooseContinueWithGoogle() {
        spage.clickChooseGoogle();
    }
    @When("Enter {string}")
    public void enter_email(String string) throws IOException {
        spage.enterAccount(getUsername());

    }
    @And("Click Next")
    public void clickNext() {
        spage.clickBtnNext();
    }
    @Then("Google Error Message is displayed")
    public void google_error_message_is_displayed() {

        spage.verifyTryAgainIsDisplayed();

    }

    @Given("Click Connect")
    public void clickConnect() throws IOException {
        //IAmOnLoginPageAndAcceptCoockies();
        spage.closeCookie();
        spage.Connect();
    }
    @When("^I type credentials (.*) and (.*)$")
    public void iTypeUsernameAndPassword(String name,String password) throws IOException {
        spage.enterSpotifyname(getUsername());
        spage.enterSpotifyPassword(getPassword());

    }
    @When("Click LOGIN")
    public void clickLOGIN() {
        spage.clickSpotifyLogin();
    }
    @Then("Error message2 is displayed")
    public void errorMessage2IsDisplayed() {
        spage.verifyErrorSpotify();
    }
    @Given("Choose CONTINUE WITH Apple")
    public void choose_continue_with_apple() {
        appleL.clickChooseApple();
    }

    @When("Enter apple {string} first")
    public void enterAppleUsername(String user) throws IOException {
        appleL.enterAppleName(getUsername());
    }

    @And("Click Signin")
    public void clickSignin() {

        appleL.clickAppleNext();
    }
    @And("Enter apple {string} second")
    public void enterPassword(String pass) throws IOException {
        appleL.enterApplePassword(getPassword());

    }

    @Then("Error Message3 is displayed")
    public void error_message3_is_displayed() {
        appleL.verifyErrorApple();
        //closesteps();
    }

    @And("Choose CONTINUE WITH Facebook")
    public void chooseContinueWithFacebook() {
        spage.clickChooseFacebook();
    }

    @When("Enter facebook {string} first")
    public void enterFacebookEmail(String arg0) throws IOException {
        spage.enterFacebookAccount(getUsername());}

    @And("Enter facebook {string} second")
    public void enterFacebookPassword(String password) throws IOException {
        spage.enterFacebookpassword(getPassword());
    }
    @And("Click login facebook")
    public void clickLoginFacebook() {
        spage.clickSigninFacebook();
    }
    @Then("Error Message Facebook is displayed")
    public void errorMessageFacebookIsDisplayed() {
        spage.verifyFacebookError();}





    @And("Close Facebook Cookies")
    public void closeFacebookCookies() throws InterruptedException {
        spage.clikCloseFacebookCookies();
    }



//    @After
//    public void closesteps(){
//        driver.quit();
//   }


}
