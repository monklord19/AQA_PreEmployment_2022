package UITests.stepsDefinitions;

import UITests.pageObjects.PracticeFormPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Constants;
import utils.Endpoints;

public class PracticeFormSteps {

    WebDriver driver;
    PracticeFormPage practiceFormPage;

    @Given("I navigate to Practice Form Page")
    public void navigateToPracticeFormPage(){

        driver = new ChromeDriver();
        driver.get(Constants.BASE_URL + Endpoints.AUTOMATION_PRACTICE_FORM.get());
        driver.manage().window().maximize();
        practiceFormPage = new PracticeFormPage(driver);

    }


    @And("I see the Practice Form Page opened")
    public void seeThePageOpen(){
        Assert.assertTrue(practiceFormPage.isHeaderDisplayed());
    }
    //I enter my First Name
    @And("I enter my First Name: {string}")
    public void enterFirstName(String firstName){
        practiceFormPage.enterFirstName(firstName);
    }

    @And("I enter my Last Name: {string}")
    public void enterLastName(String lastName) {
        practiceFormPage.enterLastName(lastName);

    }

    @And("I select my gender: {string}")
    public void selectGender(String gender){
        practiceFormPage.selectGender(gender);
    }

    @And("I type my phone number: {string}")
    public void typePhoneNumber(String phone){
        practiceFormPage.enterPhoneNumber(phone);
    }

    @When("I press submit button")
    public void iPressSubmitButton() {
        practiceFormPage.clickSubmitButton();
    }

    @Then("The form was successfully submitted")
    public void theFormWasSuccessfullySubmitted() {
        Assert.assertTrue(practiceFormPage.isModalDisplayed());
    }

    @Then("The form was not successfully submitted")
    public void theFormWasNotSuccessfullySubmitted() {
        Assert.assertFalse(practiceFormPage.isModalDisplayed());
    }
}
