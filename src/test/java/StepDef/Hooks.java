package StepDef;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    public static WebDriver webDriver;

    @Before
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
        webDriver= new ChromeDriver();
        String URL = "https://www.saucedemo.com/";
        webDriver.get(URL);
        webDriver.manage().window().maximize();
    }
    @After
    public void closeBrowser(){
        webDriver.quit();
    }
}