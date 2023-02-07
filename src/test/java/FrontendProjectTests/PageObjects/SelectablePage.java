package FrontendProjectTests.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectablePage {
    private WebDriver driver;
    @FindBy(xpath = "//*[@id=\"row1\"]/li[1]")
    private  WebElement element1;
    @FindBy(xpath = "//*[@id=\"row1\"]/li[3]")
    private  WebElement element3;
    @FindBy(xpath = "//*[@id=\"row2\"]/li[2]")
    private  WebElement element5;
    @FindBy(xpath = "//*[@id=\"row3\"]/li[1]")
    private  WebElement element7;
    @FindBy(xpath = "//*[@id=\"row3\"]/li[3]")
    private  WebElement element9;
    @FindBy(id = "demo-tab-grid")
    private WebElement demoGrid;

    public SelectablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement getElement1() {
        return element1;
    }

    public WebElement getElement3() {
        return element3;
    }

    public WebElement getElement5() {
        return element5;
    }

    public WebElement getElement7() {
        return element7;
    }

    public WebElement getElement9() {
        return element9;
    }

    public WebElement getDemoGrid() {
        return demoGrid;
    }
}
