package StepsDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class spotifyLoginStepsDefinitions {

    WebDriver driver = new ChromeDriver();
    @Given("User is on Spotify page")
    public void userIsOnSpotifyPage() {
        driver.get("https://www.spotify.com/ro-ro/premium/");
    }
    @Given("User accepts cookies")
    public void userAcceptsCookies() {
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }
    @Given("User clicks on Connect button")
    public void userClicksOnConnectButton() {
        driver.findElement(By.linkText("Conectează-te")).click();
    }
    @When("User enters mail")
    public void userEntersMail() {
        driver.findElement(By.id("login-username")).sendKeys("osman_ferdi@yahoo.com");
    }
    @When("User enters password")
    public void userEntersPassword() {
        driver.findElement(By.id("login-password")).sendKeys("parola");
    }
    @When("User clicks on login button")
    public void userClicksOnLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }
    @Then("User is not logged in")
    public void userIsNotLoggedIn() {
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains/(text/(),{string})]")).isDisplayed());
        driver.quit();
    }
}
