package pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ButtonsPage {
    WebDriver driver;
    @FindBy(css = "button#doubleClickBtn")
    private WebElement doubleClickMe;
    @FindBy(css = "p#doubleClickMessage")
    private WebElement doubleClickMessage;

    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void doubleClick() {
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickMe).perform();;
    }
    public void checkDoubleClickMessage(String message){
        Assert.assertEquals(message,doubleClickMessage.getText());
    }
}
