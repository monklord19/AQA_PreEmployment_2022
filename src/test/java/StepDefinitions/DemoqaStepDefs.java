package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.demoqaHomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoqaStepDefs {
    WebDriver driver = new ChromeDriver();
    demoqaHomePage demoqaHome = new demoqaHomePage(driver);

    @Given("On the demoqa page")
    public void onTheDemoqaPage() {
        driver.get("https://demoqa.com/");
    }

    @When("I click Elements")
    public void iClickElements() {
        demoqaHomePage.clickElementsButton();
    }

    @Then("The Elements page opens")
    public void theElementsPageOpens() {
        WebElement confirmationTextElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div"));
        assertEquals("Elements", confirmationTextElement.getText());
        System.out.println("Elements page opened");
    }

    @When("I click Forms")
    public void iClickForms() {
        demoqaHomePage.clickFormsButton();
    }

    @Then("The Forms page opens")
    public void theFormsPageOpens() {
        WebElement confirmationTextElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div"));
        assertEquals("Forms", confirmationTextElement.getText());
        System.out.println("Forms page opened");
    }

    @When("I click Widgets")
    public void iClickWidgets() {
        demoqaHomePage.clickWidgetsButton();
    }

    @Then("The Widgets page opens")
    public void theWidgetsPageOpens() {
        WebElement confirmationTextElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div"));
        assertEquals("Widgets", confirmationTextElement.getText());
        System.out.println("Widgets page opened");
    }
}
