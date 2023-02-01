package selenium.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.BaseClass;
import org.junit.Assert;

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



    public static WebElement FindAndWaitForElement(String xpath) {
        String timeout = properties.getProperty("timeout.maximum");
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));


        } catch (Exception e){
            System.out.println("Element not found");
        }
        return element;
    }

    public static void validateText(String element, String expectedText){

        String actualText = FindAndWaitForElement(element).getText();
        Assert.assertTrue("Expected Text: " + expectedText + "is not matching with Actual Text:" +actualText,
                expectedText.equals(actualText));
    }
}
