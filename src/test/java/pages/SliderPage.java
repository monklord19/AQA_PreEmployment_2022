package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;

public class SliderPage {

    WebDriver driver;
    @FindBy(css = ".range-slider.range-slider--primary")
    private WebElement slider;
    @FindBy(css = "[class='col-3'] [value]")
    private WebElement resultSlider;
    public SliderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sliderMove() {
        Actions actions = new Actions(driver);
        actions.clickAndHold(slider).build().perform();
        actions.dragAndDropBy(slider, 2,0).build().perform();

    }
    public void checkResult(){
        Assert.assertEquals(resultSlider.getText(),"50");
    }
}
