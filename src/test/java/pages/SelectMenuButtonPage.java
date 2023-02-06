package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.util.List;

public class SelectMenuButtonPage {
    WebDriver driver;
    @FindBy(css = "div#withOptGroup .css-1g6gooi > div > input")
    private WebElement selectValueField;
    @FindBy(css = "div#selectOne .css-1g6gooi > div > input")
    private WebElement selectOneField;
    @FindBy(id = "oldSelectMenu")
    private WebElement oldStyleSelectMenu;
    @FindBy(css = "div:nth-of-type(7) .css-1hwfws3")
    private WebElement multiselectDropdown;
    @FindBy(css = "div:nth-of-type(7) .css-1hwfws3 > .css-1g6gooi > div > input")
    private WebElement multiselectField;
    @FindBy(id = "cars")
    private WebElement standardMultiSelect;
    @FindBy(id = "withOptGroup")
    private WebElement selectValueAssert;
    @FindBy(css = "div:nth-of-type(6) > .col-md-6.col-sm-12 > div")
    private WebElement oldStyleMenuAssert;


    public SelectMenuButtonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectValue(String value) throws InterruptedException {
        Thread.sleep(1500);
        selectValueField.sendKeys(value);
        selectValueField.sendKeys(Keys.ENTER);
    }

    public void selectOneGender() {
        selectOneField.sendKeys("Dr.");
        selectOneField.sendKeys(Keys.ENTER);
    }

    public void pickSingleColor(String sglColor) throws InterruptedException {
        Select objSelect = new Select(oldStyleSelectMenu);
        objSelect.selectByVisibleText(sglColor);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(250,250)");
    }

    public void selectTheColors(String color1, String color2) {
        multiselectDropdown.click();
        multiselectField.sendKeys(color1);
        multiselectField.sendKeys(Keys.ENTER);
        multiselectField.sendKeys(color2);
        multiselectField.sendKeys(Keys.ENTER);
    }

    public void pickSingleCar(String car) {
        Select objSelect = new Select(standardMultiSelect);
        objSelect.selectByVisibleText(car);
    }

    public void checkValue(String value) {

        Assert.assertEquals(value, "Group 2, option 2");

    }

    public void checkColorMenu(String color) {
        Select objSelect = new Select(oldStyleSelectMenu);
        Assert.assertEquals(color, objSelect.getFirstSelectedOption().getText());
    }
}
