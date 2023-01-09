import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Tema4 {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));


    @Before
    public void init()
    {
        driver.get("https://open.spotify.com/");
    }
    @After
    public void close(){
        driver.quit();
    }
    @Given("user enters e-mail address and invalid password")
    public void userEntersEMailAddressAndInvalidPassword() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("onetrust-accept-btn-handler")));
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/header/div[5]/button[2]/span")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-username")));
        driver.findElement(By.id("login-username")).sendKeys("stefanaa29@yahoo.com");
        driver.findElement((By.id("login-password"))).sendKeys("parolagresita");

    }

    @When("user clicks on login buttton")
    public void userClicksOnLoginButtton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("the error message is displayed {string}")
    public void theErrorMessageIsDisplayed(String arg0) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/span")));
        WebElement errormessage = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/span"));
        Assert.assertTrue(errormessage.isDisplayed());
    }

    @Given("user enters google account")
    public void userEntersGoogleAccount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("onetrust-accept-btn-handler")));
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/header/div[5]/button[2]/span")));
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/header/div[5]/button[2]/span")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/ul/li[3]/button")));
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/ul/li[3]/button")).click();
        driver.findElement(By.id("identifierId")).sendKeys("asa@asa.com");

    }

    @When("user clicks on next button")
    public void userClicksOnNextButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"identifierNext\"]/div/button")));
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button")).click();
    }

    @Then("the message is displayed {string}")
    public void theMessageIsDisplayed(String arg0) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"headingText\"]/span")));
        WebElement message = driver.findElement(By.xpath("//*[@id=\"headingText\"]/span"));
        Assert.assertTrue(message.isDisplayed());
    }

}

