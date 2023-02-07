package FrontendProjectTests.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadAndDownloadPage {
    WebDriver driver;
    @FindBy(id = "downloadButton")
    WebElement downloadButton;
    @FindBy(id = "uploadFile")
    WebElement uploadFile;
    @FindBy( id = "uploadedFilePath")
    private WebElement uploadedFile;

    public UploadAndDownloadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement getDownloadButton() {
        return downloadButton;
    }
    public WebElement getUploadFile() {
        return uploadFile;
    }
    public WebElement getUploadedFile() {
        return uploadedFile;
    }

}
