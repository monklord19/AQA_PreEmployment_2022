package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WidgetsPage extends Page{
    public WidgetsPage(WebDriver driver) {
        super(driver);
    }
    Actions action = new Actions(driver);

    By bookStoreElem = By.xpath("//div[text()='Book Store Application']");
    By selectMenuElem = By.xpath("//span[text()='Select Menu']");
    By selectTitleElem = By.cssSelector("#selectOne");
    By mrsOptionElem = By.cssSelector("#react-select-3-option-0-2");
    By selectedOptionElem = By.xpath("//div[text()='Mrs.']");
    By progressBarElem = By.xpath("//span[text()='Progress Bar']");
    By startBtnElem = By.cssSelector("#startStopButton");
    By progressElem = By.cssSelector("#progressBar");
    By resetBtnElem = By.cssSelector("#resetButton");


    private WebElement bookStore() {
        return driver.findElement(bookStoreElem);
    }
    private WebElement selectMenu() {
        return driver.findElement(selectMenuElem);
    }
    private WebElement selectTitle() {
        return driver.findElement(selectTitleElem);
    }
    private WebElement mrsOption() {
        return driver.findElement(mrsOptionElem);
    }
    private WebElement selectedOption() {
        return driver.findElement(selectedOptionElem);
    }
    private WebElement progressBar() {
        return driver.findElement(progressBarElem);
    }
    private WebElement startBtn() {
        return driver.findElement(startBtnElem);
    }
    private WebElement progress() {
        return driver.findElement(progressElem);
    }
    private WebElement resetBtn() {
        return driver.findElement(resetBtnElem);
    }

    public void moveToBookStore() {
        action.moveToElement(bookStore()).perform();
    }
    public void clickOnSelectMenu() {
        selectMenu().click();
    }
    public void clickOnSelectTitleElem() {
        selectTitle().click();
    }
    public void clickOnMrsOption() {
        mrsOption().click();
    }
    public String getSelectedOptionText() {
        return selectedOption().getText();
    }
    public void clickOnProgressBar() {
        progressBar().click();
    }
    public void clickOnStartBtnElem() {
        startBtn().click();
    }
    public void moveToProgress() {
        action.moveToElement(progress()).perform();
    }
    public boolean resetBtnIsDisplayed() {
        return resetBtn().isDisplayed();
    }
}
