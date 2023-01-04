package com.qascript.Utils;

import com.qascript.BaseClass;
import org.openqa.selenium.By;

public class BrowserUtils extends BaseClass {

    public static void clickElement(String element){
        driver.findElement(By.xpath(element)).click();
    }

    public static void enterText(String element,String text){
        driver.findElement(By.xpath(element)).sendKeys();
    }
}
