package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.demoqaElementsPage;
import pages.demoqaWidgetsPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pages.demoqaWidgetsPage.*;
public class DemoqaWidgetsStepDefs {

    WebDriver driver = new ChromeDriver();
    demoqaWidgetsPage demoqaWidgets = new demoqaWidgetsPage(driver);
    @Given("On the Widgets page")
    public void onTheWidgetsPage() {
        driver.get("https://demoqa.com/widgets");
    }

    @When("I select the Date Picker item")
    public void iSelectTheDatePickerItem() {
       demoqaWidgetsPage.clickDatePicker();
    }

    @And("I Select Date")
    public void iSelectDate() {
        WebElement datePicker = driver.findElement(By.id("datePickerMonthYearInput"));
        datePicker.sendKeys("03/05/2022");
        datePicker.sendKeys(Keys.RETURN);
    }

    @Then("The Select Date text box contains the selected value")
    public void theSelectDateTextBoxContainsTheSelectedValue() {
        System.out.println("vezi daca merge");
    }
}
