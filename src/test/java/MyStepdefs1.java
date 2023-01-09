import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyStepdefs1 {
    WebDriver driver;
    WebElement textBoxUserName;
    WebElement textBoxPassword;
    WebElement submitButton;

    @Given("I open saucedemo site")
    public void iOpenSaucedemoSite() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter valid username in the username field")
    public void IEnterValidUsernameInTheUsernameField() {
        textBoxUserName = driver.findElement(By.name("user-name"));
        textBoxUserName.sendKeys("standard_user");
            }

    @And("I enter valid password in the password field")
    public void IEnterValidPasswordInThePasswordField() {
        textBoxPassword = driver.findElement(By.name("password"));
        textBoxPassword.sendKeys("secret_sauce");
    }

    @And("I click the Login button")
    public void IClickTheLoginButton() {
        submitButton = driver.findElement(By.name("login-button"));
        submitButton.click();
    }
    @Then("I should be logged in")
    public void IShouldBeLoggedIn() {
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        driver.quit();
    }

    @When("I enter valid username and password")
    public void IEnterValidUsernameAndPassword() {
        textBoxUserName = driver.findElement(By.name("user-name"));
        String userNameValue = textBoxUserName.getAttribute("value");
        textBoxPassword = driver.findElement(By.name("password"));
        String passwordValue = textBoxPassword.getAttribute("value");
        assertEquals ("secret_sauce", passwordValue);
        assertTrue (userNameValue.equals("standard_user") || userNameValue.equals("problem_user") || userNameValue.equals("performance_glitch_user"));

    }



}
