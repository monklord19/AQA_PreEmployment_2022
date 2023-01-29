package FrontendProjectTests.Stepsdefs;

import FrontendProjectTests.Utils.User;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MyStepdefs {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    @FindBy(id = "userName")
    private WebElement userNameInput;
    @FindBy(id = "userEmail")
    private WebElement userEmailInput;
    @FindBy(id = "currentAddress")
    private WebElement currentAddressInput;
    @FindBy(id = "permanentAddress")
    private WebElement permanentAddressInput;
    @FindBy(id= "submit")
    private WebElement submitButton;

    @FindBy(id = "output")
    private WebElement output;
    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/span/button")
    private WebElement expandHome;
    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button")
    private WebElement expandDocuments;
    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/span/button")
    private WebElement expandOffice;
    @FindBy(id = "result")
    private WebElement result;

    @Given("user opens website")
    public void userOpensWebsite() {
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
        //cod pentru scroll -- nu da commit
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,350)", "");
    }

    @And("user clicks on the Elements button")
    public void userClicksOnTheElementsButton() {
        WebElement element =  driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    @Given("user clicks on the Text Box button")
    public void userClicksOnTheTextBoxButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("item-0")));
        driver.findElement(By.id("item-0")).click();
    }

    @And("user completes the form")
    public void userCompletesTheForm() {
        User userDetails = new User();
        userNameInput.sendKeys(userDetails.getFirstName() + " " + userDetails.getLastName());
        userEmailInput.sendKeys(userDetails.getEmail());
        currentAddressInput.sendKeys(userDetails.getCurrentAddress());
        permanentAddressInput.sendKeys(userDetails.getPermanentAddress());
    }

    @When("user clicks on submit")
    public void userClicksOnSubmit() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        submitButton.click();
    }

    @Then("user's details should appear")
    public void userSDetailsShouldAppear() {
        Assert.assertTrue(output.isDisplayed());
    }

    @Given("user clicks on the Check Box button")
    public void userClicksOnTheCheckBoxButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("item-1")));
        driver.findElement(By.id("item-1")).click();

    }

    @When("user clicks on the Home expand button")
    public void userClicksOnTheHomeExpandButton() {
        expandHome.click();
    }

    @And("user clicks on the Documents expand button")
    public void userClicksOnTheDocumentsExpandButton() {
        wait.until(ExpectedConditions.visibilityOf(expandDocuments));
        expandDocuments.click();
    }

    @And("user checks {string} checkbox and uncheck {string} checkbox")
    public void userChecksOfficeCheckboxAndUncheckClassifiedCheckbox(String toCheck, String toUncheck) {
        wait.until(ExpectedConditions.visibilityOf(expandOffice));
        expandOffice.click();

        String checkId = "tree-node-" + toCheck;
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(checkId))));
        WebElement child = driver.findElement(By.id(checkId));
        WebElement parent = child.findElement(By.xpath("./.."));
        parent.click();

        String unCheckId = "tree-node-" + toUncheck;
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(unCheckId))));
        child = driver.findElement(By.id(unCheckId));
        parent = child.findElement(By.xpath("./.."));
        parent.click();
    }
    @Then("message is displayed {string}")
    public void message_is_displayed(String message) {
        Assert.assertTrue(result.getText().equals(message));

    }
    @Given("user clicks on the Web Tables button")
    public void userClicksOnTheWebTablesButton() {
    }

    @And("user searches for a person by details")
    public void userSearchesForAPersonByDetails() {
    }

    @And("user clicks on the edit button")
    public void userClicksOnTheEditButton() {
    }

    @And("user edits a person's details")
    public void userEditsAPersonSDetails() {
    }

    @Then("user checks if changes have been saved")
    public void userChecksIfChangesHaveBeenSaved() {
    }

    @Given("user clicks on the Links button")
    public void userClicksOnTheLinksButton() {
    }

    @When("user clicks on Home link")
    public void userClicksOnHomeLink() {
    }

    @Then("user checks if a new tab opens")
    public void userChecksIfANewTabOpens() {
    }

    @Given("user clicks on the Upload and Download button")
    public void userClicksOnTheUploadAndDownloadButton() {
    }

    @And("user clicks on Choose file button")
    public void userClicksOnChooseFileButton() {
    }

    @When("user chooses the file")
    public void userChoosesTheFile() {
    }



}
