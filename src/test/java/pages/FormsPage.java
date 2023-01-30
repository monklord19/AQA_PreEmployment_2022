package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormsPage {
    @FindBy(css = ".show .btn-light")
    private WebElement practiceFormLink;

    WebDriver driver;
    public FormsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickPracticeForm(){

        practiceFormLink.click();
    }
}
