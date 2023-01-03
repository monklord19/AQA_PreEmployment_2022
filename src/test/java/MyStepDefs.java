import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepDefs {

    WebDriver driver = new ChromeDriver();
    private long duration = 0;

    @Given("On sauce website")
    public void onSauceWebsite() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("User enters valid credential {string} and {string}")
    public void userEntersValidCredentials(String userName, String password) {
        this.duration = 0;
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameInput.sendKeys(userName);
        passwordInput.sendKeys(password);

        long startTime = System.currentTimeMillis();
        loginButton.submit();
        duration = System.currentTimeMillis() - startTime;
        int t = 0;
    }

    @Then("User should be logged with success {string}")
    public void userShouldBeLoggedIn(String success) {
        boolean isPresent = !driver.findElements(By.id("logout_sidebar_link")).isEmpty();
        if (Boolean.parseBoolean(success)) {
            Assert.assertTrue(isPresent);
        } else {
            Assert.assertFalse(isPresent);
        }
    }

    @Then("Loading takes less then or equal to {int} seconds")
    public void loadTakesLessThen(int seconds) {
        int durationSeconds = (int)((duration / 1000) % 60);
        Assert.assertTrue(durationSeconds <= seconds);
    }

    @Then("Loading takes more then or equal to {int} seconds")
    public void loadTakesMoreThen(int seconds) {
        int durationSeconds = (int)((duration / 1000) % 60);
        Assert.assertTrue(durationSeconds >= seconds);
    }
}
