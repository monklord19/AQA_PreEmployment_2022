package com.DemoQA.Utils;

import com.DemoQA.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;


public class BrowserUtils extends BaseClass {

    static Properties properties = PropertiesUtil.loadFrameworkProperties();

    public static void clickElement(String element) {

        WebElement e = driver.findElement(By.xpath(element));
        FindAndWaitForElement(element).click();
    }

    public static void enterText(String element, String text) {
        FindAndWaitForElement(element).clear();
        FindAndWaitForElement(element).sendKeys(text);
    }

    public static void hooverElement(String element){
        WebElement webElement = FindAndWaitForElement(element);

        Actions actions = new Actions(driver);
        actions.moveToElement(webElement);
    }

    public static void validateValue(String element, String expectedValue, String attributeType){
        String actualValue = FindAndWaitForElement(element).getAttribute(attributeType);
        Assert.assertTrue("Expected Value: " + expectedValue + " is not matching with Actual Text:" + actualValue,
                expectedValue.equals(actualValue));

    }
    public static WebElement FindAndWaitForElement(String xpath) {
        String timeout = properties.getProperty("timeout.maximum");
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
        } catch (Exception e) {
            System.out.println("Element not found");
        }
        return element;
    }

    public static void validateText(String element, String expectedText) {

        String actualText = FindAndWaitForElement(element).getText();
        Assert.assertTrue("Expected Text: " + expectedText + " is not matching with Actual Text:" + actualText,
                expectedText.equals(actualText));
    }


    public static void validateSubmitButton(String element, String expectedText) {

        String actualText = FindAndWaitForElement(element).getText();
        Assert.assertTrue("Expected Text: " + expectedText + " is not matching with Actual Text:" + actualText,
                expectedText.equals(actualText));
    }


    //Elements - Text Box
    public static void validateName(String element, String expectedFullName) {
        String actualFullName = FindAndWaitForElement(element).getText();
        Assert.assertTrue("Expected Full Name: " + expectedFullName + " is not matching with Actual Full Name:" + expectedFullName,
                expectedFullName.equals(actualFullName));
    }

    public static void validateEmail(String element, String expectedEmail) {
        String actualEmail = FindAndWaitForElement(element).getText();
        Assert.assertTrue("Expected Email: " + expectedEmail + " is not matching with Actual Email:" + expectedEmail,
                expectedEmail.equals(actualEmail));
    }

    public static void validateCurrentAddress(String element, String expectedCurrentAddress) {
        String actualCurrentAddress = FindAndWaitForElement(element).getText();
        Assert.assertTrue("Expected Current Address: " + expectedCurrentAddress + " is not matching with Actual Current Address:" + expectedCurrentAddress,
                expectedCurrentAddress.equals(actualCurrentAddress));
    }

    public static void validatePermanentAddress(String element, String expectedPermanentAddress) {
        String actualPermanentAddress = FindAndWaitForElement(element).getText();
        Assert.assertTrue("Expected Permanent Address: " + expectedPermanentAddress + " is not matching with Actual Permanent Address:" + expectedPermanentAddress,
                expectedPermanentAddress.equals(actualPermanentAddress));
    }

    public static void validateResponseScenarioOutline(String element){
        WebElement actualResponseScenarioOutline = FindAndWaitForElement(element);
    }


    //Elements - Check Box
    public static void validateTextCheckBox(String element, String expectedTextCheckBox) {
        String actualTextCheckBox = FindAndWaitForElement(element).getText();
        Assert.assertTrue("Expected Permanent Address: " + expectedTextCheckBox + " is not matching with Actual Permanent Address:" + expectedTextCheckBox,
                expectedTextCheckBox.equals(actualTextCheckBox));
    }


    // Elements - Links
    public static void validateTextMovedLink(String element, String expectedTextMovedLink) {
        String actualTextMovedLink = FindAndWaitForElement(element).getText();
        Assert.assertEquals("The Expected text is not matching with Actual text", actualTextMovedLink, "Link has responded with staus 301 and status text Moved Permanently");
    }





}