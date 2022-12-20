import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.json.JsonOutput;


import javax.xml.xpath.XPath;
import java.lang.reflect.Array;

public class MyStepdefs1 {
    WebDriver driver;
    String EXPECTED_URL = "https://www.saucedemo.com/";
    String EXPECTED_USER = "standard_user";
    String INCORRECT_USER = "gdfgdf";
    String EXPECTED_PASSWORD = "secret_sauce";
    String INCORRECT_PASSWORD ="daadas";

    String EXPECTED_TITILE_PAGE = "Swag Labs";
    /*
    Invalid URL test
    String EXPECTED_URL = "https://www.saucedemo.com/";

     */
    @Given("User opens sauce demo site")
    public void userOpensSauceDemoSite() {
        System.setProperty("webdriver.chrome.driver", "/Users/pitiriciuiulian/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get(EXPECTED_URL);
        Assert.assertEquals(driver.getCurrentUrl(), EXPECTED_URL);
    }

    /*
    public static void main(String[] args) {
                System.setProperty("webdriver.chrome.driver", "/Users/pitiriciuiulian/Downloads/chromedriver");
                WebDriver driver = new ChromeDriver();
                driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]")); --> doesen't work like this
      WebElement username = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/div/form/div[1]/input"));
       WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
       WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        username.sendKeys("standard_user");
        try
        {
            Thread.sleep(1500);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        password.sendKeys("secret_sauce");
        try
        {
            Thread.sleep(1500);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        loginButton.click();
        System.out.println("Valid login");


    }

    */

    @When("User enters username")
    public void userEntersUsername() {
        WebElement username = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/div/form/div[1]/input"));
/*  Invalid test for username
       username.sendKeys(INCORRECT_USER);

 */
          username.sendKeys(EXPECTED_USER);
        Assert.assertEquals(username.getAttribute("value"), EXPECTED_USER);
        /*
      System.out.println(username.getAttribute("value"));
         Folosim expected_user ca si userul corect. La tastatura putem sa scriem userul corect(expected_user) sau cel incorect (incorect_user).
     getAttribute("value") ---> am luat valoarea inputului de la username.

         Unde o sa adaug valorile care trebuie sa fie testate? In cod modificam valoare respectiva?
         Daca avem mai multi useri care trebuie testati, il luam pe fiecare dintr-o lista sau ii adaugam manual pe fiecare?
         Cand folosim xpath im favoarea altor metode de a cauta elemente precum dupa id,clasa,text

         */
    }

    @And("User types password")
    public void userTypesPassword() {
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        /*
        Incorrect password test
        password.sendKeys(INCORRECT_PASSWORD);

         */
        password.sendKeys(EXPECTED_PASSWORD);
        Assert.assertEquals(password.getAttribute("value"),EXPECTED_PASSWORD);

    }

    @And("User clicks on login button")
    public void userClicksOnLoginButton() {
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        loginButton.click();

    }

    @Then("User should be logged in")
    public void user_should_be_logged_in() {
        String pageTitle = driver.getTitle();
        Assert.assertEquals(EXPECTED_TITILE_PAGE, pageTitle);

        /* Invalid title page
        String pageTitle = driver.getTitle();
        String expectedTitle = "Most Reliable App & Cross Browser Testing Platform | BrowserStack";
        Assert.assertEquals(expectedTitle, pageTitle);

         */

    }


}





