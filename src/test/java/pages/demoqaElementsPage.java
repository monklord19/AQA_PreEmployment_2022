package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class demoqaElementsPage {
    static WebDriver driver;
    @FindBy(css = "#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(1) > div > ul > #item-0")
    private static WebElement textBoxButton;

    @FindBy(id = "submit")
    private static WebElement submitButton;

    @FindBy(css = "#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(1) > div > ul > #item-2")
    private static WebElement radioButtonItem;

    @FindBy(id = "yesRadio")
    public static WebElement yesRadioButton;
    @FindBy(id = "impressiveRadio")
    public static WebElement impressiveRadioButton;
    @FindBy(id = "noRadio")
    public static WebElement noRadioButton;

    @FindBy(css = "#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(1) > div > ul > #item-1")
    private static WebElement checkBoxItem;

    @FindBy(css = "#tree-node > div > button.rct-option.rct-option-expand-all")
    public static WebElement expandAllButton;

    @FindBy(xpath = "//label[contains(@for,'tree-node-home')]")
    public static WebElement homeCheckBox;

    @FindBy(css = "#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(1) > div > ul > #item-4")
    private static WebElement buttonsItem;
    @FindBy(css = "#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(2) > div:nth-child(3) > button")
    private static WebElement clickMeButton;

    @FindBy(id = "rightClickBtn")
    private static WebElement rightClickButton;

    @FindBy(css = "#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(1) > div > ul > #item-5")
    private static WebElement linksItem;

    @FindBy(id = "dynamicLink")
    private static WebElement dynamicLink;

    public demoqaElementsPage(WebDriver driverWeb) {
        this.driver = driverWeb;
        PageFactory.initElements(driver, this);
    }

    public static void clickTextBoxButton() {
        textBoxButton.click();
    }

    public static void clickSubmitButton() {
        submitButton.click();
    }

    public static void clickRadioButtonItem() {
        radioButtonItem.click();
    }

    public static void clickYesRadioButton() {
// I used a JavaScript hack because the yesRadioButton.click() method did not work (I received an error saying that the element is not clickable): https://stackoverflow.com/questions/41541387/selenium-webdriver-click-on-radio-button-not-working
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", yesRadioButton);
    }

    public static void clickCheckBoxItem() {
        checkBoxItem.click();
    }

    public static void clickExpandAllButton() {
        expandAllButton.click();
    }

    public static void clickHomeCheckBox() {
        homeCheckBox.click();
    }

    public static void clickButtonsItem() {
        buttonsItem.click();
    }

    public static void clickClickMeButton() {
        clickMeButton.click();
    }
    public static void clickRightClickButton() {
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickButton).perform();
    }

    public static void clickLinksItem() {
        linksItem.click();
    }

    public static void clickDynamicLink() {
        dynamicLink.click();
    }
}
