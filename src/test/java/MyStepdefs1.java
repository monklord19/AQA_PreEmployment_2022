import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs1 {
    WebDriver driver = new ChromeDriver();
    FunctionsDefiniton loginPage= new FunctionsDefiniton();

    @Given("On sauce website")
    public void onSauceWebsite() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("User enters username {String} and password {String}")
    public void userEntersValidUsernameAndPassword(String username,String passsword) {
        loginPage.setUsername(username);
        loginPage.setPassword(passsword);
    }

    @And("User clicks on the login button")
    public void userClicksOnLogIn() {
        loginPage.pressLoginButton();
    }

    @Then("User should be logged in")
    public void userLoggedIn(){

    }
    @When("User enters username {String} and password {String}")
    public void userEntersValidUsernameAndInvalidPassword(String username,String passsword) {
        loginPage.setUsername(username);
        loginPage.setPassword(passsword);
        userClicksOnLogIn();
    }
    @Then("User shouldn't be able to log in")
    public void userShouldNotBeLoggedIn(){

    }
}
