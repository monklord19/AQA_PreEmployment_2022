package com.spotify.steps;

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
}


    //SCENARIO 2

    @Given("User clicks the button CONTINUE WITH GOOGLE on the Login page")
    public void userClicksTheButtonCONTINUEWITHGOOGLEOnTheLoginPage() {

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/ul/li[3]/button/span")).click();

    }

    @And("User selects the option USE ANOTHER ACCOUNT")
    public void userSelectsTheOptionUSEANOTHERACCOUNT() {

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/ul/li[3]/button/span")).click();

    }

    @When("User enters valid email address in the EMAIL OR PHONE field")
    public void userEntersValidEmailAddressInTheEMAILORPHONEField() {

        driver.findElement(By.id("identifierId")).sendKeys("maniu.calinaclaudia@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
    }

    @And("User enters invalid password in the ENTER YOUR PASSWORD field")
    public void userEntersInvalidPasswordInTheENTERYOURPASSWORDField() {

        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input");
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
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

}





