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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.demoqaElementsPage;
import pages.demoqaWidgetsPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pages.demoqaWidgetsPage.*;
public class DemoqaWidgetsStepDefs {

    WebDriver driver = new ChromeDriver();
    demoqaWidgetsPage demoqaWidgets = new demoqaWidgetsPage(driver);
    @Given("On the Widgets page")
    public void onTheWidgetsPage() {
        driver.get("https://demoqa.com/date-picker");
    }

    @When("I select the first of February, same year, in the Select Date date picker")
    public void iSelectTheFirstOfFebruarySameYearInTheSelectDateDatePicker() {
        WebElement datePicker = driver.findElement(By.cssSelector("#datePickerMonthYear > div.react-datepicker-wrapper > div"));
        datePicker.click();
        demoqaWidgetsPage.clickDate1February();
    }

    @Then("The Select Date text box contains the selected value")
    public void theSelectDateTextBoxContainsTheSelectedValue() {
        System.out.println("Date is selected.");
    }

}
