package locators;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(id = "item-4")
    WebElement buttons;

    @FindBy(xpath = "//*[text()='Click Me']")
    WebElement clickMeButton;

    @FindBy(id = "dynamicClickMessage")
    WebElement dynamicClickTextAppears;

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

    public void userClicksOnButtonsButton() {
//        WebElement buttons = driver.findElement(By.id("item-4"));
          JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("javascript:window.scrollBy(250,350)");
//        new Actions(driver)
//                .click(buttons)
//                .perform();
//
          buttons.click();
    }

    public void userCLicksOnClickMeButton() throws InterruptedException {
        Thread.sleep(2000);
        clickMeButton.click();
    }

    public void youHaveDoneADynamicClickTextAppears() {
        WebElement text = dynamicClickTextAppears;
        String expectedText = "You have done a dynamic click";
        Assert.assertEquals(expectedText, text.getText());
    }

}