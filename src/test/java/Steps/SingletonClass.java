package Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SingletonClass {
    private static SingletonClass instance;
    private WebDriver driver;
    private Actions actions;

    private SingletonClass() {
        driver = new ChromeDriver();
        this.actions = new Actions(driver);
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

    public Actions getActions(){
        return actions;
    }
}

