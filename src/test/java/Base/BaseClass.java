package Base;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseClass {

    public WebDriver driver;

    public BaseClass(WebDriver driver){
        this.driver =driver;
    }

    @BeforeMethod
    public void setupApplication(){
        //System.setProperty("webdriver.chrome.driver", "\"C:\\Users\\ASUS\\Desktop\\Drivers\\chromedriver.exe\"");
        Reporter.log("=====Browser Session Started=====", true);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Reporter.log("****Application Started****", true);
    }

    @AfterMethod
    public void closeAplication(){
        driver.quit();
        Reporter.log("=====Browser Session Ended=====", true);
       // driver.close();
    }

}