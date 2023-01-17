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
    @And("User click on login spotify from homepage")
    public void userClickOnLoginSpotifyFromHomepage(){
        spotifyLogin.clickLoginSpotify();
    }

    @And("User enter invalid spotify username as {string}")
    public void user_enter_invalid_spotify_username_as(String spotify_username) {

        spotifyLogin.setUsername(spotify_username);
        throw new io.cucumber.java.PendingException();
    }

    @And("User enter invalid spotify password as {string}")
    public void userEnterInvalidPasswordAs(String password) {

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



    @Given("User open the login webpage of Spotify")
    public void userOpenTheLoginWebpageOfSpotify(){
        userOpenTheLoginPageOfSpotify("https://open.spotify.com/");
    }


}
