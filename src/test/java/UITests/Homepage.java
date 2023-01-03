package UITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {

    WebDriver driver;
    private final WebElement title = driver.findElement(By.cssSelector(".title"));

    public boolean isTitleDisplayed() {
        return this.title.isDisplayed();
    }

}
