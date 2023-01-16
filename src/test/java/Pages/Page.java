package Pages;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Page {
    WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        driver.get("https://open.spotify.com/");
        driver.manage().window().maximize();
    }
    public void refreshPage(){
        driver.navigate().refresh();
    }

    public void closeWindow() {
        driver.quit();
    }

    public void waitUntilElementIsVisible(int time){
        System.out.println("Wait from Page");
    }

}
