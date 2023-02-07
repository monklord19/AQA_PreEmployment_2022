package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


public class WidgetsPage {
    WebDriver driver;

    public WidgetsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[4]/div/div[2]")
    private WebElement WidgetsButton;


    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[4]/div/ul/li[5]/span")
    private WebElement progressBarBtn;
    @FindBy(id = "startStopButton")
    private WebElement progressBarStartBtn;
    @FindBy(xpath = "//*[@id=\"progressBar\"]")
    private WebElement progressBar;


    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[4]/div/ul/li[4]")
    private WebElement sliderPage;

    @FindBy(xpath = "//*[@id=\"sliderContainer\"]/div[1]/span/input")
    private WebElement slider;

    public void wait(WebElement element){
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickWidgetButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");

        wait(WidgetsButton);
        WidgetsButton.click();
    }


    public void clickProgressBar(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");

        wait(progressBarBtn);
        progressBarBtn.click();
    }

    public void startProgressBar(){
        wait(progressBar);
        progressBarStartBtn.click();
    }


    public void sliderPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");

        wait(sliderPage);
        sliderPage.click();
    }

    public void useSlider(){
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, 50, 150).perform();
    }

    public void verifySliderValue(){
        String sliderValue = slider.getAttribute("value");
        Assert.assertEquals("60", sliderValue);
    }


}
