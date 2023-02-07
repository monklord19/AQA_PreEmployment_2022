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

    public static void doubleClickElement(String element) {

        WebElement e = FindAndWaitForElement(element);
        Actions action = new Actions(driver);

        FindAndWaitForElement(element);
        action.doubleClick().perform();
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


    public static void validateTextCheckBox(String element, String expectedTextCheckBox) {
        String actualTextCheckBox = FindAndWaitForElement(element).getText();
        Assert.assertTrue("Expected Permanent Address: " + expectedTextCheckBox + " is not matching with Actual Permanent Address:" + expectedTextCheckBox,
                expectedTextCheckBox.equals(actualTextCheckBox));
    }


    public static void validateTextMovedLink(String element, String expectedTextMovedLink) {
        String actualTextMovedLink = FindAndWaitForElement(element).getText();
        Assert.assertEquals("The Expected text is not matching with Actual text", actualTextMovedLink, "Link has responded with staus 301 and status text Moved Permanently");
    }

    public static void getText(String element) {
        String actualText = FindAndWaitForElement(element).getText();
        if (actualText.contains("Name")) {
            System.out.println("Full Name, Email, Current Address and Permanent Address was successfully submitted.");
        } else {
            System.out.println("Full Name, Email, Current Address and Permanent Address was unsuccessfully submitted.");
        }
    }

    public static void getTextAccordian(String element) {
        String accordianText = FindAndWaitForElement(element).getText();
        if (accordianText.contains("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout")) {
            System.out.println("The answer to the accordian <Why do we use it?> is visible on the page.");
        } else {
            System.out.println("The answer to the accordian <Why do we use it?> is not is visible on the page.");
        }
    }

    public static void getEmptyText(String element) {
        String emptyText = FindAndWaitForElement(element).getText();
        if (element.isEmpty() || emptyText.equals("")) {
            System.out.println("The record is deleted");
        }
        else {
            System.out.println("The record is not deleted.");
        }
    }

    public static void getTextOriginTab(String element) {
        String originText = FindAndWaitForElement(element).getText();
        if (originText.contains("Contrary to popular belief, Lorem Ipsum is not simply random text")) {
            System.out.println("Origin Tab is clicked.");
        } else {
            System.out.println("Origin Tab is not clicked");
        }
    }

    public static void getEmptyValue(String element) {
        String emptyText = FindAndWaitForElement(element).getAttribute("value");
        if (emptyText.isEmpty()) {
            System.out.println("The record is deleted");
        }
        else {
            System.out.println("The record is not deleted.");
        }

    }

}