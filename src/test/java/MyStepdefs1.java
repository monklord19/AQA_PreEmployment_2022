import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs1 {
    @Given("User is on the login page")
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
