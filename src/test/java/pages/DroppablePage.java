package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DroppablePage {
    WebDriver driver;
    @FindBy(css = "div#draggable")
    private WebElement draggableElement;
    @FindBy(css = "#simpleDropContainer #droppable")
    private WebElement droppableElement;
    @FindBy(css = "#simpleDropContainer p")
    private WebElement droppedCheck;
    public DroppablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void dragElementToDropPoint() {
        Actions actions = new Actions(driver);
        actions.clickAndHold(draggableElement).moveToElement(droppableElement).release().build().perform();
    }
public void checkIfDropped(){
  Assert.assertEquals("Dropped!",droppedCheck.getText());
}

}
