package FrontendProjectTests.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {
    private WebDriver driver;
    @FindBy( id = "confirmResult")
    private WebElement confirmResult;
    @FindBy( id = "promptResult")
    private  WebElement promptResult;
    @FindBy(id = "promtButton")
    private WebElement promtButton;
    @FindBy(id = "confirmButton")
    private WebElement confirmButton;
    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getConfirmResult() {
        return confirmResult;
    }

    public WebElement getPromptResult() {
        return promptResult;
    }

    public WebElement getPromtButton() {
        return promtButton;
    }

    public WebElement getConfirmButton() {
        return confirmButton;
    }
}
