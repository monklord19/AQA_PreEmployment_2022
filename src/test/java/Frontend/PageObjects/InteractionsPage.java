package Frontend.PageObjects;

import Frontend.Locators.InteractionsLocators;
import Frontend.Steps.TestBase;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InteractionsPage extends TestBase {
    private final InteractionsLocators interactionsLocators = PageFactory.initElements(driver, InteractionsLocators.class);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Actions actions = new Actions(driver);
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

    //RESIZABLE SECTION METHODS
    public void clickOnInteractionsSection() {
        WebElement interactionsSection = interactionsLocators.getInteractionsSection();
        wait.until(ExpectedConditions.visibilityOf(interactionsSection));
        actions.moveToElement(interactionsSection).click().build().perform();
    }

    public void clickOnResizableCategory() throws InterruptedException {
        WebElement resizableCategory = interactionsLocators.getResizableCategory();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", resizableCategory);
        resizableCategory.click();
        Thread.sleep(2000);
    }

    public void resizeTheBoxWithoutRestrictions() throws InterruptedException {
        WebElement boxCorner = interactionsLocators.getBoxCorner();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", boxCorner);
        Thread.sleep(2000);
        //finding initial x and y offsets
        int xOffsetBefore=boxCorner.getLocation().getX();
        int yOffsetBefore=boxCorner.getLocation().getY();
        System.out.println("Initial xOffset: "+xOffsetBefore+""+"Initial yOffset: "+yOffsetBefore);
        Actions resize=actions.clickAndHold(boxCorner).moveByOffset(488,784).release();
        resize.build().perform();
//        actions.moveToElement(boxCorner).click().build().perform();
//        actions.dragAndDropBy(boxCorner, 514, 599).perform();
    }

    public void iClickOnDroppableSection() throws InterruptedException {
        WebElement droppableSection = interactionsLocators.getDroppableSection();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", droppableSection);
        droppableSection.click();
        Thread.sleep(1000);
    }

    public void performDragAndDropAction() {
        WebElement drag = interactionsLocators.getDrag();
        WebElement drop = interactionsLocators.getDrop();
        actions.dragAndDrop(drag, drop).perform();
    }

    public void assertDragIsMovedToDrop() {
        WebElement drop = interactionsLocators.getDrop();
        String dropMessage = "Dropped!";
        Assert.assertEquals(dropMessage, drop.getText());
    }

}
