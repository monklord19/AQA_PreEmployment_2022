package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public static WebDriver driver;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//h3")
    private WebElement errorMessage;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public void setUsername(String user){
        username.sendKeys(user);
    }

    public void setPassword(String pwd){
        password.sendKeys(pwd);
    }


    public void clickLogin( ){
        loginButton.click();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }

    public boolean isDisplayed(){
        username.isDisplayed();
        return true;
    }

}