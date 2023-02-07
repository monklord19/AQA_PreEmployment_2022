package Frontend.PageObjects;

import Configurations.FrontendConfigs.FrontendPropertiesReader;
import Frontend.Locators.ElementsLocators;
import Frontend.Steps.TestBase;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ElementsPage extends TestBase {
    private ElementsLocators elementsLocators = PageFactory.initElements(driver, ElementsLocators.class);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Actions actions = new Actions(driver);
    JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;


    //ELEMENTS SECTION METHODS
    public void clickOnElementsSection() {
        WebElement elementsSection = elementsLocators.getElementsSection();
        //clicking on elements within an SVG using XPath
        actions.moveToElement(elementsSection).click().build().perform();
    }

    //RADIO BUTTON METHODS
    public void clickOnRadioButtonSection() {
        elementsLocators.getRadioButtonSection().click();
    }

    public void clickOnImpressiveRadioButton() {
        elementsLocators.getImpressiveRadioButton().click();
    }

    public void assertImpressiveMessage() {
        WebElement impressiveMessageOnSite = elementsLocators.getImpressiveMessage();
        System.out.println(impressiveMessageOnSite);
        wait.until(ExpectedConditions.visibilityOf(impressiveMessageOnSite));
        String impressiveMessageFromProperties = FrontendPropertiesReader.getImpressive_message();
        System.out.println(impressiveMessageFromProperties);
        Assert.assertEquals(impressiveMessageOnSite.getText(), impressiveMessageFromProperties);
    }

    //CHECK BOX METHODS
    public void clickOnCheckBoxSection() {
        elementsLocators.getCheckBoxSection().click();
    }

    public void clickOnHomeCheckbox() {
        elementsLocators.getHomeCheckBox().click();
    }

    public void assertHomeCheckboxMessage() {
        WebElement homeCheckBoxMessageOnSite = elementsLocators.getHomeCheckBoxMessage();
        wait.until(ExpectedConditions.visibilityOf(homeCheckBoxMessageOnSite));
        Assert.assertEquals(homeCheckBoxMessageOnSite.getText(), FrontendPropertiesReader.getHomeCheckBoxMessage());
    }

    //TEXT BOX METHODS
    public void clickOnTextBoxSection() {
        elementsLocators.getTextBoxSection().click();
    }

    public void fillingAllTextFieldsWithValidValues() {
        elementsLocators.getFullNameTextField().sendKeys(FrontendPropertiesReader.getFullName());
        elementsLocators.getEmailTextField().sendKeys(FrontendPropertiesReader.getEmail());
        elementsLocators.getCurrentAddressTextField().sendKeys(FrontendPropertiesReader.getCurrentAddress());
        elementsLocators.getPermanentAddressTExtField().sendKeys(FrontendPropertiesReader.getPermanentAddress());
        elementsLocators.getSubmitButton().click();
    }

    public void clickSubmitButton() {
        elementsLocators.getSubmitButton().click();
    }

    public void assertTextBoxSection() {
        String name = FrontendPropertiesReader.getFullName();
        WebElement nameFromTextBoxForm=elementsLocators.getNameFromTextBoxSection();
        Assert.assertNotNull(nameFromTextBoxForm.getText().contains(name));
    }
    //WEB TABLES METHODS

    public void clickOnWebTablesSection() {
        actions.moveToElement(elementsLocators.getWebTablesSection()).click().build().perform();
    }

    public void addAUserWithAllInfo() {
        wait.until(ExpectedConditions.visibilityOf(elementsLocators.getAddButton()));
        elementsLocators.getAddButton().click();
        elementsLocators.getFirstNameTextField().sendKeys(FrontendPropertiesReader.getFirstName());
        elementsLocators.getLastName().sendKeys(FrontendPropertiesReader.getLastName());
        elementsLocators.getEmailTextField().sendKeys(FrontendPropertiesReader.getEmail());
        elementsLocators.getAgeTextField().sendKeys(FrontendPropertiesReader.getAge());
        elementsLocators.getSalaryTextField().sendKeys(FrontendPropertiesReader.getSalary());
        elementsLocators.getDepartmentTextField().sendKeys(FrontendPropertiesReader.getDepartment());
    }

    public void searchUserByFirstName() {
        String firstName = FrontendPropertiesReader.getFirstName();
        wait.until(ExpectedConditions.visibilityOf(elementsLocators.getSearchBox()));
        elementsLocators.getSearchBox().sendKeys(firstName);
        WebElement loopIcon = elementsLocators.getSearchLoopIcon();
        actions.moveToElement(loopIcon).click().build().perform();
    }
    public void assertUserIsDisplayedOnWebTables() throws InterruptedException {
        Thread.sleep(1000);
        String name = FrontendPropertiesReader.getFirstName();
        Assert.assertEquals(name,elementsLocators.getTableGridCell().getText());
    }

    //BUTTONS METHODS
    public void clickOnButtonsCategory() {
        elementsLocators.getButtonsSection().click();
    }

    public void doubleClickButton() throws InterruptedException {
        WebElement doubleClickButton = elementsLocators.getDoubleClickMeButton();
        actions.doubleClick(doubleClickButton).perform();
        Thread.sleep(2000);
    }
    public void assertDoubleClickMessage(){
        WebElement doubleClickMessageOnSite=elementsLocators.getDoubleClickMessage();
        String doubleClickMessage=FrontendPropertiesReader.getDoubleClickMessage();
        Assert.assertEquals(doubleClickMessage,doubleClickMessageOnSite.getText());
    }

    public void rightClickButton() throws InterruptedException {
        WebElement rightClickButton= elementsLocators.getRightClickButton();
        actions.contextClick(rightClickButton).perform();
        Thread.sleep(2000);
    }
    public void assertRightClickMessage(){
        WebElement rightClickMessageOnSite=elementsLocators.getRightClickMessage();
        String localRightClickMessage=FrontendPropertiesReader.getRightClickMessage();
        Assert.assertEquals(localRightClickMessage,rightClickMessageOnSite.getText());
    }

    //UPLOAD FILE METHODS
    public void clickOnUploadAndDownloadSection() throws InterruptedException {
        WebElement uploadAndDownloadSection=elementsLocators.getUploadAndDownloadSection();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",uploadAndDownloadSection);
        uploadAndDownloadSection.click();
        Thread.sleep(2000);
    }

    public void iUploadAFile() throws InterruptedException {
        WebElement chooseFile=elementsLocators.getChooseFileButton();
        chooseFile.sendKeys("C://Users//Madalina//Desktop//cocomelon.jpg");
        Thread.sleep(2000);
    }
    public void assertFileIsUploaded(){
        WebElement uploadedFilePath=elementsLocators.getUploadedFilePath();
        Assert.assertTrue(uploadedFilePath.getText().contains("cocomelon.jpg"));
    }
    //LINKS METHODS
    public void clickOnLinksSection() throws InterruptedException {
        WebElement linksSection=elementsLocators.getLinksSection();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",linksSection);
        linksSection.click();
        Thread.sleep(1000);
    }
    public void clickOnHomeLink() throws InterruptedException {
        WebElement homeLink=elementsLocators.getHomeLink();
        homeLink.sendKeys(Keys.CONTROL,Keys.RETURN);
        Thread.sleep(2000);
    }
    public void switchToTab() throws InterruptedException {
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
        Thread.sleep(2000);
    }
    public void assertOpenedTab(){
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        WebElement seleniumImage=elementsLocators.getSeleniumImage();
        Assert.assertTrue(seleniumImage.isDisplayed());
        driver.switchTo().window(browserTabs.get(0));
    }
}
