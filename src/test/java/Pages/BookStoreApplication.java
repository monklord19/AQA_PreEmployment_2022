package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BookStoreApplication {
    WebDriver driver;
    WebDriverWait wait;

    public BookStoreApplication(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBookStoreApplication()
    {
        WebElement bookStoreApplication = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[6]"));
        bookStoreApplication.click();
    }

    public void typeBook(){
        WebElement typeBook = driver.findElement(By.xpath("//*[@id=\"searchBox\"]"));
        typeBook.sendKeys("Git");
    }

    public void checkBookByAuthor(){
        String author = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[3]")).getText();
        Assert.assertEquals(author, "Richard E. Silverman");
    }




}
