package Steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait;

    @Given("User is accessing the DemoQa page {string}")
    public void userIsAccessingTheDemoQaPage(String url){
        driver.get(url);
    }

    @When("User click on Book Store Application")
    public void userClickOnBookStoreApplication(){
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[6]")).click();
    }

    @And("User click on Log in")
    public void userClickOnLogIn(){
        driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
    }

    @And("User enter username")
    public void userEnterUsernameAs(){
        driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("Andreea1972");
    }

    @And("User enter password")
    public void userEnterPassword(){
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Passowrodbjda3456789");
    }

    @And("User press the login button")
    public void userPressTheLoginButton(){
        driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
    }

    @Then("An error message appears")
    public void anErrorMessageAppears(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement errorMessage = driver.findElement(By.id("name"));
        Assert.assertEquals(errorMessage.getText(), "Invalid username or password!");
    }

}
