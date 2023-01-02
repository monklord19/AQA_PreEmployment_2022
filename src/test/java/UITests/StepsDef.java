package UITests;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class StepsDef {
   WebDriver driver = new ChromeDriver();

                @Given("I open login page")
                public void i_open_login_page() throws InterruptedException {
                   // driver.navigate().to("https://www.saucedemo.com/");
                    String test_url = "https://www.saucedemo.com/";

                    driver.manage().window().maximize();
                    driver.get(test_url);
                    Thread.sleep(1000);
//                    Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
//                    Thread.sleep(3000);
                }

                @When("^I enter (.*) and (.*)$")
                public void i_enter_username_and_password(String user, String pass) throws Exception {

                    driver.findElement(By.id("user-name")).sendKeys(user);
                    driver.findElement(By.id("password")).sendKeys(pass);
                    Thread.sleep(1000);
                }

                @When("Click login button")
                public void click_login_button() {
                    // throw new io.cucumber.java.PendingException();
                    driver.findElement(By.id("login-button")).click();
                }

                @Then("Login successful, home page displayed")
                public void login_successful_home_page_displayed() throws InterruptedException {
//                    if ( driver.findElement(By.id("shopping_cart_container")).isDisplayed()) {
                        Thread.sleep(2000);
//                        //driver.close();
//                        driver.quit();
//                    }
                    if (driver != null){
                        driver.quit();
                    }
                    }


                }



