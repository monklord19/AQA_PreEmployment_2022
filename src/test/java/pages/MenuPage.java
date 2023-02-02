package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {
    WebDriver driver;
    @FindBy(css = "ul#nav > li:nth-of-type(2) > a")
    private WebElement mainItem2link;
    @FindBy(css = "ul#nav  ul > li:nth-of-type(3) > a")
    private WebElement subSubListLink;
    @FindBy(css = "ul#nav  ul  ul > li:nth-of-type(2) > a")
    private WebElement subSubItem2Link;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void hoverOverMainItem2() {
        Actions actions = new Actions(driver);
        actions.moveToElement(mainItem2link).build().perform();

    }

    public void hoverToSubSubList() {
        Actions actions = new Actions(driver);
        actions.moveToElement(subSubListLink).build().perform();
    }
    public void checkIfSubSubItemIsDisplayed(){
        Assert.assertTrue(subSubItem2Link.isDisplayed());
    }
}
