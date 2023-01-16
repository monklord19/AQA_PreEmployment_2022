package demoPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementPage {
    WebDriver driver;
    WebDriverWait wait;

    By expandHomeButton = By.xpath("//button[@title='Toggle']");
    By doubleClickButton = By.id("doubleClickBtn");
    By rightClickButton = By.id("rightClickBtn");
    By clickButton = By.xpath("//button[contains(text(),'Click Me')]//following::button[2]");
    By doubleClickMessage = By.id("doubleClickMessage");
    By rightClickMessage = By.id("rightClickMessage");
    By clickMessage = By.id("dynamicClickMessage");
    By addNewRecordButton = By.id("addNewRecordButton");
    By firstNameField = By.id("firstName");
    By lastNameField = By.id("lastName");
    By emailField = By.id("userEmail");
    By ageField = By.id("age");
    By salaryField = By.id("salary");
    By departmentField = By.id("department");
    By registrationFormSubmitButton = By.id("submit");
    By editButton = By.xpath("//div[contains(text(),'Insurance')]//following-sibling::div/div/span" +
            "[@title='Edit']");
    By deleteButton = By.xpath("//div[contains(text(),'Compliance')]//following-sibling::div/div/span" +
            "[@title='Delete']");
    By uploadButton = By.id("uploadFile");
    By webTable = By.xpath("//div[@class='rt-table']");
    By firstLineAgeField = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/" +
            "div[1]/div/div[3]");
    By chooseFileButton = By.xpath("//input[@type='file']");
    By pathOfUploadedFile = By.id("uploadedFilePath");

    public ElementPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickOnElementItems(String elementItem) {
        String categoryElementItemXpath = "//span[contains(text(),'" + elementItem + "')]";
        WebElement meniuItemsElement = driver.findElement(By.xpath(categoryElementItemXpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", meniuItemsElement);
        wait.until(ExpectedConditions.visibilityOf(meniuItemsElement));
        meniuItemsElement.click();
    }

    public void clickOnExpandHomeButton() {
        WebElement expandHomeButtonElement = driver.findElement(expandHomeButton);
        expandHomeButtonElement.click();
    }

    public void clickOnCheckbox(String node) {
        String checkboxXpath = "//*[@id='tree-node-" + node.toLowerCase() + "']//following-sibling::span[@class=" +
                "'rct-checkbox']";
        WebElement checkboxElement = driver.findElement(By.xpath(checkboxXpath));
        checkboxElement.click();
    }

    public String messageIsDisplayed(String message) {
        By messageIsDisplayed = By.xpath("//span[@class='text-success' and text()='" + message + "']");
        WebElement messageIsDisplayedElement = driver.findElement(messageIsDisplayed);
        return messageIsDisplayedElement.getText();
    }

    public void doubleClickButtonAction() {
        Actions actions = new Actions(driver);
        WebElement doubleClickButtonElement = driver.findElement(doubleClickButton);
        actions.doubleClick(doubleClickButtonElement).perform();
    }

    public void rightClickButtonAction() {
        Actions actions = new Actions(driver);
        WebElement rightClickButtonElement = driver.findElement(rightClickButton);
        actions.contextClick(rightClickButtonElement).perform();
    }

    public void clickButtonAction() {
        WebElement clickButtonElement = driver.findElement(clickButton);
        clickButtonElement.click();
    }

    public boolean confirmationDoubleClickMessageIsDiplayed() {
        WebElement doubleClickMesageElement = driver.findElement(doubleClickMessage);
        return doubleClickMesageElement.isDisplayed();
    }

    public boolean confirmationRightClickMessageIsDiplayed() {
        WebElement rightClickMessageElement = driver.findElement(rightClickMessage);
        return rightClickMessageElement.isDisplayed();
    }

    public boolean confirmationClickMessageIsDiplayed() {
        WebElement clickMessageElement = driver.findElement(clickMessage);
        return clickMessageElement.isDisplayed();
    }

    public void clickOnAddButton() {
        WebElement addNewRecordButtonElement = driver.findElement(addNewRecordButton);
        addNewRecordButtonElement.click();
    }

    public void fillFirstNameField(String firstName) {
        WebElement firstNameFieldElement = driver.findElement(firstNameField);
        firstNameFieldElement.sendKeys(firstName);
    }

    public void fillLastNameField(String lastName) {
        WebElement lastNameFieldElement = driver.findElement(lastNameField);
        lastNameFieldElement.sendKeys(lastName);
    }

    public void fillEmailField(String email) {
        WebElement emailFieldElement = driver.findElement(emailField);
        emailFieldElement.sendKeys(email);
    }

    public void fillAgeField(String age) {
        WebElement ageFieldElement = driver.findElement(ageField);
        ageFieldElement.sendKeys(age);
    }

    public void fillSalaryField(String salary) {
        WebElement salaryFieldElement = driver.findElement(salaryField);
        salaryFieldElement.sendKeys(salary);
    }

    public void fillDepartmentField(String department) {
        WebElement departmentFieldElement = driver.findElement(departmentField);
        departmentFieldElement.sendKeys(department);
    }

    public void clickRegistrationFormSubmitButton() {
        WebElement registrationFormSubmitButtonElement = driver.findElement(registrationFormSubmitButton);
        registrationFormSubmitButtonElement.click();
    }

    public String checkIfNewFormIsRegistered() {
        WebElement webTableElement = driver.findElement(webTable);
        return webTableElement.getText();
    }

    public void clickEditButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(editButton));
        WebElement editButtonElement = driver.findElement(editButton);
        editButtonElement.click();
    }

    public void editAge(String age) {
        WebElement ageFieldElement = driver.findElement(ageField);
        ageFieldElement.clear();
        ageFieldElement.sendKeys(age);
    }

    public void deleteSecondLine() {
        WebElement deleteButtonElement = driver.findElement(deleteButton);
        deleteButtonElement.click();
    }

    public void clickUploadButton() {
        WebElement uploadButtonElement = driver.findElement(uploadButton);
        uploadButtonElement.click();
    }

    public String checkEditedAge() {
        WebElement firstLineAgeFieldElement = driver.findElement(firstLineAgeField);
        return firstLineAgeFieldElement.getText();
    }

    public void enterPath(String path){
        WebElement chooseFileInputElement = driver.findElement(chooseFileButton);
        chooseFileInputElement.sendKeys(path);
    }
    public String nameOfUploadedFile(){
        WebElement pathOfUploadedFileElement = driver.findElement(pathOfUploadedFile);
        return pathOfUploadedFileElement.getText();
    }

}
