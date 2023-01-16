package locators;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pageLocators {
    WebDriver driver;

    public pageLocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(className = "card-up")
    WebElement elementsButton;

    @FindBy(id = "item-2")
    WebElement radioButton;

    @FindBy(className = "custom-control-label")
    WebElement yesOption;

    @FindBy(className = "mt-3")
    WebElement yesTextAppears;

    public void userClicksOnElementsButton() {
        elementsButton.click();
    }

    public void userClicksOnRadioButton() {
        radioButton.click();
    }

    public void userCLicksOnYesOption() {
        yesOption.click();
    }

    public void youHaveSelectedYesTextAppears() {
        WebElement text = yesTextAppears;
        String expectedText = "You have selected Yes";
        Assert.assertEquals(expectedText, text.getText());
    }

}