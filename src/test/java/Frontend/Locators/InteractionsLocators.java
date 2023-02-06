package Frontend.Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class InteractionsLocators {

    //RESIZABLE SECTION
    @FindBy(xpath = "(//*[name()='svg'][@stroke='currentColor'])[5]")
    @CacheLookup
    private WebElement interactionsSection;
    @FindBy(xpath = "//div[@class='element-list collapse show']//li[@id='item-2']")
    @CacheLookup
    private WebElement resizableCategory;
    @FindBy(xpath = "//div[@id='resizable']/span[@class='react-resizable-handle react-resizable-handle-se']")
    @CacheLookup
    private WebElement boxCorner;

    public WebElement getInteractionsSection() {
        return interactionsSection;
    }

    public WebElement getResizableCategory() {
        return resizableCategory;
    }

    public WebElement getBoxCorner() {
        return boxCorner;
    }

    //DROPPABLE SECTION
    @FindBy(xpath = "//div[@class='element-list collapse show']//li[@id='item-3']")
    @CacheLookup
    private WebElement droppableSection;
    @FindBy(id = "draggable")
    @CacheLookup
    private WebElement drag;
    @FindBy(id = "droppable")
    @CacheLookup
    private WebElement drop;

    public WebElement getDroppableSection() {
        return droppableSection;
    }

    public WebElement getDrag() {
        return drag;
    }

    public WebElement getDrop() {
        return drop;
    }
}
