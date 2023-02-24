package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.demoqaElementsPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pages.demoqaElementsPage.*;

import org.openqa.selenium.interactions.Actions;

public class DemoqaElementsStepDefs {
    WebDriver driver = new ChromeDriver();
    demoqaElementsPage demoqaElements = new demoqaElementsPage(driver);

    @Given("On the Elements page")
    public void onTheElementsPage() {
        driver.get("https://demoqa.com/elements");
    }

    @When("I select the Text Box element")
    public void iSelectTheTextBoxElement() {
        demoqaElementsPage.clickTextBoxButton();
    }

    @And("I enter text in the Full name, Email, Current Address and Permanent Address fields")
    public void iEnterTextInTheFullNameEmailCurrentAddressAndPermanentAddressFields() {
        WebElement fieldFullName = driver.findElement(By.id("userName"));
        fieldFullName.sendKeys("Daliana");

        WebElement fieldEmail = driver.findElement(By.id("userEmail"));
        fieldEmail.sendKeys("daliana@yahoo.com");

        WebElement fieldCurrentAddress = driver.findElement(By.id("currentAddress"));
        fieldCurrentAddress.sendKeys("Cluj, Gheorgheni");

        WebElement fieldPermanentAddress = driver.findElement(By.id("permanentAddress"));
        fieldPermanentAddress.sendKeys("Cluj, Gheorgheni");
    }

    @And("I click Submit")
    public void iClickSubmit() {
        demoqaElementsPage.clickSubmitButton();
    }

    @Then("The data entered is displayed below the form")
    public void theDataEnteredIsDisplayedBelowTheForm() {
        assertTrue(driver.getPageSource().contains("Name:Daliana"));
        assertTrue(driver.getPageSource().contains("Email:daliana@yahoo.com"));
        assertTrue(driver.getPageSource().contains("Current Address :Cluj, Gheorgheni"));
        assertTrue(driver.getPageSource().contains("Permananet Address :Cluj, Gheorgheni"));
    }

    @When("I select the Radio Button item")
    public void iSelectTheRadioButtonItem() {
        demoqaElementsPage.clickRadioButtonItem();
    }

    @And("I select Yes")
    public void iSelectYes() {
        demoqaElementsPage.clickYesRadioButton();
    }

    @Then("Yes is selected and Impressive is unselected and No is disabled")
    public void yesIsSelectedAndImpressiveIsUnselectedAndNoIsDisabled() {
        assertTrue(yesRadioButton.isSelected());
        assertFalse(impressiveRadioButton.isSelected());
        assertFalse(noRadioButton.isEnabled());
    }

    @When("I select the Check Box item")
    public void iSelectTheCheckBoxItem() {
        demoqaElementsPage.clickCheckBoxItem();
    }

    @And("I click Expand All button")
    public void iClickExpandAllButton() {
        demoqaElementsPage.clickExpandAllButton();
    }

    @And("I select the Home check box")
    public void iSelectTheHomeCheckBox() {
        demoqaElementsPage.clickHomeCheckBox();
    }

    @Then("All check boxes in the list are selected")
    public void allCheckBoxesInTheListAreSelected() {
        assertTrue(driver.getPageSource().contains("You have selected :"));
        assertTrue(driver.getPageSource().contains("commands"));
        assertTrue(driver.getPageSource().contains("angular"));
        assertTrue(driver.getPageSource().contains("public"));
        assertTrue(driver.getPageSource().contains("classified"));
        assertTrue(driver.getPageSource().contains("wordFile"));
    }


    @When("I select the Buttons item")
    public void iSelectTheButtonsItem() {
        demoqaElementsPage.clickButtonsItem();
    }

    @And("I click Click Me")
    public void iClickClickMe() {
        demoqaElementsPage.clickClickMeButton();
    }

    @Then("The validation text is displayed")
    public void theValidationTextIsDisplayed() {
        assertTrue(driver.getPageSource().contains("You have done a dynamic click"));
    }

    @And("I click Right Click Me")
    public void iClickRightClickMe() {
        demoqaElementsPage.clickRightClickButton();
    }

    @Then("The right click validation text is displayed")
    public void theRightClickValidationTextIsDisplayed() {
        assertTrue(driver.getPageSource().contains("You have done a right click"));
    }

    @When("I select the Links item")
    public void iSelectTheLinksItem() {
        demoqaElementsPage.clickLinksItem();
    }

    @And("I click the Home dynamic link")
    public void iClickTheHomeDynamicLink() {
        demoqaElementsPage.clickDynamicLink();
    }

    @Then("The demoqa page opens in a new tab")
    public void theDemoqaPageOpensInANewTab() {
        Assert.assertEquals("DEMOQA", driver.getTitle());
    }
}
