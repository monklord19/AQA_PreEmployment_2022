package FrontendProjectTests.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AutoCompletePage {
    private WebDriver driver;
    @FindBy(id = "autoCompleteMultipleInput")
    private WebElement autoCompleteMultipleInput;
    @FindBy(id = "autoCompleteSingleInput")
    private WebElement autoCompleteSingleInput;
    @FindBy(css=".auto-complete__single-value.css-1uccc91-singleValue")
    private WebElement colorSingle;
    private List<WebElement> multipleColor;
    public AutoCompletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        multipleColor = driver.findElements(By.cssSelector(".css-1rhbuit-multiValue.auto-complete__multi-value"));
    }

    public WebElement getColorSingle() {
        return colorSingle;
    }

    public WebElement getAutoCompleteSingleInput() {
        return autoCompleteSingleInput;
    }

    public WebElement getAutoCompleteMultipleInput() {
        return autoCompleteMultipleInput;
    }
}
