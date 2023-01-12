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

    @Then("Login can't log in")
    public void loginCanTLogIn() {

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
        driver.get("https://accounts.spotify.com/en/login");
//Select the option "Continue with Google"
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/ul/li[3]/button/span")).click();
    }

    @And("User selects the option USE ANOTHER ACCOUNT")
    public void userSelectsTheOptionUSEANOTHERACCOUNT() {
//Select the option "Use another account"
        driver.findElement(By.cssSelector("#identifierNext > div > button > span")).click();
    }

    @When("User enters valid email address in the EMAIL OR PHONE field")
    public void userEntersValidEmailAddressInTheEMAILORPHONEField() {
//Enter the valid email
        driver.findElement(By.id("#identifierId")).sendKeys("maniu.calinaclaudia@gmail.com");
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

    @Then("user is not logged in")
    public void userIsNotLoggedIn() {
    }




//Scenario 3
    @Given("User clicks the button CONTINUE WITH APPLE on the Login page")
    public void userClicksTheButtonCONTINUEWITHAPPLEOnTheLoginPage() {
        driver.get("https://accounts.spotify.com/en/login");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/ul/li[2]/button/span")).click();
    }

    @When("User enters valid Appple ID in the Apple ID field")
    public void userEntersValidApppleIDInTheAppleIDField() {
        driver.findElement(By.xpath("//*[@id=\"account_name_text_field\"]")).sendKeys("calina.c.maniu@gmail.com");
//Click the button "Next"
        driver.findElement(By.xpath("//*[@id=\"sign-in\"]/i")).click();
    }

    @And("User enters invalid password in the PASSWORD field")
    public void userEntersInvalidPasswordInThePASSWORDField() {
        driver.findElement(By.xpath("//*[@id=\"password_text_field\"]")).sendKeys("testpass");
        //Click the button "Next"
        driver.findElement(By.xpath("//*[@id=\"sign-in\"]/i")).click();
    }

    @Then("User cannot login on Spotify")
    public void userCannotLoginOnSpotify() {

        try{
            assert.Equals(driver.findElement(By.id("errMsg"))).getText(), "Your Apple ID or password was incorrect.";
//If the message is displayed
            System.out.println("PASS");
        } catch (Exception e){
//If the message is not displayed
            System.out.println("FAIL");
            verificationErrors.append(e.toString());
        }
    }
}







