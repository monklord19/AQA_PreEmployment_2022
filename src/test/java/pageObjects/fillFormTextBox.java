package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class fillFormTextBox {

    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    By fullName = By.id("userName");
    By email = By.id("userEmail");
    By currentAddress = By.id("currentAddress");
    By permanentAddress = By.id("permanentAddress");
    By clickSubmit = By.id("submit");

    public fillFormTextBox(WebDriver driver) {
        this.driver = driver;

    }
    public void fillFullName(){
        driver.findElement(fullName).sendKeys("I am testing");
    }
    public void fillEmail(){
        driver.findElement(email).sendKeys("test@testing.com");
    }
    public void fillCurrentAddress(){
        driver.findElement(currentAddress).sendKeys("Str. Testerului nr. 1");
    }
    public void fillPermanentAddress(){
        driver.findElement(permanentAddress).sendKeys("Str. Testerului nr. 1");
    }
    public void clickSubmitButton(){
        //wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
        //driver.findElement(clickSubmit).click();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("submit"))).click();
    }
    public void fillTextBoxAndClickSubmit() {
        driver.findElement(fullName).sendKeys("I am testing");
        driver.findElement(email).sendKeys("test@testing.com");
        driver.findElement(currentAddress).sendKeys("Str. Testerului nr. 1");
        driver.findElement(permanentAddress).sendKeys("Str. Testerului nr. 1");
        //driver.findElement(clickSubmit).click();
    }
}
