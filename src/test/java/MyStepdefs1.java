import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs1 {
    WebDriver driver = new ChromeDriver();

    @Given("You are on the login page")
    public void youAreOnTheLoginPage() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

    }


    @Given("Entering valid credentials")
    public void iEnterUserNameAndPassword() {
        driver .findElement(By.id("user-name")).sendKeys("standard_user");
        driver .findElement(By.id("password")).sendKeys("secret_sauce");

    }

    @When("I click the login button")
    public void iClickTheLoginButton() {
        driver .findElement(By.id("login-button")).click();

    }

    @Then("The product page is displayed")
    public void theProductPageIsDisplayed() {
        WebElement producText = driver.findElement(By.cssSelector(".title"));
        Assert.assertEquals(producText.getText(),"PRODUCTS");



    }
}
