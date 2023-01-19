package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CheckBoxPage;
import pages.DemoElementsPage;
import pages.DemoPage;
import pages.TextBoxPage;

public class DemoQaSteps {
    WebDriver driver = new ChromeDriver();
    DemoPage demoPage = new DemoPage(driver);
    TextBoxPage textBoxPage = new TextBoxPage(driver);
    DemoElementsPage demoElementsPage = new DemoElementsPage(driver);
    CheckBoxPage checkBoxPage = new CheckBoxPage(driver);

    @Before
    public void maxPage() {
        driver.manage().window().maximize();
    }

    @After
    public void closePage() {

        driver.quit();
    }

    @Given("You are on the demoQa page")
    public void youAreOnTheDemoQaPage() {
        driver.get("https://demoqa.com/");
    }

    @Given("User Clicks on Text box")
    public void clickOnTheTextBoxLink() {
        demoPage.clickOnElelments();
        demoElementsPage.clickTextBoxLink();
    }

    @And("Complete the full name field with {string} and the email field with {string}")
    public void completeTheFullNameFieldWithAndTheEmailFieldWith(String fullName, String email) {
        textBoxPage.setFullNameField(fullName);
        textBoxPage.setEmailField(email);
    }


    @And("Complete the current address with {string} and  the permanent address with {string}")
    public void completeTheCurrentAddressWithAndThePermanentAddressWith(String currentAddress, String permanentAddress) {
        textBoxPage.setCurrentAddressField(currentAddress);
        textBoxPage.setPermanentAddressField(permanentAddress);
    }


    @When("Click the Submit button")
    public void clickTheSubmitButton() {
        textBoxPage.clickSubmitButton();
    }


    @Then("The information field will be displayed")
    public void theInformationFieldWillBeDisplayed() {
        textBoxPage.checkInfoBox();
    }
//Test 2

    @Given("Click on Check box")
    public void clickOnCheckBox() {
        demoPage.clickOnElelments();
        demoElementsPage.clickCheckBox();

    }

    @And("Click on expand all button")
    public void clickOnExpandAllButton() {
        checkBoxPage.clickExpandButton();
    }

    @When("Select React, Angular,Veu")
    public void selectReactAngularVeu() throws InterruptedException {
        checkBoxPage.clickTheCheckBoxes();
    }

    @Then("The specific select message should be displayed")
    public void theSpecificSelectMessageShouldBeDisplayed() {
        checkBoxPage.checkResultForm("You have selected :\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu");
    }
}
