import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs1 {
    WebDriver driver = new ChromeDriver();
    @Given("On sauce website")
    public void onSauceWebsite() {

        driver.get("https://www.saucedemo.com/");
    }

    @When("user logging in using {string} and password as {string}")
    public void userLoggingInUsingAndPasswordAs(String arg0, String arg1) {

        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys(arg0);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(arg1);
    }

    @Then("user shouldn't be able to log in")
    public void userShouldnTBeAbleToLogIn() {
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
    }

    @And("display {string}")
    public void display(String arg0) {
        driver.findElement(By.xpath("//*[@class='error-message-container error']")).sendKeys(arg0);

    }


    @When("User enters no credentials")
    public void userEntersNoCredentials() {

    }

    @Then("User shouldn't be logged in")
    public void userShouldnTBeLoggedIn() {
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
    }

    @And("display message {string}")
    public void displayMessage(String arg0) {
        driver.findElement(By.xpath("//*[@class='error-message-container error']")).sendKeys(arg0);
    }
}
