package UITests.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
    public static WebDriver driver;
    protected WebElement username_input;
    protected WebElement password_input;
    protected WebElement login_button;

    public void setUsername_input(WebElement username_input) {
        this.username_input = username_input;
    }
    public void setPassword_input(WebElement password_input) {
        this.password_input = password_input;
    }

    public void setLogin_button(WebElement login_button) {
        this.login_button = login_button;
    }
    public void putCredentials(String user, String password){
        username_input.sendKeys(user);
        password_input.sendKeys(password);
    }
    public void clickLogin(){
        login_button.click();
    }
}
