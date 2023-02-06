package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TextBox {
    WebDriver driver;
    WebDriverWait wait;

    TextBoxLocators textBoxLocators;

    public TextBox(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
        textBoxLocators = new TextBoxLocators(driver);
    }

    public void clickElements()
    {
        textBoxLocators.getElements().click();

    }
    public void clickTextBox(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(textBoxLocators.getTextBox()));
        textBoxLocators.getTextBox().click();
    }

    public void enterFullName(String fullname){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(textBoxLocators.getFullName()));
        textBoxLocators.getFullName().clear();
        textBoxLocators.getFullName().sendKeys(fullname, Keys.RETURN);

    }
    public void enterEmail(String email){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(textBoxLocators.getEmail()));
        textBoxLocators.getEmail().clear();
        textBoxLocators.getEmail().sendKeys(email, Keys.RETURN);

    }
    public void enterCurrentAddress(String currentaddress){
        wait.until(ExpectedConditions.visibilityOf(textBoxLocators.getCurrentAddress()));
        textBoxLocators.getCurrentAddress().clear();
        textBoxLocators.getCurrentAddress().sendKeys(currentaddress, Keys.RETURN);

    }

    public void enterPermanentAddress(String permanentaddress){
        wait.until(ExpectedConditions.visibilityOf(textBoxLocators.getPermanentAddress()));
        textBoxLocators.getPermanentAddress().clear();
        textBoxLocators.getPermanentAddress().sendKeys(permanentaddress, Keys.RETURN);

    }

    public void clickSubmit(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By submitButtonLocator = By.xpath("//*[@id=\"submit\"]");
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
        submitButton.click();
    }

    public void checkText(String text){
        wait.until(ExpectedConditions.visibilityOf(textBoxLocators.getText()));
        textBoxLocators.getText().clear();
        textBoxLocators.getText().sendKeys(text, Keys.RETURN);

    }
}
