package PageObjects;

import org.openqa.selenium.WebDriver;

public class BookStoreApiPage extends BasePage {
    public WebDriver driver;
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
    public BookStoreApiPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
}
