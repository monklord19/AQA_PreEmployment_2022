package Steps;

import Pages.LoginPage;
import Pages.SpotifyLogin;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpotifySteps {
    WebDriver driver = new ChromeDriver();
    SpotifyLogin spotifyLogin = new SpotifyLogin(driver);

    @Given("User open the login page of Spotify {string}")
    public void userOpenTheLoginPageOfSpotify(String url) {

        driver.get(url);
    }

    @And("User enter an invalid username as {string}")
    public void userEnterAnInvalidUsernameAs(String username) {

        spotifyLogin.setUsername(username);
    }

    @And("User enter an invalid password as {string}")
    public void userEnterAnInvalidPasswordAs(String password) {

        spotifyLogin.setPassword(password);
    }

    @And("User click on spotify login button")
    public void userClickOnSpotifyLoginButton(){
        spotifyLogin.clickLoginButton();
    }

    @Then("An error message appears {string}")
    public void anErrorMessageAppears(String errorspotify){
        spotifyLogin.checkErrorPop_up(errorspotify);
    }

}
