package spotify.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageSpotify {

    WebDriver driver = new ChromeDriver();

//SCENARIO 1

    @Given("User enters valid username in the username field")
    public void userEntersValidUsernameInTheUsernameField() {

        driver.get("https://accounts.spotify.com/en/login?continue=https%3A%2F%2Fopen.spotify.com%2F__noul__%3Fl2l%3D1%26nd%3D1&_locale=ro-RO");
        driver.findElement(By.id("login-username")).sendKeys("calina.c.maniu@gmail.com");
    }

    @And("User enters invalid password in the password field")
    public void userEntersInvalidPasswordInThePasswordField() {

        driver.findElement(By.id("login-password")).sendKeys("testpassword");
    }

    @When("User clicks on the login button")
    public void userClicksOnTheLoginButton() {

        driver.findElement(By.xpath("//*[@id=\"login-button\"]/div[1]/span")).click();
    }

    @Then("User is not logged in")
    public void userIsNotLoggedIn() {

        String ActualUrl = driver.getCurrentUrl();
        String ExpectedUrl = "https://open.spotify.com/?nd=1";

        if (ActualUrl.equals(ExpectedUrl)) {
            System.out.println("Test Passed");
        } else {
            System.out.println(("Test Failed"));
        }
    }



    //SCENARIO 2

    @Given("User clicks the button CONTINUE WITH GOOGLE on the Login page")
    public void userClicksTheButtonCONTINUEWITHGOOGLEOnTheLoginPage() {
        driver.get("https://accounts.spotify.com/en/login?continue=https%3A%2F%2Fopen.spotify.com%2F__noul__%3Fl2l%3D1%26nd%3D1&_locale=ro-RO");
//Select the option "Continue with Google"
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/ul/li[3]/button/span")).click();
    }

    @And("User selects the option USE ANOTHER ACCOUNT")
    public void userSelectsTheOptionUSEANOTHERACCOUNT() {
//Select the option "Use another account"
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/ul/li[3]/button/span")).click();
    }

    @When("User enters valid email address in the EMAIL OR PHONE field")
    public void userEntersValidEmailAddressInTheEMAILORPHONEField() {
//Enter the valid emial
        driver.findElement(By.id("identifierId")).sendKeys("maniu.calinaclaudia@gmail.com");
//Click the button "Next"
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
    }

    @And("User enters invalid password in the ENTER YOUR PASSWORD field")
    public void userEntersInvalidPasswordInTheENTERYOURPASSWORDField() {
//Enter the invalid email;
        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("test123");
//Click the button "Next"
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
    }

    @Then("User is not logged in")
    public void userIsNotLoggedonthesite() {

        String ActualUrl = driver.getCurrentUrl();
        String ExpectedUrl = "https://open.spotify.com/?nd=1";

        if (ActualUrl.equals(ExpectedUrl)) {
            System.out.println("Test Passed");
        } else {
            System.out.println(("Test Failed"));
        }
    }

}





