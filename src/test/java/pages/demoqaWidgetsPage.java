package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class demoqaWidgetsPage {
    static WebDriver driver;
    @FindBy(css = "#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(1) > div > ul > #item-2")
    private static WebElement datePickerItem;
    public demoqaWidgetsPage(WebDriver driverWeb) {
        this.driver = driverWeb;
        PageFactory.initElements(driver, this);
    }

    public static void clickDatePicker() {
        datePickerItem.click();
    }
}
