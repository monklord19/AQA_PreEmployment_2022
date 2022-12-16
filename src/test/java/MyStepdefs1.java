import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs1 {
    WebDriver driver = new ChromeDriver();

    @Given("User is on the login page")
    public void onSauceWebsite() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("user enters {string} in username field")
    public void setUsername(String username) {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys(username);
    }

    @And("user enters {string} in password field")
    public void setPassword(String password) {
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
    }

    @And("user clicks on login button")
    public void clicksLoginButton() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Then("user should be able to login")
    public void userShouldBeAbleToLogin() {
        String actualUrl = "https://www.saucedemo.com/inventory.html";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        System.out.println("User logged in successfully");
    }


}



