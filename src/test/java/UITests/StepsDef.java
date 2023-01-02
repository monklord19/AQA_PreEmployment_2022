package UITests;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class StepsDef {
   WebDriver driver = new ChromeDriver();

                @Given("I open login page")
                public void i_open_login_page() throws InterruptedException {
                    String test_url = "https://www.saucedemo.com/";

                    driver.manage().window().maximize();
                    driver.get(test_url);
                }

                @When("^I enter (.*) and (.*)$")
                public void i_enter_username_and_password(String user, String pass) throws Exception {

                    driver.findElement(By.id("user-name")).sendKeys(user);
                    driver.findElement(By.id("password")).sendKeys(pass);
                }

                @When("Click login button")
                public void click_login_button() {
                    // throw new io.cucumber.java.PendingException();
                    driver.findElement(By.id("login-button")).click();
                }

                @Then("Login successful, home page displayed")
                public void login_successful_home_page_displayed() throws InterruptedException {
                   if ( driver.findElement(By.id("shopping_cart_container")).isDisplayed()) {
                        driver.quit();
                   }
                    }

    @Then("Error message displayed")
    public void errorMessageDisplayed() throws InterruptedException {
        if (driver.findElement(By.className("error-button")).isDisplayed()){
                        driver.quit();
                    }
    }

    @And("Press enter key on keyboard")
    public void pressEnterKeyOnKeyboard() {
            driver.findElement(By.id("login-button")).sendKeys(Keys.ENTER);
    }
}



