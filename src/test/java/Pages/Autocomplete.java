package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Autocomplete {
    WebDriver driver;
    WebDriverWait wait;

    public Autocomplete(WebDriver driver) {
        this.driver = driver;

    }

    public void clickOnWidgets()
    {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[4]")).click();

    }

    public void clickAutocomplete(){
        driver.get("https://demoqa.com/auto-complete");
    }

    public void enterTwoColours(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //WebElement firstColours = driver.findElement(By.xpath("//*[@id=\"autoCompleteMultipleContainer\"]/div/div[1]"));
        //firstColours.sendKeys("Purple" + Keys.RETURN);
        //firstColours.sendKeys("Orange" + Keys.RETURN);
        WebElement secondColour = driver.findElement(By.xpath("//*[@id=\"autoCompleteSingleContainer\"]/div/div[1]"));
        secondColour.sendKeys("Blue" + Keys.RETURN);
    }


}
