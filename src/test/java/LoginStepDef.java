import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class LoginStepDef {
    WebDriver driver;
    String EXPECTED_URL = "https://www.saucedemo.com/";
    String EXPECTED_USER = "standard_user";
    String INCORRECT_USER = "gdfgdf";
    String EXPECTED_PASSWORD = "secret_sauce";
    String INCORRECT_PASSWORD = "daadas";
    String EXPECTED_TITILE_PAGE = "Swag Labs";
    String INCORRECT_USERNAME_CREDENTIALS = "user1";
    String INCORRECT_PASSWORD_CREDENTIALS = "parola1";


    /*
    Invalid URL test
    String EXPECTED_URL = "https://www.saucedemo.com/";

     */
    @Given("User opens sauce demo site")
    public void userOpensSauceDemoSite() {
        System.setProperty("webdriver.chrome.driver", "/Users/pitiriciuiulian/Downloads/chromedriver");
            driver = new ChromeDriver();
            driver.get(EXPECTED_URL);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Assert.assertEquals(driver.getCurrentUrl(), EXPECTED_URL);
        System.out.println("Website opened");
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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Assert.assertEquals(username.getAttribute("value"), EXPECTED_USER);
        /*
      System.out.println(username.getAttribute("value"));
         Folosim expected_user ca si userul corect. La tastatura putem sa scriem userul corect(expected_user) sau cel incorect (incorect_user).
     getAttribute("value") ---> am luat valoarea inputului de la username.

         Unde o sa adaug valorile care trebuie sa fie testate? In cod modificam valoare respectiva?
         Daca avem mai multi useri care trebuie testati, il luam pe fiecare dintr-o lista sau ii adaugam manual pe fiecare?
         Cand folosim xpath im favoarea altor metode de a cauta elemente precum dupa id,clasa,text

         */
        System.out.println("Valid username");
    }

    @And("User types password")
    public void userTypesPassword() {
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));

        /*
        Incorrect password test
        password.sendKeys(INCORRECT_PASSWORD);
         */

        password.sendKeys(EXPECTED_PASSWORD);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Assert.assertEquals(password.getAttribute("value"), EXPECTED_PASSWORD);
        System.out.println("Valid password");
    }

    @And("User clicks on login button")
    public void userClicksOnLoginButton() {
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        loginButton.click();
        System.out.println("Log in successfully");
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

        System.out.println("User is logged in");

    }

    @And("User should be loged out")
    public void userShouldBeLogedOut() {

        /*
        WebElement logOut = driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]"));
        logOut.click();
        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
        driver.findElement(By.partialLinkText("LOGOUT")).click();
        */

        driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
        System.out.println("Log out successfully");

    }

    @And("If user types incorrect credentials")
    public void ifUserTypesIncorrectCredentials() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        WebElement incorrectUsername = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        incorrectUsername.sendKeys(INCORRECT_USERNAME_CREDENTIALS);
        Assert.assertEquals(incorrectUsername.getAttribute("value"), INCORRECT_USERNAME_CREDENTIALS);
            WebElement incorrectPassword = driver.findElement(By.xpath("//*[@id=\"password\"]"));
            incorrectPassword.sendKeys(INCORRECT_PASSWORD_CREDENTIALS);
            Assert.assertEquals(incorrectPassword.getAttribute("value"), INCORRECT_PASSWORD_CREDENTIALS);
        System.out.println("Log in with incorrect credentials");

    }

    @And("User clicks on login")
    public void userClicksOnLogin() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        System.out.println("Invalid login");
    }

    @And("User should receive an error message")
    public void userShouldReceiveAnErrorMessage() {
        driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        System.out.println("Error message is displayed on website");
    }
}





