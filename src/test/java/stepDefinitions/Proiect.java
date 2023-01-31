package stepDefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pageObjects.Demoqa;
import pageObjects.fillFormTextBox;
import pageObjects.fillFormWebTables;

public class Proiect {
    WebDriver driver = new ChromeDriver();
    Demoqa button;
    fillFormTextBox fillFormTextBox;

    fillFormWebTables fillFormWebTables;

    //1st scenario
    @Given("User is on Demoqa, Interactions tab")
    public void onDemoqaWebsite() {
        driver.get("https://demoqa.com/interaction");
        driver.manage().window().maximize();
    }

    @When("User clicks on Elements")
    public void elementsCheckBox() {
        button = new Demoqa(driver);
        button.clickElements();
    }

    @And("User clicks on Check Box")
    public void clickCheckBox() {
        driver.findElement(By.id("item-1")).click();
    }

    @And("Clicks to expand Home dropdown then Downloads dropdown")
    public void clickTwoDropdowns() {
        driver.findElement(By.cssSelector("#tree-node > ol > li > span > button > svg")).click();
        driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(3) > span > button > svg")).click();
    }

    @Then("Ticks Excel File")
    public void tickExcelFile() {
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/ol/li[2]/span/label/span[1]")).click();
        button.assertExcelFileText();
    }

    //2nd scenario
    @Given("User is on Demoqa, Interactions")
    public void demoqaInteractions() {
        driver.get("https://demoqa.com/interaction");
        driver.manage().window().maximize();
    }

    @And("User clicks on Text Box")
    public void clickTextBox() {
        //button = new Demoqa(driver);
        button.clickTextBox();
    }

    @And("Fills the form")
    public void fillForm() {
        fillFormTextBox = new fillFormTextBox(driver);
        fillFormTextBox.fillTextBoxAndClickSubmit();
    }

    @Then("Clicks submit")
    public void clickSubmitButton() {
        fillFormTextBox.clickSubmitButton();
    }

    //3rd scenario
    @Given("User is on Demoqa Interactions")
    public void homepage() {
        driver.get("https://demoqa.com/interaction");
        driver.manage().window().maximize();
    }

    @And("Clicks Radio Button")
    public void clickRadioButton() {
        button.clickRadioButton();
    }

    @Then("Clicks Yes radio button")
    public void yesRadioButton() {
        button.yesRadioButton();
    }

    //4th scenario
    @Given("User is on Demoqa Interactions 4")
    public void homepage4() {
        driver.get("https://demoqa.com/interaction");
        driver.manage().window().maximize();
    }

    @And("Clicks Web Tables")
    public void webTablesAndEdit() {
        button.clickWebTablesButton();
    }

    @And("Clicks edit")
    public void clickEdit() {
        button.clickEditCierraInfo();
    }

    @And("Fills registration form fields")
    public void editFields() {
        fillFormWebTables = new fillFormWebTables(driver);
        fillFormWebTables.editFields();
    }
    @Then("Clicks the submit button")
    public void clickSubmit() {
        fillFormWebTables.clickSubmitButton();
    }
}
