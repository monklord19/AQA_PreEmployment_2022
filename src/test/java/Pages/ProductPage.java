package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver driver = new ChromeDriver();

    public void addBagToCart(){
        driver.findElement(By.cssSelector("button#add-to-cart-sauce-labs-backpack")).click();

    }
    public void clickCartButton(){
        driver.findElement(By.cssSelector("div#shopping_cart_container > .shopping_cart_link")).click();
    }
    WebElement robotFace = driver.findElement(By.cssSelector(".peek"));
    public void LogoIsDisplayed() {
        Assert.assertTrue(robotFace.isDisplayed());


    }
}



