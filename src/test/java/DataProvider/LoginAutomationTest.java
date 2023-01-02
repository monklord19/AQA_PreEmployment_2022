package DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAutomationTest {
            public static void main(String[] args) {
                WebDriver driver = new ChromeDriver();
                driver.get("https://www.saucedemo.com/");

            //Provide username
                WebElement username = driver.findElement(By.id("user-name"));
                username.isDisplayed();
                username.isEnabled();
                username.sendKeys("standard_user");

            //Provide password
            WebElement password = driver.findElement(By.id("password"));
            password.isDisplayed();
            password.isEnabled();
            password.sendKeys("secret_sauce");

            //Click on Login button
                WebElement loginButton = driver.findElement(By.id("login-button"));
                loginButton.isDisplayed();
                loginButton.isEnabled();
                loginButton.click();
            }
}
