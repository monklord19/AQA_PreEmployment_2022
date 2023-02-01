package com.DemoQA.SeleniumTesting.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import selenium.PageObjects.HomePage;
import selenium.Utils.BrowserUtils;


public class DemoQAFrontEndTesting {

    WebDriver driver;

    @Given("User selects the Elements section")
    public void userSelectsTheElementsSection() {
        HomePage.ElementsButton();
    }

    @And("User clicks on the Radio Button element")
    public void userClicksOnTheRadioButtonElement() {
    }

    @When("User selects the option <Impressive>")
    public void userSelectsTheOptionImpressive() {
    }

    @Then("The message: {string} is displayed")
    public void theMessageIsDisplayed(String arg0) {
    }
}




