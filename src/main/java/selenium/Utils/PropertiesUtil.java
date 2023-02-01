package selenium.Utils;

import selenium.BaseClass;

import java.util.Properties;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PropertiesUtil extends BaseClass {
    public static Properties properties = new Properties();
    static FileInputStream fis;


    public static java.util.Properties loadApplicationProperties(){


        try {
            fis = new FileInputStream("application.properties");
            properties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }


    public static Properties loadFrameworkProperties(){

        try {
            fis = new FileInputStream("framework.properties");
            properties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }


    public static Properties loadUserProperties(){

        try {
            fis = new FileInputStream("user.properties");
            properties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
