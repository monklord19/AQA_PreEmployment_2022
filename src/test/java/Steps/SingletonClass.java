package Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonClass {
    private static SingletonClass instance;
    private WebDriver driver;

    private SingletonClass() {
        driver = new ChromeDriver();
    }

    public static SingletonClass getInstance() {
        if (instance == null) {
            instance = new SingletonClass();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }
}

