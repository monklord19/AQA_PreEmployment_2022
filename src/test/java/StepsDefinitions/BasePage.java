//package StepsDefinitions;
//
//import Pages.SpotifyPage;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.io.IOException;
//import java.util.Properties;
//
//import static Pages.ConfigReader.getUrl;
//
//public class BasePage {
//    public static  WebDriver driver;
//
//    public static SpotifyPage spage ;
//    public static Properties prop = new Properties();
//
//    @Before
//    public void IAmOnLoginPageAndAcceptCoockies() throws IOException {
//
//        String test_url = getUrl();
//        WebDriver driver = new ChromeDriver();
//
//        driver.manage().window().maximize();
//        driver.get(test_url);
//
//        SpotifyPage spage  = new SpotifyPage(driver);
//        System.out.println("completed");
//        //spage.closeCookie();
//        //spage.Connect();
//    }
//        @After
//    public void closesteps(){
//        driver.quit();
//   }
//}
