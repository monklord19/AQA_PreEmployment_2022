package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoElementsPage {


    @FindBy(id = "item-0")
    private WebElement textBoxLink;
    @FindBy(id = "item-1")
    private WebElement checkBox;

    WebDriver driver;

    public DemoElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickTextBoxLink() {
        textBoxLink.click();
    }
    public void clickCheckBox(){
        checkBox.click();
    }
}
