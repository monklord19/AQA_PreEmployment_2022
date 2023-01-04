package UITests.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    public static WebDriver driver = new ChromeDriver();
    private WebElement user_name_input;
    private WebElement password_input;
    private WebElement login_button;
    private WebElement error_message;
    public LoginPage(){
        driver.get("https://www.saucedemo.com/");
        setUser_name_input(driver.findElement(By.id("user-name")));
        setPassword_input(driver.findElement(By.id("password")));
        setLogin_button(driver.findElement(By.id("login-button")));

    }

    public void setError_message(WebElement error_message) {
        this.error_message = error_message;
    }

    public void setLogin_button(WebElement login_button) {
        this.login_button = login_button;
    }

    public void setPassword_input(WebElement password_input) {
        this.password_input = password_input;
    }

    public void setUser_name_input(WebElement user_name_input) {
        this.user_name_input = user_name_input;
    }

    public WebElement getError_message() {
        return error_message;
    }

    public WebElement getLogin_button() {
        return login_button;
    }

    public WebElement getPassword_input() {
        return password_input;
    }

    public WebElement getUser_name_input() {
        return user_name_input;
    }
    public void put_credentials(String User_name, String Password) {
        user_name_input.sendKeys(User_name);
        password_input.sendKeys(Password);
    }
    public void put_user_name(String User_name){
        user_name_input.sendKeys(User_name);
    }
    public void put_password(String Password){
        password_input.sendKeys(Password);
    }
    public void click_login(){
        login_button.click();
    }
}


