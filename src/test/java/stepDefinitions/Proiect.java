package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.Demoqa;
import pageObjects.fillFormTextBox;
import pageObjects.fillFormWebTables;
import pageObjects.fillFormBookStore;

public class Proiect {
    WebDriver driver = new ChromeDriver();
    Demoqa button;
    fillFormTextBox fillFormTextBox;
    fillFormWebTables fillFormWebTables;
    fillFormBookStore fillFormBookStore;

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
    public void assertExcelFileText() {
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/ol/li[2]/span/label/span[1]")).click();
        button.assertExcelFileText();
    }

    //2nd scenario
    @And("User clicks on Text Box")
    public void clickTextBox() {
        button.clickTextBox();
    }

    @And("Fills the form")
    public void fillForm() {
        fillFormTextBox = new fillFormTextBox(driver);
        fillFormTextBox.fillTextBox();
    }

    @Then("Clicks submit")
    public void clickSubmitButton() {
        fillFormTextBox.clickSubmitButton();
    }

    //3rd scenario
    @And("Clicks Radio Button")
    public void clickRadioButton() {
        button.clickRadioButton();
    }

    @Then("Clicks Yes radio button")
    public void yesRadioButton() {
        button.yesRadioButton();
    }

    //4th scenario
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

    //5th scenario
    @And("Clicks Buttons")
    public void clickButtonsButton() {
        button.clickButtonsButton();
    }

    @And("Right clicks the 2nd button")
    public void rightClick() {
        button.rightClickSecondButton();
    }

    @Then("A message should appear")
    public void rightClickMessage() {
        button.assertTheRightClickMessage();
    }

    //6th scenario
    @And("Clicks Links")
    public void clickLinks() {
        button.clickLinksButton();
    }

    @And("Clicks Home7ndZl")
    public void click2ndLinkOpenNewTab() {
        button.click2ndLink();
    }

    @Then("The link will open in a new tab")
    public void linkOpenedInNewTab() {
    }

    //7th scenario
    @Given("User is on Date Picker")
    public void datePickerSubmenu() {
        driver.get("https://demoqa.com/date-picker");
        driver.manage().window().maximize();
    }

    @When("Selects next month")
    public void clickDatePicker() {
        button = new Demoqa(driver);
        button.clickdatePickerMonthYearInput();
        button.nextMonth();
    }

    @Then("Selects day")
    public void date() {
        button.clickSix();
    }

    //8th scenario
    @When("User clicks on Widgets")
    public void clickWidgets() {
        button = new Demoqa(driver);
        button.clickOnWidgets();
    }

    @And("Clicks on Menuu")
    public void clickMenuButton() {
        button.clickMenu();
    }

    @Then("Selects Sub Sub Item 1")
    public void hoverOnSubSubOne() {
        button.hoverOverSubSubItemOne();
        button.hoverSubSubList();
        button.hoverSubSubList();
        button.assertSubSubItemOne();
    }

    //9th scenario
    @And("Clicks on Slider")
    public void clickSliderButton() {
        button.clickSlider();
    }

    @Then("Moves the slider to 100")
    public void slideTo100() {
        button.moveSlider();
        button.assertSlider();
    }

    //10th scenario
    @Given("User is on Browser Windows")
    public void onBrowserWindows() {
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();
    }

    @When("Click New Window")
    public void clickOnNewWindowButton() {
    }

    @Then("Switches control to the new window to close it")
    public void switchAndClose() {
        button = new Demoqa(driver);
        button.switchToNewWindowAndCloseIt();
    }

    //11th scenario
    @Given("User is on Login page")
    public void loginPage() {
        driver.get("https://demoqa.com/login");
        driver.manage().window().maximize();
    }

    @When("User enters credentials")
    public void clickBookStore() {
        fillFormBookStore = new fillFormBookStore(driver);
        fillFormBookStore.fillUsernameAndPassword();
    }

    @Then("Clicks Login")
    public void fillFormBookStore() {
        fillFormBookStore.clickLogin();
    }
}
