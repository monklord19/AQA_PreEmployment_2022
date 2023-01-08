package StepsDefinitions;

import Pages.SpotifyPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SpotifySteps {
    WebDriver driver = new ChromeDriver();
    SpotifyPage spage = new SpotifyPage(driver);

    @Before
    public void IAmOnLoginPageAndAcceptCoockies(){
        String test_url = "https://open.spotify.com/";

        driver.manage().window().maximize();
        driver.get(test_url);

        spage.closeCookie();
        System.out.println("completed");
    }
    @Given("Choose CONTINUE WITH GOOGLE")
    public void chooseContinueWithGoogle() {
        spage.clickChooseGoogle();
    }
    @When("Enter email {string}")
    public void enter_email(String string) {
        spage.enterAccount(string);

    }
    @And("Click Next")
    public void clickNext() {
        spage.clickBtnNext();
    }
    @Then("Error Message is displayed")
    public void error_message_is_displayed() {

        spage.verifyTryAgainIsDisplayed();
    }

    @Given("Click Connect")
    public void clickConnect() {

        spage.Connect();
    }
    @When("^I enter (.*) and (.*)$")
    public void i_enter_username_and_password(String name,String password){
        spage.enterSpotifyname("abc@abc.com");
        spage.enterSpotifyPassword("123");

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
        spage.clickChooseApple();
    }

    @When("Enter apple username {string}")
    public void enterAppleUsername(String username)  {
        spage.enterAppleName("abc@abc.com");
    }

    @And("Click Signin")
    public void clickSignin() {
        spage.clickAppleNext();
    }
    @And("Enter apple password {string}")
    public void enterPassword(String password){
       spage.enterApplePassword("123");

    }

    @Then("Error Message3 is displayed")
    public void error_message3_is_displayed() {
        spage.verifyErrorApple();

    }

    @After
    public void closesteps(){
        driver.quit();
   }


}
