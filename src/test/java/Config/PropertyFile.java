package Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
    private String username;
    private String password;
    private String demoUserName;
    private String demoPassword;
    public PropertyFile() {
        Properties prop = new Properties();

        try (FileInputStream input = new FileInputStream("src/test/resources/properties.properties")) {
            prop.load(input);
            username = prop.getProperty("BOOKSTORE-USERNAME");
            password = prop.getProperty("BOOKSTORE-PASSWORD");

            demoUserName = prop.getProperty("DEMO-DEFS-USERNAME");
            demoPassword = prop.getProperty("DEMO-DEFS-PASSWORD");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getDemoUserName(){
        return demoUserName;
    }
    public String getDemoPassword(){
        return demoPassword;
    }
}
