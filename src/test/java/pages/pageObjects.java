package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageObjects {

    WebDriver driver;
    By elementsButton = By.className("card-up");
    By radioButton = By.id("item-2");
    By yesOption = By.className("custom-control-label");
    By yesTextAppears = By.className("mt-3");

    public pageObjects(WebDriver driver) {
        this.driver = driver;
        if (!driver.getTitle().equals("ToolsQA")) {
            throw new IllegalStateException("This is not demoqa page. The current page is " + driver.getCurrentUrl());
        }
    }

    public void userClicksOnElementsButton() {
        driver.findElement(elementsButton).click();
    }

    public void userClicksOnRadioButton() {
        driver.findElement(radioButton).click();
    }

    public void userCLicksOnYesOption() {
        driver.findElement(yesOption).click();
    }

    public void youHaveSelectedYesTextAppears() {
        WebElement text = driver.findElement(yesTextAppears);
        String expectedText = "You have selected Yes";
        Assert.assertEquals(expectedText, text.getText());
    }

}
