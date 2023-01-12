package page.objects;

import Locators.MagnetoLocators;
import Locators.SpotifyLocators;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseClass;

import java.time.Duration;
import java.util.List;

public class MagnetoFlow extends BaseClass {

    WebDriver driver;
    WebDriverWait wait;
    MagnetoLocators magnetoLocators;
    public MagnetoFlow(WebDriver driver){
        this.driver = driver;
        magnetoLocators = new MagnetoLocators(driver);
    }

        public void hooverOver(WebElement list, final String value) {
            List<WebElement> options = list.findElements(By.xpath("//*[@id=\"ui-id-2\"]/li[4]/ul/li[1]"));

            for (WebElement option : options) {
                if (value.equals(option.getText())) {
                    option.click();
                    break;
                }
            }
        }

    public void hooverOver(){
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Actions action = new Actions(driver);
        action.moveToElement(magnetoLocators.getDropDown()).perform();

    }


    public void selectBags(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(magnetoLocators.getBags()));
        magnetoLocators.getBags().click();
    }

    public void scrollTo(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",magnetoLocators.getToteBag());
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(magnetoLocators.getToteBag()).perform();
    }

    public void clicksOn(){

        wait.until(ExpectedConditions.visibilityOf(magnetoLocators.getAddToCart()));
        magnetoLocators.getAddToCart().click();

    }

    public void onShoppingCart(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",magnetoLocators.getShoppingCart());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        magnetoLocators.getShoppingCart().click();
        Assert.assertTrue(magnetoLocators.getMessage().isDisplayed());
    }


}
