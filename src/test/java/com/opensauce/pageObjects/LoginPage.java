package com.opensauce.pageObjects;

import com.qascript.BaseClass;
import com.qascript.Utils.BrowserUtils;
import org.openqa.selenium.By;

public class LoginPage extends BaseClass {

    private static String txtUsername = "//*[@id=\"user-name\"]";
    private static String txtPassword = "//*[@id=\"password\"]";
    private static String txtLogin = "//*[@id=\"login-button\"]";

    public static void enterUsername(String username) {
        driver.findElement(By.xpath(txtUsername)).sendKeys(username);

    }

    public static void enterPassword(String password) {
        driver.findElement(By.xpath(txtPassword)).sendKeys(password);

    }

    public static void clickLogin() {
        BrowserUtils.clickElement(txtLogin);

    }
}
