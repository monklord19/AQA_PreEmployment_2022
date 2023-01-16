package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    WebDriver driver;

    public MainPage (WebDriver driverWeb) {
        this.driver = driverWeb;
        PageFactory.initElements(driver, this);
    }

}
