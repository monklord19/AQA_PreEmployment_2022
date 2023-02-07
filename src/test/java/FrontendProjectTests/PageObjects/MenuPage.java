package FrontendProjectTests.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {

    @FindBy(xpath = "//*[contains(@class, 'element-group')][3]")
    private WebElement alertsFrameWindowsButton;
    @FindBy(xpath = "//*[contains(@class, 'element-group')][4]")
    private WebElement widgetsButton;
    @FindBy(xpath = "//*[contains(@class, 'element-group')][5]")
    private WebElement interactionsButton;
    @FindBy(xpath = "//*[@id=\"item-0\"][1]")
    private WebElement textBoxButton;
    @FindBy(xpath = "//*[@id=\"item-1\"][1]")
    private WebElement checkBoxButton;
    @FindBy(xpath = "//*[@id=\"item-3\"][1]")
    private WebElement webTablesButton;
    @FindBy(xpath = "//*[@id=\"item-5\"][1]")
    private WebElement linksButton;
    @FindBy(xpath = "//*[@id=\"item-7\"][1]")
    private WebElement uploadAndDownloadButton;
    @FindBy(xpath = "(//*[@id=\"item-1\"])[2]")
    private WebElement alertsButton;
    @FindBy(xpath = "(//*[@id=\"item-1\"])[3]")
    private WebElement autoComplete;
    @FindBy(xpath = "(//*[@id=\"item-3\"])[3]")
    private WebElement sliderButton;
    @FindBy(xpath = "(//*[@id=\"item-1\"])[4]")
    private WebElement selectableButton;
    @FindBy(xpath = "(//*[@id=\"item-3\"])[4]")
    private WebElement droppableButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]")
    private WebElement elementsButton;
    public static WebDriver driver;
    public MenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement getElementsButton() {
        return elementsButton;
    }


    public WebElement getTextBoxButton() {
        return textBoxButton;
    }

    public WebElement getCheckBoxButton() {
        return checkBoxButton;
    }

    public WebElement getWebTablesButton() {
        return webTablesButton;
    }

    public WebElement getLinksButton() {
        return linksButton;
    }

    public WebElement getUploadAndDownloadButton() {
        return uploadAndDownloadButton;
    }

    public WebElement getAlertsFrameWindowsButton() {
        return alertsFrameWindowsButton;
    }

    public WebElement getAlertsButton() {
        return alertsButton;
    }

    public WebElement getWidgetsButton() {
        return widgetsButton;
    }

    public WebElement getInteractionsButton() {
        return interactionsButton;
    }
    public WebElement getAutoComplete() {
        return autoComplete;
    }

    public WebElement getSliderButton() {
        return sliderButton;
    }

    public WebElement getSelectableButton() {
        return selectableButton;
    }

    public WebElement getDroppableButton() {
        return droppableButton;
    }
}

