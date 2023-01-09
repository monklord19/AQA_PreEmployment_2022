package com.opensauce.steps;

import com.opensauce.pageObjects.LoginPage;
import selenium.BaseClass;
import selenium.Utils.PropertiesUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Properties;

public class LoginPageStepDefs1 extends BaseClass {

    Properties properties = PropertiesUtil.loadApplicationProperties();

    //Scenario 1 - Successful Login with valid credentials

    @Given("user enters valid username in the email field")
    public void userEntersValidUsernameInTheEmailField() {
        String username = properties.getProperty("username");
        LoginPage.enterUsername(username);
    }

    @And("user enters valid username in the password field")
    public void userEntersValidUsernameInThePasswordField() {
        String password = properties.getProperty("password");
        LoginPage.enterPassword(password);
    }


    @When("user clicks on the login button")
    public void userClicksOnTheLoginButton() {

        LoginPage.clickLogin();
    }


    @Then("user is logged in successfully")
    public void userIsLoggedInSuccessfully() {

    }
}


