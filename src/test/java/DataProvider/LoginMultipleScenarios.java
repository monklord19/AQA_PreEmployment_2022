package DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginMultipleScenarios {

    @Test(dataProvider = "credentials")
    public void verifyLoginCredentials(String scenario, String username, String password) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();


        if (scenario.equals("bothwrong")){
            String errorMessage = driver.findElement(By.cssSelector(".error >h3")).getText();
            Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
        }
        else if(scenario.equals("correctpassword")){
            String errorMessage = driver.findElement(By.cssSelector(".error >h3")).getText();
            Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
        }
        else if(scenario.equals("correctusername")){
            String errorMessage = driver.findElement(By.cssSelector(".error >h3")).getText();
            Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
        }
        else if(scenario.equals("wrongpassword")){
            String errorMessage = driver.findElement(By.cssSelector(".error >h3")).getText();
            Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
        }

    }

    @DataProvider(name = "credentials")
    public Object[][] getData ()

    {
        return new Object[][]{
                {"bothcorrect", "standard_user", "secret_sauce"},
                {"bothwrong", "1234", "0987"},
                {"bothwrong", " ", " "},
                {"correctpassword", " ", "secret_sauce"},
                {"correctusername", "problem_user", " "},
                {"wrongpassword", "standard_user", "secret_santa"},
                {"bothwrong", "CHERRY", "PEAR"},
                {"bothwrong", "*^$#", "*^%$#"}
        };
    }




}
