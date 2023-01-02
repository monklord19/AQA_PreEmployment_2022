import io.cucumber.java.en.*;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tema2 {
    WebDriver driver = new ChromeDriver();
    @Given("user opens website")
    public void userOpensWebsite() {

        driver.get("https://www.saucedemo.com/");
    }
    @Given("user enters a valid username as standard_user")
    public void userEntersAValidUsernameAsStandard_user() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }
    @And("user enters a valid password")
    public void userEntersAValidPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }
    @When("user clicks on login")
    public void userClicksOnLogin() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("the product page should open")
    public void theProductPageShouldOpen() {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.equals("https://www.saucedemo.com/inventory.html"));

    }


    @Given("user enters invalid username and invalid password")
    public void userEntersInvalidUsernameAndInvalidPassword() {
        driver.findElement(By.id("user-name")).sendKeys("username");
        driver.findElement(By.id("password")).sendKeys("secretsauce");
    }

    @Then("product page shouldn't open")
    public void productPageShouldnTOpen() {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.equals("https://www.saucedemo.com/"));

    }

    @And("error message is displayed {string}")
    public void errorMessageIsDisplayed(String arg0) {
         WebElement errordiv = driver.findElement(By.xpath("//h3[@data-test = 'error']"));
         Assert.assertTrue(errordiv.isDisplayed());

    }

   /* @Given("user doesn't enters username and password")
    public void userDoesnTEntersUsernameAndPassword() {
    }

    @Then("product page doesn't open")
    public void productPageDoesnTOpen() {
    }

    @Given("user enters valid username and invalid password")
    public void userEntersValidUsernameAndInvalidPassword() {
    }

    @Given("user enters invalid username and valid password")
    public void userEntersInvalidUsernameAndValidPassword() {
    }

    @Given("user enters valid username and empty password")
    public void userEntersValidUsernameAndEmptyPassword() {
    }

    @Given("user enters empty username and valid password")
    public void userEntersEmptyUsernameAndValidPassword() {
    }

    @Given("user enters valid username as locked_out_user")
    public void userEntersValidUsernameAsLocked_out_user() {
    }

    @And("user enters valid password as secret_sauce")
    public void userEntersValidPasswordAsSecret_sauce() {
    }

    @Given("user wants to retype username")
    public void userWantsToRetypeUsername() {
    }

    @When("user wants to press the x icon to delete")
    public void userWantsToPressTheXIconToDelete() {
    }

    @Then("username should be deleted so that the user can rewrite")
    public void usernameShouldBeDeletedSoThatTheUserCanRewrite() {
    }

    @But("doesn't work to delete the username")
    public void doesnTWorkToDeleteTheUsername() {
    }*/

}
