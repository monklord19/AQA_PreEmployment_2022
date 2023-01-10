package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpotifyLoginPageStepDefs {

    WebDriver driver;
    WebElement submitButton;

    @Given("On the Spotify site, I click ACCEPT COOKIES")
    public void onTheSpotifySiteIClickACCEPTCOOKIES() {
        driver = new ChromeDriver();
        driver.get("https://open.spotify.com/");
    }

    @And("I click Log in; the Login - Spotify page opens")
    public void iClickLogInTheLoginSpotifyPageOpens() {
        submitButton = driver.findElement(By.name("login-button"));
        submitButton.click();}
}
