package UITests.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonPage {
    WebDriver driver;
    public static final String title = "Radio Button";
    public static final By yesRadioButton = By.xpath("//label[@for='yesRadio']");
    public static final By impressiveRadioButton = By.xpath("//label[@for='impressiveRadio']");
    public static final By header = By.className("main-header");
    public static final By outputTextElement = By.className("mt-3");
    public static final String outputText = "You have selected ";

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }


    public void clickRadioButton(String checkboxLabel) {
        if(checkboxLabel.equals("Yes")) getElement(yesRadioButton).click();
        if(checkboxLabel.equals("Impressive")) getElement(impressiveRadioButton).click();
    }

    public boolean isHeaderDisplayed() {
        return getElement(header).getText().equals(title);
    }

    public boolean isOutputTextDisplayed(String checkBoxLabel) {
        return getElement(outputTextElement).getText().equals(outputText + checkBoxLabel);
    }
}
