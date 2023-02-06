package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoqaHomepage extends Page {

    public DemoqaHomepage(WebDriver driver) {
        super(driver);
    }

    By elements = By.xpath("//h5[text()='Elements']");
    By forms = By.xpath("//h5[text()='Forms']");
    By alertsFrameAndWindows = By.xpath("//h5[text()='Alerts, Frame & Windows']");
    By widgets = By.xpath("//h5[text()='Widgets']");
    By interactions = By.xpath("//h5[text()='Interactions']");
    By bookStoreApplication = By.xpath("//h5[text()='Book Store Application']");

   public WebElement elementsCard() {
       return driver.findElement(elements);
    }
   public WebElement formsCard() {
       return driver.findElement(forms);
   }
   public WebElement alertsFrameAndWindowsCard() {
       return driver.findElement(alertsFrameAndWindows);
  }
   public WebElement widgetsCard() {
        return driver.findElement(widgets);
    }
   public WebElement interactionsCard() {
       return driver.findElement(interactions);
   }
   public WebElement bookStoreApplicationCard() {
       return driver.findElement(bookStoreApplication);
   }

}
