package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Demoqa {
    WebDriver driver;
    WebDriverWait wait;
    By clickElementsButton = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div/div[1]");
    By assertExcelFileText = By.className("text-success");
    By clickTextBoxButton = By.id("item-0");
    By clickRadioButtonButton = By.id("item-2");
    By clickYesRadioButton = By.xpath("//*[text()='Yes']");
    By scroll = By.id("item-6");
    By clickWebTables = By.id("item-3");
    By clickEditCierra = By.id("edit-record-1");
    By clickButtons = By.id("item-4");
    By rightClick = By.id("rightClickBtn");
    By assertRightClick = By.id("rightClickMessage");
    By clickLinks = By.id("item-5");
    By clickHome7ndZl = By.id("dynamicLink");
    By clickWidgets = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[4]/span");
    By scrollLower = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[6]/span/div/div[2]");
    By clickdatePickerMonthYearInput = By.id("datePickerMonthYearInput");
    By clickNextMonth = By.xpath("//*[@id=\"datePickerMonthYear\"]/div[2]/div[2]/div/div/button[2]");
    By clickSix = By.xpath("//*[@id=\"datePickerMonthYear\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[2]");
    By clickMenuButton = By.xpath("//*[text()='Menu']");
    By hoverOnMainItemTwo = By.xpath("//*[@id=\"nav\"]/li[2]/a");
    By hoverOnSubSubList = By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[3]/a");
    By hoverOnSubSubItemOne = By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[3]/ul/li[1]/a");
    By assertSubSubItem1 = By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[3]/ul/li[1]/a");
    By clickSliderButton = By.xpath("//*[text()='Slider']");
    By slideTo100 = By.xpath("//*[@id=\"sliderContainer\"]/div[1]/span/input");
    By assertSliderTo100 = By.xpath("//*[text()='100']");
    By newWindowButton = By.id("messageWindowButton");

    public Demoqa(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElements() {
        driver.findElement(clickElementsButton).click();
    }

    public void assertExcelFileText() {
        String youHaveSelected = driver.findElement(assertExcelFileText).getText();
        String assertExcelFileText = "excelFile";
        Assert.assertEquals(youHaveSelected, assertExcelFileText);
    }

    public void clickTextBox() {
        driver.findElement(clickTextBoxButton).click();
    }


    public void clickRadioButton() {
        WebElement element = driver.findElement(scroll);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

        WebElement Radio = driver.findElement(clickRadioButtonButton);
        actions.moveToElement(Radio);
        Radio.click();
    }

    public void yesRadioButton() {
        driver.findElement(clickYesRadioButton).click();
    }

    public void clickWebTablesButton() {
        WebElement element = driver.findElement(scroll);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        driver.findElement(clickWebTables).click();
    }

    public void clickEditCierraInfo() {
        driver.findElement(clickEditCierra).click();
    }

    public void clickButtonsButton() {
        WebElement element = driver.findElement(scroll);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        driver.findElement(clickButtons).click();
    }

    public void rightClickSecondButton() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        WebElement btnElement = driver.findElement(rightClick);
        wait.until(ExpectedConditions.visibilityOf(btnElement));
        actions.contextClick(btnElement).perform();
    }

    public void assertTheRightClickMessage() {
        String youHaveSelected = driver.findElement(assertRightClick).getText();
        String assertRightClick = "You have done a right click";
        Assert.assertEquals(youHaveSelected, assertRightClick);
        System.out.println("Assert correct");
    }

    //6th scenario
    public void clickLinksButton() {
        WebElement element = driver.findElement(scroll);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        driver.findElement(clickLinks).click();
    }

    public void click2ndLink() {
        driver.findElement(clickHome7ndZl).click();
    }

    //7th scenario
    public void clickdatePickerMonthYearInput() {
        driver.findElement(clickdatePickerMonthYearInput).click();
    }

    public void nextMonth() {
        driver.findElement(clickNextMonth).click();
    }

    public void clickSix() {
        driver.findElement(clickSix).click();
    }

    public void clickMenu() {
        WebElement clickMenuTeRog = driver.findElement(clickMenuButton);
        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].click()", clickMenuTeRog);
    }

    public void hoverOverSubSubItemOne() {
        WebElement element = driver.findElement(hoverOnMainItemTwo);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public void hoverSubSubList() {
        WebElement element = driver.findElement(hoverOnSubSubList);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

        WebElement hoverSubSubItem1 = driver.findElement(hoverOnSubSubItemOne);
        actions.moveToElement(hoverSubSubItem1);
        actions.perform();
    }

    public void assertSubSubItemOne() {
        String expectedMessage = driver.findElement(assertSubSubItem1).getText();
        String assertRightClick = "Sub Sub Item 1";
        Assert.assertEquals(expectedMessage, assertRightClick);
    }

    //9th scenario
    public void clickSlider() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(clickSliderButton)).click();
    }

    public void moveSlider() {
        WebElement e = driver.findElement(slideTo100);
        Actions move = new Actions(driver);
        move.moveToElement(e).clickAndHold().moveByOffset(225, 0).release().perform();
    }

    public void assertSlider() {
        String expectedMessage = driver.findElement(assertSliderTo100).getText();
        String assertSliderValue = "100";
        Assert.assertEquals(expectedMessage, assertSliderValue);
    }

    //10th scenario
    public void clickOnWidgets() {
        WebElement element = driver.findElement(scrollLower);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        driver.findElement(clickWidgets).click();
    }

    public void switchToNewWindowAndCloseIt() {
        String parentHandle = driver.getWindowHandle();
        driver.findElement(newWindowButton).click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.close();
    }
}
