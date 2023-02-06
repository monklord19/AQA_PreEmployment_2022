package locators;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.io.File;

public class pageLocators {
    WebDriver driver;

    public pageLocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(className = "card-up")
    WebElement elementsButton;

    @FindBy(id = "item-2")
    WebElement radioButton;

    @FindBy(id = "item-0")
    WebElement textBox;

    @FindBy(id = "userName")
    WebElement fullName;

    @FindBy(id = "userEmail")
    WebElement email;

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(id = "output")
    WebElement confirmInformation;

    @FindBy(className = "custom-control-label")
    WebElement yesOption;

    @FindBy(className = "mt-3")
    WebElement yesTextAppears;

    @FindBy(id = "item-1")
    WebElement checkBox;

    @FindBy(className = "rct-checkbox")
    WebElement homeCheckBox;

    @FindBy(id = "result")
    WebElement homeDesktopTestAppears;

    @FindBy(id = "item-4")
    WebElement buttons;

    @FindBy(xpath = "//*[text()='Click Me']")
    WebElement clickMeButton;

    @FindBy(id = "dynamicClickMessage")
    WebElement dynamicClickTextAppears;

    @FindBy(id = "item-3")
    WebElement webTables;

    @FindBy(id = "addNewRecordButton")
    WebElement addNewRecordButton;

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "age")
    WebElement age;


    @FindBy(id = "salary")
    WebElement salary;

    @FindBy(id = "department")
    WebElement department;

    @FindBy(id = "submit")
    WebElement submit;

    @FindBy(className = "rt-table")
    WebElement table;

    @FindBy(id = "item-5")
    WebElement linksButton;

    @FindBy(id = "simpleLink")
    WebElement homeLink;

    @FindBy(id = "item-6")
    WebElement brokenLinks;

    @FindBy(linkText = "Click Here for Valid Link")
    WebElement validLink;

    @FindBy(id = "item-7")
    WebElement uploadAndDownload;

    @FindBy(id = "downloadButton")
    WebElement downloadButton;

    @FindBy(id = "item-8")
    WebElement dynamicsPropertiesButton;

    @FindBy(id = "enableAfter")
    WebElement enableAfterButton;

    @FindBy(id = "visibleAfter")
    WebElement visibleAfterButton;

    @FindBy(xpath = "//*[text()='Double Click Me']")
    WebElement doubleClickMeButton;

    @FindBy(id = "doubleClickMessage")
    WebElement doubleClickTextAppears;


    public void userClicksOnRadioButton() {
        radioButton.click();
    }

    public void userClicksOnElementsButton() {
        elementsButton.click();
    }

    public void userCLicksOnYesOption() {
        yesOption.click();
    }

    public void youHaveSelectedYesTextAppears() {
        WebElement text = yesTextAppears;
        String expectedText = "You have selected Yes";
        Assert.assertEquals(expectedText, text.getText());
        driver.quit();
    }

    public void userClicksOnCheckBox() {
        checkBox.click();
    }

    public void userClicksOnHomeCheckBox() {
        homeCheckBox.click();
    }

    public void youHaveSelectedHomeDesktopAppears() {
        WebElement text = homeDesktopTestAppears;
        String expectedText = """
                You have selected :
                home
                desktop
                notes
                commands
                documents
                workspace
                react
                angular
                veu
                office
                public
                private
                classified
                general
                downloads
                wordFile
                excelFile""";
        Assert.assertEquals(expectedText, text.getText());
        driver.quit();
    }

    public void userClicksOnButtonsButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
        buttons.click();
    }

    public void userCLicksOnClickMeButton() throws InterruptedException {
        Thread.sleep(2000);
        clickMeButton.click();
    }

    public void youHaveDoneADynamicClickTextAppears() {
        WebElement text = dynamicClickTextAppears;
        String expectedText = "You have done a dynamic click";
        Assert.assertEquals(expectedText, text.getText());
        driver.quit();
    }

    public void userClicksOnTextBoxButton() {
        textBox.click();
    }

    public void userFillsTheTextBoxes() {
        fullName.sendKeys("Ferdi Osman");
        email.sendKeys("osman_ferdi@yahoo.com");
        currentAddress.sendKeys("Zaharia Stancu 6D");
        permanentAddress.sendKeys("Romania");
    }

    public void userClicksOnSubmitButton() {
        submitButton.click();
    }

    public void theInformationIsConfirmed() {
        WebElement text = confirmInformation;
        String expectedText = """
                Name:Ferdi Osman
                Email:osman_ferdi@yahoo.com
                Current Address :Zaharia Stancu 6D
                Permananet Address :Romania""";
        Assert.assertEquals(expectedText, text.getText());
        driver.quit();
    }

    public void userClicksOnWebTablesButton() {
        webTables.click();
    }

    public void userClicksOnAddButton() {
        addNewRecordButton.click();
    }

    public void userFillsTheRegistrationFormAndClicksSubmit() {
        firstName.sendKeys("Ferdi");
        lastName.sendKeys("Osman");
        userEmail.sendKeys("osman_ferdi@yahoo.com");
        age.sendKeys("33");
        salary.sendKeys("2000");
        department.sendKeys("IT");
        submit.click();
    }

    public void theInformationIsSuccessfullyAdded() {
        Assert.assertTrue(table.getText().contains("Ferdi"));
        driver.quit();
    }


    public void userClicksOnLinksButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
        linksButton.click();
    }

    public void userClicksOnHomeButton() {
        homeLink.click();
    }

    public void newTabOpensOnDemoqaPage() {
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("DEMOQA"));
        driver.quit();
    }

    public void userClicksOnBrokenLinksButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(250,350)");
        brokenLinks.click();
    }

    public void userClicksOnValidLinkButton() {
        validLink.click();
    }


    public void userClicksOnUploadAndDownloadButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(250,350)");
        uploadAndDownload.click();
    }

    public void userClicksOnDownloadButton(){
        downloadButton.click();
    }

    public void sampleFileIsDownloaded() {
        File f = new File("C:/Users/Ferdi/Downloads/sampleFile.jpeg");
        f.exists();
        driver.quit();
    }

    public void userClicksOnDynamicsPropertiesButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(250,350)");
        dynamicsPropertiesButton.click();
    }

    public void userClicksOnEnableAfterButton() throws InterruptedException {
        Thread.sleep(5000);
        enableAfterButton.click();
    }

    public void buttonEnableAfterIsAvailable() {
        visibleAfterButton.click();
        driver.quit();
    }

    public void userClicksOnDoubleClickMeButton() throws InterruptedException {
        Thread.sleep(2000);
        Actions act = new Actions(driver);
        act.doubleClick(doubleClickMeButton).perform();

    }

    public void youHaveDoneADoubleClickTextAppears() {
        WebElement text = doubleClickTextAppears;
        String expectedText = "You have done a double click";
        Assert.assertEquals(expectedText, text.getText());
        driver.quit();
    }

}