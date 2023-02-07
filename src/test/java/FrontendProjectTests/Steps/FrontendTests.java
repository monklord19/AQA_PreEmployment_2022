package FrontendProjectTests.Steps;

import FrontendProjectTests.PageObjects.*;
import Utils.User;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FrontendTests {
    private WebDriver driver = new ChromeDriver();
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    private User userDetails = new User();
    private Actions move = new Actions(driver);
    private String tag;
    private String multipleColor1, multipleColor2, singleColor1;
    private WebElement element1, element3, element5, element7, element9;
    private MenuPage menuPage;
    private FormPage formPage;
    private WebTablesPage webTablesPage;
    private CheckBoxPage checkBoxPage;
    private UploadAndDownloadPage uploadAndDownloadPage;
    private AlertsPage alertsPage;
    private AutoCompletePage autoCompletePage;
    private SelectablePage selectablePage;

    @After
    public final void baseTearDown() {
        driver.quit();
    }
    @Given("user opens website")
    public void userOpensWebsite() {
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
        menuPage = new MenuPage(driver);
        formPage = new FormPage(driver);
        webTablesPage = new WebTablesPage(driver);

    }

    @And("user clicks on the Elements button")
    public void userClicksOnTheElementsButton() {
        WebElement element =  menuPage.getElementsButton();
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    @Given("user clicks on the Text Box button")
    public void userClicksOnTheTextBoxButton() {
        WebElement element =  menuPage.getTextBoxButton();
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    @And("user completes the form")
    public void userCompletesTheForm() {
        formPage.getUserNameInput().sendKeys(userDetails.getFirstName() + " " + userDetails.getLastName());
        formPage.getUserEmailInput().sendKeys(userDetails.getEmail());
        formPage.getCurrentAddressInput().sendKeys(userDetails.getCurrentAddress());
        formPage.getPermanentAddressInput().sendKeys(userDetails.getPermanentAddress());
    }

    @When("user clicks on submit")
    public void userClicksOnSubmit() {
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,150)", "");
       formPage.getSubmitButton().click();
    }

    @Then("user's details should appear")
    public void userSDetailsShouldAppear() {
        Assert.assertTrue(formPage.getOutput().isDisplayed());
    }

    @Given("user clicks on the Check Box button")
    public void userClicksOnTheCheckBoxButton() {
        checkBoxPage = new CheckBoxPage(driver);
        WebElement element =  menuPage.getCheckBoxButton();
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    @When("user clicks on the Home expand button")
    public void userClicksOnTheHomeExpandButton() {
        checkBoxPage.getExpandHome().click();
    }

    @And("user clicks on the Documents expand button")
    public void userClicksOnTheDocumentsExpandButton() {
        wait.until(ExpectedConditions.visibilityOf(checkBoxPage.getExpandDocuments()));
        checkBoxPage.getExpandDocuments().click();
    }

    @And("user checks {string} checkbox and uncheck {string} checkbox")
    public void userChecksOfficeCheckboxAndUncheckClassifiedCheckbox(String toCheck, String toUncheck) {
        wait.until(ExpectedConditions.visibilityOf(checkBoxPage.getExpandOffice()));
        checkBoxPage.getExpandOffice().click();
        checkBoxPage.getCheckElement(toCheck).click();
        checkBoxPage.getCheckElement(toUncheck).click();
    }
    @Then("message is displayed {string}")
    public void message_is_displayed(String message) {
        Assert.assertTrue(checkBoxPage.getResult().getText().equals(message));

    }
    @Given("user clicks on the Web Tables button")
    public void userClicksOnTheWebTablesButton() {
        WebElement element =  menuPage.getWebTablesButton();
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    @And("user searches for a person by {string}")
    public void userSearchesForAPersonByName(String name) {
        webTablesPage.getSearchBox().click();
        webTablesPage.getSearchBox().sendKeys(name);

    }
    @And("user clicks on the edit button")
    public void userClicksOnTheEditButton() {
        wait.until(ExpectedConditions.elementToBeClickable(webTablesPage.getEditRecord()));
        webTablesPage.getEditRecord().click();

    }

    @And("user edits a person's details")
    public void userEditsAPersonSDetails() {
        webTablesPage.getFirstName().clear();
        webTablesPage.getFirstName().sendKeys(userDetails.getFirstName());
        webTablesPage.getLastName().clear();
        webTablesPage.getLastName().sendKeys(userDetails.getLastName());
        webTablesPage.getUserEmail().clear();
        webTablesPage.getUserEmail().sendKeys((userDetails.getEmail()));
        webTablesPage.getAge().clear();
        webTablesPage.getAge().sendKeys(String.valueOf(userDetails.getAge()));
        webTablesPage.getSalary().clear();
        webTablesPage.getSalary().sendKeys(String.valueOf(userDetails.getSalary()));
        webTablesPage.getDepartment().clear();
        webTablesPage.getDepartment().sendKeys(userDetails.getDepartment());
    }

    @Then("user checks if changes have been saved")
    public void userChecksIfChangesHaveBeenSaved() {
        webTablesPage.getSearchBox().clear();
        webTablesPage.getSearchBox().sendKeys(Keys.SPACE);
        webTablesPage.getSearchBox().sendKeys(Keys.BACK_SPACE);
        String[] details = webTablesPage.getRow().getText().split("\n");
        Assert.assertTrue(details[0].equals(userDetails.getFirstName()));
        Assert.assertTrue(details[1].equals(userDetails.getLastName()));
        Assert.assertTrue(details[2].equals(String.valueOf(userDetails.getAge())));
        Assert.assertTrue(details[3].equals(userDetails.getEmail()));
        Assert.assertTrue(details[4].equals(String.valueOf(userDetails.getSalary())));
        Assert.assertTrue(details[5].equals(userDetails.getDepartment()));
    }

    @Given("user clicks on the Links button")
    public void userClicksOnTheLinksButton() {
        WebElement element =  menuPage.getLinksButton();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", "");
        element.click();
    }

    @When("user clicks on Home link")
    public void userClicksOnHomeLink() {
        driver.findElement(By.id("simpleLink")).click();
    }

    @Then("user checks if a new tab opens")
    public void userChecksIfANewTabOpens() {
        Assert.assertTrue(driver.getWindowHandles().size() == 2);
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertTrue(driver.getCurrentUrl().equals("https://demoqa.com/"));
        driver.quit();
    }

    @Given("user clicks on the Upload and Download button")
    public void userClicksOnTheUploadAndDownloadButton() {
        uploadAndDownloadPage = new UploadAndDownloadPage(driver);
        WebElement element =  menuPage.getUploadAndDownloadButton();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", "");
        element.click();
    }

    @And("user clicks on Download file button")
    public void userClicksOnDownloadFileButton() {
        uploadAndDownloadPage.getDownloadButton().click();
    }


    @When("user chooses the file")
    public void userChoosesTheFile() {
        WebElement chooseFile = uploadAndDownloadPage.getUploadFile();
        chooseFile.sendKeys("C:\\Users\\Stefana Ivascu\\Downloads\\sampleFile.jpeg");
    }


    @Then("user checks if file is uploaded")
    public void userChecksIfFileIsUploaded() {
        Assert.assertTrue(uploadAndDownloadPage.getUploadedFile().getText().equals("C:\\fakepath\\sampleFile.jpeg"));
    }

    @Given("user clicks on the Alerts button")
    public void userClicksOnTheAlertsButton() {
        alertsPage = new AlertsPage(driver);
        WebElement alertsFrameWindowsButton =  menuPage.getAlertsFrameWindowsButton();
        WebElement alertsButton = menuPage.getAlertsButton();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
        wait.until(ExpectedConditions.elementToBeClickable(alertsFrameWindowsButton));
        alertsFrameWindowsButton.click();
        wait.until(ExpectedConditions.visibilityOf(alertsButton));
        alertsButton.click();
        js.executeScript("window.scrollBy(0,-500)", "");
    }
    @When("user clicks on Click me button for confirm box")
    public void userClicksOnClickMeButtonForConfirmBox() {
        wait.until(ExpectedConditions.elementToBeClickable(alertsPage.getConfirmButton()));
        alertsPage.getConfirmButton().click();
    }
    @And("user checks if alerts appear")
    public void userChecksIfAlertsAppear() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    @And("user clicks on Click me button for prompt box")
    public void userClicksOnClickMeButtonForPromptBox() {
        wait.until(ExpectedConditions.elementToBeClickable(alertsPage.getPromtButton()));
        alertsPage.getPromtButton().click();

    }
    @Then("user enters their name")
    public void userEntersTheirName() {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(userDetails.getFirstName());
        alert.accept();

    }

    @And("user checks if message is displayed")
    public void userChecksIfMessageIsDisplayed() {
        Assert.assertTrue(alertsPage.getConfirmResult().getText().equals("You selected Ok"));
        Assert.assertTrue(alertsPage.getPromptResult().getText().equals("You entered "+ userDetails.getFirstName()));

    }

    @Given("user clicks on the autocomplete button")
    public void userClicksOnTheAutocompleteButton() {
        autoCompletePage = new AutoCompletePage(driver);
        WebElement widgetsButton = menuPage.getWidgetsButton();
        WebElement autoComplete = menuPage.getAutoComplete();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,580)", "");
        wait.until(ExpectedConditions.elementToBeClickable(widgetsButton));
        widgetsButton.click();
        wait.until(ExpectedConditions.visibilityOf(autoComplete));
        autoComplete.click();
        js.executeScript("window.scrollBy(0,-580)", "");
    }

    @When("user enters first part of {string} and {string} in first input")
    public void userEntersFirstPartOfAndInFirstInput(String color, String color1) {
        multipleColor1 = color;
        multipleColor2 = color1;
        WebElement multipleInput = autoCompletePage.getAutoCompleteMultipleInput();
        wait.until(ExpectedConditions.visibilityOf(multipleInput));
        multipleInput.sendKeys(color.substring(0,2));
        multipleInput.sendKeys(Keys.ENTER);
        multipleInput.sendKeys(color1.substring(0,2));
        multipleInput.sendKeys(Keys.ENTER);
    }

    @When("user enters first part of {string} in second input")
    public void userEntersFirstPartOfInSecondInput(String color) {
        singleColor1 = color;
        WebElement singleInput = autoCompletePage.getAutoCompleteSingleInput();
        singleInput.sendKeys(color.substring(0,2));
        singleInput.sendKeys(Keys.ENTER);
    }

    @Then("uesr checks if coresponding color is selected")
    public void uesrChecksIfCorespondingColorIsSelected() {
        List<WebElement> multipleColor = driver.findElements(By.cssSelector(".css-1rhbuit-multiValue.auto-complete__multi-value"));
        String colorSingle = driver.findElement(By.cssSelector(".auto-complete__single-value.css-1uccc91-singleValue")).getText();
        System.out.println(colorSingle);
        System.out.println(multipleColor.get(0).getText());
        System.out.println(multipleColor.get(1).getText());
        Assert.assertTrue(multipleColor.get(0).getText().equals(multipleColor1));
        Assert.assertTrue(multipleColor.get(1).getText().equals(multipleColor2));
        Assert.assertTrue(colorSingle.equals(singleColor1));
    }

    @Given("user clicks on the Slider button")
    public void userClicksOnTheSliderButton() {
        WebElement widgetsButton = menuPage.getWidgetsButton();
        WebElement slider = menuPage.getSliderButton();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,580)", "");
        wait.until(ExpectedConditions.visibilityOf(widgetsButton));
        widgetsButton.click();
        wait.until(ExpectedConditions.visibilityOf(slider));
        slider.click();
        js.executeScript("window.scrollBy(0,-580)", "");
    }

    @When("user moves slider")
    public void userMovesSlider() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".range-slider.range-slider--primary"))));
        WebElement slider = driver.findElement(By.cssSelector(".range-slider.range-slider--primary"));
        for (int i = 1; i <= 20 ; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    @Then("user checks if the slider is moved")
    public void userChecksIfTheSliderIsMoved() {
        String sliderValue = driver.findElement(By.id("sliderValue")).getAttribute("value");
        System.out.println(sliderValue);
        Assert.assertTrue(Integer.valueOf(sliderValue) == 45);
    }


    @Given("user clicks on the Selectable button")
    public void userClicksOnTheSelectableButton() {
        selectablePage = new SelectablePage(driver);
        WebElement interactionButton = menuPage.getInteractionsButton();
        WebElement selectableButton = menuPage.getSelectableButton();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,630)", "");
        wait.until(ExpectedConditions.visibilityOf(interactionButton));
        interactionButton.click();
        wait.until(ExpectedConditions.visibilityOf(selectableButton));
        selectableButton.click();
        js.executeScript("window.scrollBy(0,-630)", "");

    }

    @When("user selects odd labels")
    public void userSelectsOddLabels() {
        selectablePage.getDemoGrid().click();
        selectablePage.getElement1().click();
        selectablePage.getElement3().click();
        selectablePage.getElement5().click();
        selectablePage.getElement7().click();
        selectablePage.getElement9().click();
    }

    @Then("user checks if the labels is selected")
    public void userChecksIfTheLabelsIsSelected() {
        Assert.assertTrue(selectablePage.getElement1().getAttribute("class").contains("active"));
        Assert.assertTrue(selectablePage.getElement3().getAttribute("class").contains("active"));
        Assert.assertTrue(selectablePage.getElement5().getAttribute("class").contains("active"));
        Assert.assertTrue(selectablePage.getElement7().getAttribute("class").contains("active"));
        Assert.assertTrue(selectablePage.getElement9().getAttribute("class").contains("active"));

    }
    @Given("user clicks on Droppable button")
    public void userClicksOnDroppableButton() {
        WebElement interactionButton = menuPage.getInteractionsButton();
        WebElement droppableButton = menuPage.getDroppableButton();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,630)", "");
        wait.until(ExpectedConditions.visibilityOf(interactionButton));
        interactionButton.click();
        wait.until(ExpectedConditions.visibilityOf(droppableButton));
        droppableButton.click();
        js.executeScript("window.scrollBy(0,-630)", "");
    }


    @When("user drags the {string} to drop area")
    public void userDragsTheCevaToDropArea(String tag) {
        Actions action = new Actions(driver);
        this.tag = tag;
        driver.findElement(By.id("droppableExample-tab-accept")).click();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        WebElement From = driver.findElement(By.id(tag));
        WebElement To = driver.findElements(By.id("droppable")).get(1);
        action.dragAndDrop(From, To).build().perform();

    }
    @Then("user checks if the element is accepted or not")
    public void userChrecksIfTheElementIsAcceptedOrNot() {
        WebElement To = driver.findElements(By.id("droppable")).get(1);
        String textTo = To.getText();
        if(tag.equals("acceptable"))
        {
            Assert.assertTrue(textTo.equals("Dropped!"));
        }
        else {
            Assert.assertFalse(textTo.equals("Dropped!"));
        }

    }
}
