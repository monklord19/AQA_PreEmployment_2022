package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginPage {
    WebDriver driver = new ChromeDriver();

    public void URL(String url) {

        driver.get(url);
        driver.manage().window().maximize();


    }

    public void enterUsernameField(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);

    }

    public void enterPasswordField(String password) {
        driver.findElement(By.id("password")).sendKeys(password);

    }
    public void clickLoginButton()  {
        driver.findElement(By.id("login-button")).click();

    }

}
