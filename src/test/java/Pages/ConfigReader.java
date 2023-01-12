package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties getPropertyObject() throws IOException {

        FileInputStream fp = new FileInputStream("src/test/resources/Config/config.properties");
        Properties prop = new Properties();
        prop.load(fp);
        return prop;
    }
    public static String getUrl() throws IOException{
        return getPropertyObject().getProperty("url");
    }
    public static String getUsername() throws IOException{
        return getPropertyObject().getProperty("username");
    }
    public static String getPassword() throws IOException{
        return getPropertyObject().getProperty("password");
    }
}
