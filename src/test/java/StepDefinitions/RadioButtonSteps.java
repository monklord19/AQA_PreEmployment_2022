package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class RadioButtonSteps {


    WebDriver driver = new ChromeDriver();

    @Given("On demo site {string}")
    public void onDemoSite(String url) {
        driver.get(url);
    }

    @When("User selects Impressive radio button")
    public void userSelectsImpressiveRadioButton() {
        WebElement impressiveRadioBtn = driver.findElement(By.cssSelector("input[value='Impressive']"));
        impressiveRadioBtn.isDisplayed();
        //impressiveRadioBtn.click();
    }

    @Then("Check label is displayed correctly")
    public void checkLabelIsDisplayedCorrectly() {
        WebElement checkedLabel = driver.findElement(By.className("text-success"));
        String checkedImpressiveLabel = checkedLabel.getText();
        String impressiveLabel = "Impressive";
        Assertions.assertEquals(impressiveLabel, checkedImpressiveLabel);
    }
}
