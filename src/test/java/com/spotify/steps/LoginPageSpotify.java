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

        if (ActualUrl.equals(ExpectedUrl)){
            System.out.println("Test Passed");}

        else{
            System.out.println(("Test Failed"));}
    }



    //SCENARIO 2


    @Given("User clicks the button {string} on the Login page")
    public void userClicksTheButtonOnTheLoginPage(String arg0) {
    }

    @And("User selects the option {string}")
    public void userSelectsTheOption(String arg0) {
    }

    @When("User enters valid email address in the {string} field")
    public void userEntersValidEmailAddressInTheEmailOrPhoneField() {
    }

    @And("User enters invalid password in the {string} field")
    public void userEntersInvalidPasswordInTheEnterYourPasswordField() {
    }
}
