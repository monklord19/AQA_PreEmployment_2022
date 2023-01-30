package PageObjects;

import org.openqa.selenium.WebDriver;

public class ReqresPage extends BasePage{
    public WebDriver driver;



    public ReqresPage (WebDriver driver){
        super(driver);
        this.driver = driver;
    }
}
