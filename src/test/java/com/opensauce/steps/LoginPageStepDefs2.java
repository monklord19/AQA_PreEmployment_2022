package com.opensauce.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDefs2 {

    @Given("I open the https:\\/\\/www.saucedemo.com\\/ website")
    public void iOpenTheHttpsWwwSaucedemoComWebsite() {
    }

    @When("I enter a valid <userName>")
    public void iEnterAValidUserName() {
    }

    @And("enter an invalid <password>")
    public void enterAnInvalidPassword() {
    }

    @Then("I shouldn't be able to successfully login on the website")
    public void iShouldnTBeAbleToSuccessfullyLoginOnTheWebsite() {
    }

}
