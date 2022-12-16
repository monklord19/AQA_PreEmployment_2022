import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs2 {
    @Given("User opens URL {string}")
    public void userOpensURLHttpsWwwSaucedemoCom() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("User input <Username> and <Password>")
    public void userInputUsernameAndPassword() {
    }
}
