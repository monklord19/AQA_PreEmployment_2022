package base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {
    public WebDriver driver = new ChromeDriver();
    public void setupApplication(){
        //public WebDriver driver = new ChromeDriver();
    }

    public void tearDown(){
        driver.close();
        System.out.println("Driver has closed successfull");
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public void wait(WebElement element){
        var w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.elementToBeClickable(element));

    }

    public void openBrowserandMaximize(String URL){
        driver.get(URL);
        driver.manage().window().maximize();
    }

    public void maximizePage(){
        driver.manage().window().maximize();
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }
}
