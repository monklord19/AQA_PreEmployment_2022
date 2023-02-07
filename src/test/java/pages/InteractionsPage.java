package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InteractionsPage {
    WebDriver driver;

    public InteractionsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //Droppable
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[5]/div/div[2]")
    private WebElement interactionsBtn;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[5]/div/ul/li[4]")
    private WebElement droppableBtn;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div[2]/p")
    private WebElement droppedText;
    @FindBy(id = "draggable")
    private WebElement draggableBtn;
    @FindBy(id = "droppable")
    private WebElement droppableElement;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[5]/div/ul/li[5]")
    private WebElement Dragabble;

    @FindBy(id = "dragBox")
    private WebElement dragBox;

    public void wait(WebElement element){
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void goToInteractions(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");

        wait(interactionsBtn);
        interactionsBtn.click();
    }

    public void goToDroppable(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");

        wait(droppableBtn);
        droppableBtn.click();
    }

    public void verifyDroppedText(String Message){
        Assert.assertEquals(droppedText.getText(), Message);
    }

    public void performDrop(){
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggableBtn, droppableElement).perform();
    }

    public void goToDragabble(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");

        wait(Dragabble);
        Dragabble.click();
    }

    public void dragElement(){
        Actions actions = new Actions(driver);
        Point initialLocation = dragBox.getLocation();
        actions.clickAndHold(dragBox).moveByOffset(200, 200).release().perform();
        Point finalLocation = dragBox.getLocation();

        Assert.assertNotEquals(initialLocation, finalLocation);
        Assert.assertEquals(finalLocation.x, initialLocation.x + 200);
        Assert.assertEquals(finalLocation.y, initialLocation.y + 200);
    }
}
