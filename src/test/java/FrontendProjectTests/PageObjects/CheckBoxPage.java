package FrontendProjectTests.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPage {
    public static WebDriver driver;
    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/span/button")
    private WebElement expandHome;
    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button")
    private WebElement expandDocuments;
    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/span/button")
    private WebElement expandOffice;
    @FindBy(id = "result")
    private WebElement result;
    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getExpandHome() {
        return expandHome;
    }

    public WebElement getExpandDocuments() {
        return expandDocuments;
    }

    public WebElement getExpandOffice() {
        return expandOffice;
    }

    public WebElement getResult() {
        return result;
    }
    public WebElement getCheckElement(String Check)
    {
        String checkId = "tree-node-" + Check;
        WebElement child = driver.findElement(By.id(checkId));
        return child.findElement(By.xpath("./.."));
    }
}
