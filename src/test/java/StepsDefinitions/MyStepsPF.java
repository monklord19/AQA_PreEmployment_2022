package StepsDefinitions;

import io.cucumber.java.en.*;
import locators.pageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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

    @When("User clicks on Check Box")
    public void userClicksOnCheckBox() {
        pfm.userClicksOnCheckBox();
    }
    @When("User clicks on Home Check Box")
    public void userClicksOnHomeCheckBox() {
        pfm.userClicksOnHomeCheckBox();
    }
    @Then("You have selected Home Desktop appears")
    public void youHaveSelectedHomeDesktopAppears() {
        pfm.youHaveSelectedHomeDesktopAppears();
    }

    @When("User clicks on Buttons button")
    public void user_clicks_on_buttons_button() {
//        WebElement buttons = driver.findElement(By.id("item-4"));
//        actions.moveToElement(buttons);
//        actions.perform();
        pfm.userClicksOnButtonsButton();
    }
    @When("User clicks on Click Me button")
    public void user_clicks_on_click_me_button() throws InterruptedException {
        pfm.userCLicksOnClickMeButton();
    }
    @Then("You have done a dynamic click text appears")
    public void you_have_done_a_dynamic_click_text_appears() {
        pfm.youHaveDoneADynamicClickTextAppears();
    }

}
