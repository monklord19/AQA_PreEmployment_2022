package PageObjects;

import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class BasePage {

    private WebDriver driver;

    public BasePage (WebDriver driver) {
        this.driver = driver;
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

    public void openBrowser(String urlToOpen){
        driver.get(urlToOpen);
    }

    public void pleaseWait(long seconds) {
        pleaseWait(seconds, false);
    }

    public void pleaseWait(long seconds, boolean useThreadSleep) {
        if(!useThreadSleep){
            driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
        } else {
            try {
                Thread.sleep(seconds * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}