package demopageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
    By webTable = By.className("rt-table");
    By firstLineAgeField = By.xpath("//div[@role='rowgroup'][1]//div[@class='rt-td'][3]");

    By chooseFileButton = By.xpath("//input[@type='file']");
    By pathOfUploadedFile = By.id("uploadedFilePath");
    By outerFrame = By.id("frame1");
    By openAlertButton = By.xpath("//button[@id='alertButton']");
    By openTimerAlertButton = By.xpath("//button[@id='timerAlertButton']");
    By openConfirmationAlertButton = By.xpath("//button[@id='confirmButton']");
    By confirmationMessage = By.xpath("//span[@id='confirmResult']");
    By openPromptButton = By.xpath("//button[@id='promtButton']");
    By promptConfirmationMessage = By.xpath("//span[@id='promptResult']");
    By datePickerMonthYearInputField = By.id("datePickerMonthYearInput");
    By dateAndTimeInputField = By.id("dateAndTimePickerInput");
    By simpleDroppableButton = By.id("droppableExample-tab-simple");
    By draggableBox = By.id("draggable");
    By droppableBox = By.xpath("//div[@class='simple-drop-container']//div[@id='droppable']");
    By verticalListContainer = By.id("demo-tabpane-list");
    By selectValueField = By.xpath("//*[@id=\"withOptGroup\"]/div[1]");
    By singleValueField = By.className("css-1uccc91-singleValue");
    By selectOneField = By.xpath("//*[@id=\"selectOne\"]/div");
    By selectOneValueField = By.xpath("//div[@id='selectOne']/div/div//div[contains(text(),'Mr.')]");

    public ElementPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(7));
    }

    public void clickOnElementItems(String elementItem) {
        String categoryElementItemXpath = "//span[contains(text(),'" + elementItem + "')]";
        WebElement meniuItemsElement = driver.findElement(By.xpath(categoryElementItemXpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", meniuItemsElement);
        wait.until(ExpectedConditions.visibilityOf(meniuItemsElement));
        meniuItemsElement.click();
    }

    public void clickOnExpandHomeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(expandHomeButton));
        WebElement expandHomeButtonElement = driver.findElement(expandHomeButton);
        expandHomeButtonElement.click();
    }

    public void clickOnCheckbox(String node) {
        String checkboxXpath = "//*[@id='tree-node-" + node.toLowerCase() + "']//following-sibling::span[@class=" +
                "'rct-checkbox']";
        WebElement checkboxElement = driver.findElement(By.xpath(checkboxXpath));
        wait.until(ExpectedConditions.elementToBeClickable(checkboxElement));
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(doubleClickMessage));
        WebElement doubleClickMesageElement = driver.findElement(doubleClickMessage);
        return doubleClickMesageElement.isDisplayed();
    }

    public boolean confirmationRightClickMessageIsDiplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(rightClickMessage));
        WebElement rightClickMessageElement = driver.findElement(rightClickMessage);
        return rightClickMessageElement.isDisplayed();
    }

    public boolean confirmationClickMessageIsDiplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickMessage));
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

    public void enterPath(String path) {
        WebElement chooseFileInputElement = driver.findElement(chooseFileButton);
        chooseFileInputElement.sendKeys(System.getProperty("user.dir")+path);
    }

    public String nameOfUploadedFile() {
        WebElement pathOfUploadedFileElement = driver.findElement(pathOfUploadedFile);
        return pathOfUploadedFileElement.getText();
    }

    public String outerFrameText() {
        WebElement outerFrameElement = driver.findElement(outerFrame);
        driver.switchTo().frame(outerFrameElement);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body")));
        return driver.findElement(By.xpath("//html/body")).getText();
    }

    public String innerFrameText() {
        driver.switchTo().frame(0);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/p")));
        return driver.findElement(By.xpath("//html/body/p")).getText();
    }


    public void clickToOpenAlert() {
        WebElement openAlertButtonElement = driver.findElement(openAlertButton);
        openAlertButtonElement.click();
    }

    public String alertClickMessageIsDisplayed() {
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        return alertMessage;
    }

    public void clickToOpenTimerAlert() {
        WebElement openTimerAlertButtonElement = driver.findElement(openTimerAlertButton);
        openTimerAlertButtonElement.click();

    }

    public String alertTimerMessageIsDisplayed() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.accept();
        return alertMessage;
    }

    public void clickToOpenConfirmationAlert() {
        WebElement openConfirmationAlertButtonElement = driver.findElement(openConfirmationAlertButton);
        openConfirmationAlertButtonElement.click();
    }

    public String confirmationAlertMessageIsDisplayed() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement confirmationMessageElement = driver.findElement(confirmationMessage);
        return confirmationMessageElement.getText();
    }

    public void clickToOpenPromptAlert() {
        WebElement openPromptAlertButtonElement = driver.findElement(openPromptButton);
        openPromptAlertButtonElement.click();
    }

    public String promptAlertMessageIsDisplayed(String name) {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(name);
        alert.accept();
        WebElement promptConfirmationMessageActionElement = driver.findElement(promptConfirmationMessage);
        return promptConfirmationMessageActionElement.getText();
    }

    public void selectDateInPickerMonthYearInputField(int days) {
        WebElement datePickerMonthYearInputElement = driver.findElement(datePickerMonthYearInputField);
        String s = Keys.chord(Keys.CONTROL, "a");
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        Date currentDatePlustThirtyDays = calendar.getTime();
        String afterThirtyDays = dateFormat.format(currentDatePlustThirtyDays);
        datePickerMonthYearInputElement.sendKeys(s);
        datePickerMonthYearInputElement.sendKeys(Keys.DELETE);
        datePickerMonthYearInputElement.sendKeys(afterThirtyDays);
        datePickerMonthYearInputElement.sendKeys(Keys.ENTER);
    }

    public void selectDateAndTimeInputField(int days, int hours) {
        WebElement dateAndTimeInputFieldElement = driver.findElement(dateAndTimeInputField);
        String s = Keys.chord(Keys.CONTROL, "a");
        DateFormat dateFormat = new SimpleDateFormat();
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        calendar.add(Calendar.HOUR, hours);
        Date currentDatePlustThirtyDays = calendar.getTime();
        String afterThirtyDays = dateFormat.format(currentDatePlustThirtyDays);
        dateAndTimeInputFieldElement.sendKeys(s);
        dateAndTimeInputFieldElement.sendKeys(Keys.DELETE);
        dateAndTimeInputFieldElement.sendKeys(afterThirtyDays);
        dateAndTimeInputFieldElement.sendKeys(Keys.ENTER);
    }

    public void clickOnSimpleButton() {
        wait.until(ExpectedConditions.elementToBeClickable(simpleDroppableButton));
        WebElement simpleDroppableButtonElement = driver.findElement(simpleDroppableButton);
        simpleDroppableButtonElement.click();
    }

    public void dragAndDropBox() {
        WebElement draggableBoxElement = driver.findElement(draggableBox);
        WebElement droppableBoxElement = driver.findElement(droppableBox);
        wait.until(ExpectedConditions.elementToBeClickable(draggableBoxElement));
        Actions action = new Actions(driver);
        action.dragAndDrop(draggableBoxElement, droppableBoxElement).build().perform();
    }

    public String droppedMessageIsDisplayed() {
        WebElement droppableBoxElement = driver.findElement(droppableBox);
        return droppableBoxElement.getText();
    }

    public void clickTabType(String tab) {
        String tabTypeXpath = "//a[@id='demo-tab-" + tab.toLowerCase() + "']";
        WebElement tabTypeElement = driver.findElement(By.xpath(tabTypeXpath));
        tabTypeElement.click();
    }

    public void selectItemOnListTab(String itemName) {
        WebElement verticalListElement = driver.findElement(verticalListContainer);
        List<WebElement> verticalList = verticalListElement.findElements(
                By.xpath("//ul[@id='verticalListContainer']/li"));
        for (WebElement item : verticalList) {
            if (item.getText().contains(itemName)) {
                item.click();
                break;
            }
        }
    }

    public String selectedItemIsActive(String itemName) {
        WebElement verticalListElement = driver.findElement(verticalListContainer);
        List<WebElement> verticalList = verticalListElement.findElements(
                By.xpath("//ul[@id='verticalListContainer']/li"));
        String message = "";
        for (WebElement item : verticalList) {
            if (item.getText().contains(itemName)) {
                message = item.getAttribute("class");
                break;
            }
        }
        return message;
    }

    public void selectValueMeniu() {
        wait.until(ExpectedConditions.elementToBeClickable(selectValueField));
        WebElement selectValueFieldElement = driver.findElement(selectValueField);
        selectValueFieldElement.click();
    }

    public void selectValue(String value) {
        String valueXpath = "//div[contains(text(),'" + value + "')]";
        WebElement valueSelectedElement = driver.findElement(By.xpath(valueXpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", valueSelectedElement);
        wait.until(ExpectedConditions.visibilityOf(valueSelectedElement));
        valueSelectedElement.click();
    }

    public String singleValueIsSelected() {
        WebElement singleValueFieldElement = driver.findElement(singleValueField);
        return singleValueFieldElement.getText();
    }

    public void selectOneMeniu() {
        wait.until(ExpectedConditions.elementToBeClickable(selectOneField));
        WebElement selectOneValueFieldElement = driver.findElement(selectOneField);
        selectOneValueFieldElement.click();
    }
    public String oneValueIsSelected() {
        WebElement oneValueFieldElement = driver.findElement(selectOneValueField);
        return oneValueFieldElement.getText();
    }
    public void selectOldStyleSelectMenu(String color){
        Select selection = new Select(driver.findElement(By.id("oldSelectMenu")));
        selection.selectByVisibleText(color);
    }
    public boolean oldStyleSelectMennuSelection(String color){
        WebElement colorSelected = driver.findElement(By.xpath("//select[@id='oldSelectMenu']//option[contains(text(),'"+color+"')]"));
        Assert.assertTrue(colorSelected.isSelected());
        return true;
    }
}
