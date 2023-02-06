package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementsPage extends Page {
    public ElementsPage(WebDriver driver) {
        super(driver);
    }
    Actions action = new Actions(driver);

    By textBoxElem = By.xpath("//span[text()='Text Box']");
    By fullNameElem = By.cssSelector("#userName");
    By emailElem = By.cssSelector("#userEmail");
    By currentAddressElem = By.cssSelector("#currentAddress");
    By permanentAddressElem = By.cssSelector("#permanentAddress");
    By submitBtnElem = By.cssSelector(".btn.btn-primary");
    By brokenLinksElem = By.xpath("//span[text()='Broken Links - Images']");
    By outputBoxElem = By.cssSelector(".border.col-md-12.col-sm-12");
    By checkBoxElem = By.xpath("//span[text()='Check Box']");
    By homeCheckBoxElem = By.cssSelector(".rct-icon.rct-icon-uncheck");
    By messageFromCheckBoxElem = By.cssSelector("#result");
    By buttonsElem = By.xpath("//span[text()='Buttons']");
    By doubleClickBtnElem = By.cssSelector("#doubleClickBtn");
    By doubleClickMsgElem = By.cssSelector("#doubleClickMessage");
    By linksElem = By.xpath("//span[text()='Links']");
    By homeLinkElem = By.cssSelector("#simpleLink");
    By uploadAndDownloadElem = By.xpath("//span[text()='Upload and Download']");
    By chooseFileBtnElem = By.cssSelector("#uploadFile");
    By filepathElem = By.cssSelector("#uploadedFilePath");





    private WebElement textBox() {
        return driver.findElement(textBoxElem);
    }

    private WebElement fullName() {
        return driver.findElement(fullNameElem);
    }

    private WebElement email() {
        return driver.findElement(emailElem);
    }

    private WebElement currentAddress() {
        return driver.findElement(currentAddressElem);
    }

    private WebElement permanentAddress() {
        return driver.findElement(permanentAddressElem);
    }

    private WebElement submitBtn() {
        return driver.findElement(submitBtnElem);
    }

    private WebElement brokenLinks() {
        return driver.findElement(brokenLinksElem);
    }

    private WebElement outputBox() {
        return driver.findElement(outputBoxElem);
    }
    private WebElement checkBox() {
        return driver.findElement(checkBoxElem);
    }
    private WebElement homeCheckBox() {
        return driver.findElement(homeCheckBoxElem);
    }
    private WebElement messageFromCheckBox() {
        return driver.findElement(messageFromCheckBoxElem);
    }
    private WebElement buttons() {
        return driver.findElement(buttonsElem);
    }
    private WebElement doubleClickBtn() {
        return driver.findElement(doubleClickBtnElem);
    }
    private WebElement doubleClickMsg() {
        return driver.findElement(doubleClickMsgElem);
    }
    private WebElement links() {
        return driver.findElement(linksElem);
    }
    private WebElement homeLink() {
        return driver.findElement(homeLinkElem);
    }
    private WebElement uploadAndDownload() {
        return driver.findElement(uploadAndDownloadElem);
    }
    private WebElement chooseFileBtn() {
        return driver.findElement(chooseFileBtnElem);
    }
    private WebElement filePath() {
        return driver.findElement(filepathElem);
    }

    public void clickOnTextBox() {
        textBox().click();
    }

    public void setFullName() {
        fullName().sendKeys("Francesca");
    }

    public void setEmail() {
        email().sendKeys("test@test.com");
    }

    public void setCurrentAddress() {
        currentAddress().sendKeys("Address 15");
    }

    public void setPermanentAddress() {
        permanentAddress().sendKeys("Address 15");
    }

    public void clickOnSubmitBtn() {
        submitBtn().click();
    }

    public void moveToBrokenLinks() {
        action.moveToElement(brokenLinks()).perform();
    }

    public String getOutputBoxText() {
        return outputBox().getText();
    }
    public void clickOnCheckBox() {
        checkBox().click();
    }
    public void clickOnHomeCheckBox() {
        homeCheckBox().click();
    }
    public String getMsgFromCheckBox() {
        return messageFromCheckBox().getText();
    }
    public void clickOnButtons() {
        buttons().click();
    }
    public void doubleClickOnDoubleClickBtn() {
        action.doubleClick(doubleClickBtn()).perform();
    }
    public String getDoubleClickMsg() {
        return doubleClickMsg().getText();
    }
    public void clickOnLinks() {
        links().click();
    }
    public void clickOnHomeLink() {
        homeLink().click();
    }
    public void clickOnUploadAndDownload() {
        uploadAndDownload().click();
    }
    public void selectFile() {
        chooseFileBtn().sendKeys("C:/Users/franc/Downloads/GIT-Best-practices (1).pdf");

    }
    public boolean filePathIsDisplayed() {
        return filePath().isDisplayed();
    }

}
