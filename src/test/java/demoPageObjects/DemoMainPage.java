package demoPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DemoMainPage {
    WebDriver driver;
    By meniuItems = By.xpath("//div[@class='category-cards']");
    By meniuButton = By.xpath("//div[@class='card mt-4 top-card']");

    public DemoMainPage(WebDriver driver){
        this.driver = driver;
    }
//    public void clickElementButton(String elementName){
//        WebElement meniuItemsElement = driver.findElement(meniuItems);
//        List<WebElement>elementList = meniuItemsElement.findElements(meniuButton);
//        for (WebElement eMeniu:elementList){
////            if(eMeniu.getText().){
////                WebElement meniuButtonElement = eMeniu.findElement(meniuButton);
////                meniuButtonElement.click();
//            }
//        }

//    }
}

