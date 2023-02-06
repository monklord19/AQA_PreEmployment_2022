package UITests.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage {

    WebDriver driver;
    public static final By categories = By.className("category-cards");
    public static final By logo = By.xpath("//header//img");
    public static final By card = By.className("card");
    public static final By header = By.className("main-header");
    public static final By cardBody = By.className("card-body");
    private String clickedCategory;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public boolean areCategoryCardsDisplayed() {
        return getElement(categories).isDisplayed();
    }

    public boolean isLogoDisplayed() {
        return getElement(logo).isDisplayed();
    }

    public void clickCategory() {
        List<WebElement> categoriesElements = getElement(categories).findElements(card);
        if(categoriesElements.size() > 1) {
            setClickedCategory(categoriesElements.get(0).findElement(cardBody).getText());
            categoriesElements.get(0).click();
        }
    }

    public boolean isCorrectHeaderDisplayed() {
        return driver.findElement(header).getText().equals(getClickedCategory());
    }

    public void setClickedCategory(String clickedCategory) {
        this.clickedCategory = clickedCategory;
    }

    public String getClickedCategory() {
        return clickedCategory;
    }
}
