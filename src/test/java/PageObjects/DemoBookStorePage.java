package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoBookStorePage extends BasePage {

    public WebDriver driver;
    By userNameLabel = By.id("userName");
    By passwordLabel = By.id("password");
    By searchLabel = By.className("form-control");

    public WebElement getBookStoreApplicationMenu(){
        return driver.findElement(By.xpath("//h5[contains(text(), 'Book Store Application')]"));
    }
    public WebElement getUserNameLabel(){
        return driver.findElement(userNameLabel);
    }
    public WebElement getPasswordLabel(){
        return driver.findElement(passwordLabel);
    }
    public WebElement getLoginButton(){
        return driver.findElement(By.id("login"));
    }
    public WebElement getGoToBookstoreButton(){
        return driver.findElement(By.id("gotoStore"));
    }
    public WebElement typeInSearchLabel(){
        return driver.findElement(searchLabel);
    }
    public WebElement getAddToYourCollectionButton(){
        return driver.findElement(By.xpath("//*[contains(text(), 'Add To Your Collection')]"));
    }
    public WebElement getProfileButtonSubmenu(){
        return driver.findElement(By.xpath("//li/span[text()='Profile']/parent::li"));
    }
    public WebElement getDeleteSingleRecordButton(){
        return driver.findElement(By.xpath("//*[@id='delete-record-undefined']"));
    }
    public WebElement getOkForSmallModalDeleteRecord(){
        return driver.findElement(By.xpath("//*[@id='closeSmallModal-ok']"));
    }
    public WebElement getBackToBookStore(){
        return driver.findElement(By.id("addNewRecordButton"));
    }
    public WebElement getDeleteAllBooksRecordButton(){
        return driver.findElement(By.xpath("//*[contains(text(), 'Delete All Books')]"));
    }
    public WebElement getLogOutAccountButton(){
        return driver.findElement(By.xpath("//*[contains(text(), 'Log out')]"));
    }
    public WebElement getDeleteAccountButton(){
        return driver.findElement(By.xpath("//*[contains(text(), 'Delete Account')]"));
    }
    public WebElement getFirstBook(){
        return driver.findElement(By.xpath("//a[@href='/books?book=9781449325862']"));
    }
    public WebElement getSecondBook(){
        return driver.findElement(By.xpath("//a[@href='/books?book=9781449331818']"));
    }

    public String baseUrl() {
        return "https://demoqa.com/Account/";
    }
    public String contentType(){
        return "application/json";
    }
    public String endpointCreateUser(){
        return baseUrl() + "v1/User";
    }
    public String endpointAuthorize(){
        return baseUrl() + "v1/Authorized";
    }
    public String endpointGenerateToken(){
        return baseUrl() + "v1/GenerateToken";
    }
    public DemoBookStorePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
}
