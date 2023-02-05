package PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties getPropertyObject() throws IOException {

        FileInputStream fp = new FileInputStream("src/test/resources/testFiles/config.properties");
        Properties prop = new Properties();
        prop.load(fp);
        return prop;
    }
    public static String getUsername() throws IOException{
        return getPropertyObject().getProperty("username");
    }
    public static String getEmail() throws IOException{
        return getPropertyObject().getProperty("email");
    }
    public static String getCurrentAdress() throws IOException{
        return getPropertyObject().getProperty("current.adress");
    }
    public static String getPermanentAdress() throws IOException{
        return getPropertyObject().getProperty("permanent.adress");
    }
}
