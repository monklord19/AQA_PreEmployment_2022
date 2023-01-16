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

    @FindBy(id = "item-1")
    WebElement checkBox;

    @FindBy(className = "rct-checkbox")
    WebElement homeCheckBox;

    @FindBy(id = "result")
    WebElement homeDesktopTestAppears;

    public void userClicksOnRadioButton() {
        radioButton.click();
    }

    public void userClicksOnElementsButton() {
        elementsButton.click();
    }

    public void userCLicksOnYesOption() {
        yesOption.click();
    }

    public void youHaveSelectedYesTextAppears() {
        WebElement text = yesTextAppears;
        String expectedText = "You have selected Yes";
        Assert.assertEquals(expectedText, text.getText());
    }

    public void userClicksOnCheckBox() {
        checkBox.click();
    }

    public void userClicksOnHomeCheckBox() {
        homeCheckBox.click();
    }

    public void youHaveSelectedHomeDesktopAppears() {
        WebElement text = homeDesktopTestAppears;
        String expectedText = "You have selected :\n" +
                "home\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "documents\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general\n" +
                "downloads\n" +
                "wordFile\n" +
                "excelFile";
        Assert.assertEquals(expectedText, text.getText());
    }

}