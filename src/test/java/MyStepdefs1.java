import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs1 {

    WebDriver driver;
    @Given("On sauce website")
    public void onSauceWebsite() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("User enters valid credentials")
    public void userEntersValidCredentials() {
        driver.findElement(By.cssSelector("#user-name")).sendKeys("user name valid");

    }

    @Then("User should be logged in")
    public void userShouldBeLoggedIn() {
    }

    @Given("I enter random numbers on the username")
    public void enterRandomNumbers(){
        driver.findElement(By.cssSelector("#user-name")).sendKeys("1 2 3 4");

    }
    @When("I press the login button")
    public void pressLoginButton(){
        driver.findElement(By.id("login-button")).click();

    }
    @Then("Login shouldn't work")
    public void loginNotWorking(){
        boolean isErrorDisplayed =  driver.findElement(By.className("error-message-container")).isDisplayed();
        Assert.assertTrue(isErrorDisplayed);
    }
    @And("I let password blank")
    public void letPasswordBlank() {};

    @Given("I enter the username \"(.*)\"")
    public void enterTheUsername(String username){
        driver.findElement(By.cssSelector("#user-name")).sendKeys(username);
    }

    @And("I enter the password \"(.*)\"")
    public void iEnterThePassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    };

    @Then("I should be logged in")
    public void userIsLoggedIn() {
        boolean isShoppingCartDisplayed = driver.findElement(By.id("shopping_cart_container")).isDisplayed();
        Assert.assertTrue(isShoppingCartDisplayed);
    }

}
