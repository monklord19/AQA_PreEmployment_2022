package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class InteractionsPage extends Page{
    public InteractionsPage(WebDriver driver) {
        super(driver);
    }
    Actions action = new Actions(driver);

    By droppableElem = By.xpath("//span[text()='Droppable']");
    By dragBoxElem = By.cssSelector("#draggable");
    By dropBoxElem = By.cssSelector("#droppable");
    By droppedMessageElem = By.xpath("//p[text()='Dropped!']");


    private WebElement droppable() {
        return driver.findElement(droppableElem);
    }
    private WebElement dragBox() {
        return driver.findElement(dragBoxElem);
    }
    private WebElement dropBox() {
        return driver.findElement(dropBoxElem);
    }
    private WebElement droppedMessage() {
        return driver.findElement(droppedMessageElem);
    }



    public void clickOnDroppable() {
        droppable().click();
    }
    public void dragAndDrop() {
        action.dragAndDrop(dragBox(),dropBox()).build().perform();
    }
    public String getDroppedMessage() {
        return droppedMessage().getText();
    }

}
