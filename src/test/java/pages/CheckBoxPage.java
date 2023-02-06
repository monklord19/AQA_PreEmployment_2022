package pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPage {
    @FindBy(css = ".rct-icon.rct-icon-expand-all")
    private WebElement expendCheckBox;
    @FindBy(css = "[for='tree-node-react'] .rct-icon-uncheck")
    private WebElement reactCheckBox;
    @FindBy(css = "[for='tree-node-angular'] .rct-icon-uncheck")
    private WebElement angularCheckBox;
    @FindBy(css = "[for='tree-node-veu'] .rct-icon-uncheck")
    private WebElement veuCheckBox;
    @FindBy(id = "result")
    private WebElement resultForm;


    WebDriver driver;

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickExpandButton() {
        expendCheckBox.click();
    }

    public void clickTheCheckBoxes() throws InterruptedException {
        reactCheckBox.click();
        angularCheckBox.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
        veuCheckBox.click();
        Thread.sleep(1000);
    }

    public void checkResultForm(String res) {
        Assert.assertEquals(res, resultForm.getText());
    }
}
