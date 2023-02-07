package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pages.demoqaElementsPage.yesRadioButton;

public class demoqaWidgetsPage {
    static WebDriver driver;
    @FindBy(css = "#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(1) > div > ul > #item-2")
    private static WebElement datePickerItem;

    @FindBy (xpath = "//*[@id=\"datePickerMonthYear\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[4]")
    private static WebElement date1February;
    public demoqaWidgetsPage(WebDriver driverWeb) {
        this.driver = driverWeb;
        PageFactory.initElements(driver, this);
    }

    public static void clickDatePicker() {
       // datePickerItem.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", yesRadioButton);
    }

    public static void clickDate1February() {
        date1February.click();
    }
}

