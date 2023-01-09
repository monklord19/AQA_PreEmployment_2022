package StepDefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class GoogleSearchSteps {

    WebDriver driver = null;

    @Given("browser is open")
    public void browser_is_open() {
        System.out.println("Starting - google is open");
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project path is: " + projectPath);

        System.getProperty("webdriver.chrome.driver", projectPath + "\\src\\test\\resources\\Drivers\\chromedriver.exe\"");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        //throw new io.cucumber.java.PendingException();
    }
    @And("user is on google search page")
    public void user_is_on_google_search_page() {
        driver.navigate().to("https://google.com");
        //throw new io.cucumber.java.PendingException();
    }
    @And("user allow cookies")
    public void user_allow_cookie(){
        //driver.manage().deleteAllCookies();
        driver.findElement(By.id("L2AGLb")).sendKeys((Keys.ENTER));

    }

    @When("user enters a text in google search box")
    public void user_enters_a_text_in_google_search_box() {
        driver.findElement(By.name("q")).sendKeys("Swag Labs");
    }
    @And("hits Enter")
    public void hits_enter() {
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }
    @Then("user is navigated to the Search Result page")
    public void user_is_navigated_to_the_search_result_page() {
        //driver.navigate().to("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/a/h3")).click();

        driver.close();
        driver.quit();
    }
}
