package selenium.Utils;

import selenium.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Properties;
import static java.lang.Long.parseLong;

public class BrowserUtils extends BaseClass {

    static Properties properties = PropertiesUtil.loadFrameworkProperties();

    public static void clickElement(String element) {

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
            WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(timeout));
            element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));

        } catch (Exception e){
            System.out.println("Element not found");
        }
        return element;
    }

}
