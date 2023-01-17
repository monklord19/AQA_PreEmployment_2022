package Steps;

import Pages.GoogleLogin;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSteps {
    WebDriver driver = new ChromeDriver();
    GoogleLogin googleLogin = new GoogleLogin(driver);

    @Given("User open the Spotify webpage {string}")
    public void userOpenTheSpotifyWebpage(String url){
        driver.get(url);
    }

    @And("User open the connect page")
    public void userOpenTheConnectPage(){
        googleLogin.connectPage();
    }

    //@And("User click on login with another account")
    //public void userClickOnLoginWithAnotherAccount(){
      //  googleLogin.anotherAccount();
    //}

    @And("User click on login with Gmail")
    public void userClickOnLoginWithGmail(){
        googleLogin.loginWithGoogleCont();
    }

    @And("User enter a valid gmail as {string}")
    public void userEnterAValidGmailAs(String gmail){
        googleLogin.enterGmail(gmail);
    }

    @And("User press the move on button")
    public void userPressTheMoveOnButton(){
        googleLogin.moveOn();
    }

    @And("User enter an invalid google pass as {string}")
    public void userEnterAnInvalidGooglePassAs(String pass){
        googleLogin.enterPass(pass);
    }

    @And("User click on log in with gmail")
    public void userClickOnLogInWithGmail(){
        googleLogin.loginWithGmail();
    }

    @Then("An error message should appear")
    public void anErrorMessageShouldAppear(String googleError){
        googleLogin.errorOfGoogle(googleError);
    }












}