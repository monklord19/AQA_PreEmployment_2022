import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs1 {


    
    @Given("On sauce website")
    public void onSauceWebsite() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("User enters valid credentials")
    public void userEntersValidCredentials() {
    }

    @Then("User should be logged in")
    public void userShouldBeLoggedIn() {
    }


}