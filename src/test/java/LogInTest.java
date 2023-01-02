import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;


public class LogInTest {

    public WebDriver driver = new ChromeDriver();

    //create driver
    @Before
    public void webdriverSetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
    }
    @Test
    @Given("I open the website https:\\/\\/www.saucedemo.com\\/")
    public void iOpenTheWebsiteHttpsWwwSaucedemoCom(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        driver.close();
    }

    @Then("I should be logged successfully")
    public void iShouldBeLoggedSuccessfully(){
        
    }

    @And("I should see the corect picture and details for each product")
    public void iShouldSeeTheCorectPictureAndDetailsForEachProduct(){
    }

@Test
    @When("I enter the {string} and {string}")
    public void iEnterTheAnd(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        driver.close();
    }

    @Then("I shouldn't be able to login")
    public void iShouldnTBeAbleToLogin(){

    }

    @And("I should see the {string} message")
    public void iShouldSeeTheMessage(String arg0){
    }
}
