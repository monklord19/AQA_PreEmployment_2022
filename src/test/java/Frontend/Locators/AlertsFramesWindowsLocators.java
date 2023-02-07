package Frontend.Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AlertsFramesWindowsLocators {
    //ALERTS LOCATORS
    @FindBy(xpath = "(//*[name()='svg'][@stroke='currentColor'])[3]")
    @CacheLookup
    private WebElement AlertsFramesWindows;
    @FindBy(xpath = "//div[@class='element-list collapse show']//li[@id='item-1']")
    @CacheLookup
    private WebElement alertsCategory;
    @FindBy(id="promtButton")
    @CacheLookup
    private WebElement clickMePromptBtn;
    @FindBy(id="promptResult")
    @CacheLookup
    private WebElement promptResultMessage;

    public WebElement getAlertsFramesWindows() {
        return AlertsFramesWindows;
    }

    public WebElement getAlertsCategory() {
        return alertsCategory;
    }

    public WebElement getClickMePromptBtn() {
        return clickMePromptBtn;
    }

    public WebElement getPromptResultMessage() {
        return promptResultMessage;
    }
}
