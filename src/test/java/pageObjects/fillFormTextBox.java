package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class fillFormTextBox {
    WebDriver driver;
    WebDriverWait wait;

    By fullName = By.id("userName");
    By email = By.id("userEmail");
    By currentAddress = By.id("currentAddress");
    By permanentAddress = By.id("permanentAddress");
    By clickSubmit = By.id("submit");
    By scrollToLinks = By.id("item-5");


    public fillFormTextBox(WebDriver driver) {
        this.driver = driver;
    }

    public void fillFullName() {
        driver.findElement(fullName).sendKeys("I am testing");
    }

    public void fillEmail() {
        driver.findElement(email).sendKeys("test@testing.com");
    }

    public void fillCurrentAddress() {
        driver.findElement(currentAddress).sendKeys("Str. Testerului nr. 1");
    }

    public void fillPermanentAddress() {
        driver.findElement(permanentAddress).sendKeys("Str. Testerului nr. 1");
    }

    public void clickSubmitButton() {
        WebElement element = driver.findElement(scrollToLinks);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        driver.findElement(clickSubmit).click();
    }

    public void fillTextBox() {
        driver.findElement(fullName).sendKeys("I am testing");
        driver.findElement(email).sendKeys("test@testing.com");
        driver.findElement(currentAddress).sendKeys("Str. Testerului nr. 1");
        driver.findElement(permanentAddress).sendKeys("Str. Testerului nr. 1");
    }
}
