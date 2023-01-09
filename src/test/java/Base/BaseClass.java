package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseClass {

    WebDriver driver;

    @BeforeMethod
    public void setupApplication(){
        Reporter.log("=====Browser Session Started=====", true);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void closeAplication(){
        driver.quit();
        Reporter.log("=====Browser Session Ended=====", true);

    }

}
