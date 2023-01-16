package StepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.pageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// This file runs with pageLocators file. This is Page Factory model.

public class MyStepsPF {
    WebDriver driver = new ChromeDriver();
    pageLocators pfm;

    @Given("User is on demoqa page")
    public void userIsOnDemoqaPage() {
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        pfm = new pageLocators(driver);
    }

    @Given("User clicks on Elements button")
    public void userClicksOnElementsButton() {

        pfm.userClicksOnElementsButton();
//        driver.findElement(By.className("card-up")).click();
    }

    @When("User clicks on Radio Button")
    public void userClicksOnRadioButton() {
        pfm.userClicksOnRadioButton();
//        driver.findElement(By.id("item-2")).click();
    }

    @When("User clicks on Yes option")
    public void userCLicksOnYesOption() {
        pfm.userCLicksOnYesOption();
//        driver.findElement(By.className("custom-control-label")).click();
    }
    @Then("You have selected Yes text appears")
    public void youHaveSelectedYesTextAppears() {
        pfm.youHaveSelectedYesTextAppears();
//        WebElement text = driver.findElement(By.className("mt-3"));
//        String expectedText = "You have selected Yes";
//        Assert.assertEquals(expectedText, text.getText());
    }

}
