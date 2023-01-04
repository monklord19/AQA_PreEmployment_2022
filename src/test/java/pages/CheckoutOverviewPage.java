package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {
    @FindBy(css = "div.summary_value_label:nth-child(4)")
    private WebElement shippingInformationText;

    @FindBy(id = "finish")
    private WebElement finishButton;


    WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

public void checkInformationText(String infoText){
    Assert.assertEquals(infoText, shippingInformationText.getText());

}
    public void clickFinishButton(){
        finishButton.click();
    }
}
