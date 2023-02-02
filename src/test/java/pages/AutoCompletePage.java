package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoCompletePage {
    WebDriver driver;

    @FindBy(css = "input#autoCompleteMultipleInput")
    private WebElement multipleColorsField;
    @FindBy(css = "input#autoCompleteSingleInput")
    private WebElement singleColorsField;
    @FindBy(css = ".auto-complete__value-container.auto-complete__value-container--has-value.auto-complete__value-container--is-multi.css-1hwfws3")
    private WebElement multipleColorCheck;
    @FindBy(css = ".auto-complete__single-value.css-1uccc91-singleValue")
    private WebElement singleColorCheck;

    public AutoCompletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setMultipleColorsField(String firstColor, String secColor) {
        multipleColorsField.sendKeys(firstColor);
        multipleColorsField.sendKeys(Keys.ENTER);
        multipleColorsField.sendKeys(secColor);
        multipleColorsField.sendKeys(Keys.ENTER);
    }

    public void setSingleColorsField(String color) {
        singleColorsField.sendKeys(color);
        singleColorsField.sendKeys(Keys.ENTER);
        System.out.println(multipleColorsField.getText());
    }

    public void checkFields() {
    Assert.assertEquals("Red\nYellow",multipleColorCheck.getText());
    Assert.assertEquals("Blue",singleColorCheck.getText());

    }
}
