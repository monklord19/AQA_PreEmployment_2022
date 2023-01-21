package Pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LumaPage {

        WebDriver driver;
        WebDriverWait wait;
        LumaPageObjects objects;
        public LumaPage(WebDriver driver){
            this.driver = driver;
            objects = new LumaPageObjects(driver);
        }

        public void hooverOver(){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Actions action = new Actions(driver);
            action.moveToElement(objects.getDropDown()).perform();

        }


        public void selectBags(){
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(objects.getBagsMenu()));
            objects.getBagsMenu().click();
        }

        public void scrollTo(){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",objects.getSavvyToteBag());
            Actions actions1 = new Actions(driver);
            actions1.moveToElement(objects.getSavvyToteBag()).perform();
        }

        public void clicksOn(){

            wait.until(ExpectedConditions.visibilityOf(objects.getAddToCart()));
            objects.getAddToCart().click();

        }

        public void onShoppingCart(){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",objects.getShoppingCart());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            objects.getShoppingCart().click();
            Assert.assertTrue(objects.getBagName().isDisplayed());
        }


    }

