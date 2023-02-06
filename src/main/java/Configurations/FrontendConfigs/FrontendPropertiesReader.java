package Configurations.FrontendConfigs;

import java.io.*;
import java.util.Properties;

public class FrontendPropertiesReader {

    private static Properties properties = new Properties();

    static {
        InputStream inputStream = FrontendPropertiesReader.class.getClassLoader().getResourceAsStream("FrontendProperties.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println("Failed to load properties");
            ;
        }
    }

    //getting properties related to drivers
    private static String chromeDriverPath = properties.getProperty("chrome.driver.path");
    private static String geckoDriverPath = properties.getProperty("gecko.driver.path");
    private static String edgeDriverPath = properties.getProperty("edge.driver.path");

    public static String getChromeDriverPath() {
        return chromeDriverPath;
    }

    public static String getGeckoDriverPath() {
        return geckoDriverPath;
    }

    public static String getEdgeDriverPath() {
        return edgeDriverPath;
    }

    //base url
    private static String base_url = properties.getProperty("BASE_URL");

    public static String getBase_url() {
        return base_url;
    }

    //radio button section
    private static String impressive_message = properties.getProperty("Impressive_message");

    public static String getImpressive_message() {
        return impressive_message;
    }

    //check box section
    private static String homeCheckBoxMessage = properties.getProperty("HomeCheckBoxMessage");

    public static String getHomeCheckBoxMessage() {
        return homeCheckBoxMessage;
    }

    //text box section
    private static String fullName = properties.getProperty("FullName");
    private static String email = properties.getProperty("Email");
    private static String currentAddress = properties.getProperty("CurrentAddress");
    private static String permanentAddress = properties.getProperty("PermanentAddress");

    public static String getFullName() {
        return fullName;
    }

    public static String getEmail() {
        return email;
    }

    public static String getCurrentAddress() {
        return currentAddress;
    }

    public static String getPermanentAddress() {
        return permanentAddress;
    }

    //Web Tables
    private static String firstName = properties.getProperty("FirstName");
    private static String lastName = properties.getProperty("LastName");
    private static String age = properties.getProperty("Age");
    private static String salary = properties.getProperty("Salary");
    private static String department = properties.getProperty("Department");

    public static String getFirstName() {
        return firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static String getAge() {
        return age;
    }

    public static String getSalary() {
        return salary;
    }

    public static String getDepartment() {
        return department;
    }

    //Buttons messages
    private static String doubleClickMessage = properties.getProperty("DoubleClickMessage");
    private static String rightClickMessage = properties.getProperty("RightClickMessage");

    public static String getDoubleClickMessage() {
        return doubleClickMessage;
    }

    public static String getRightClickMessage() {
        return rightClickMessage;
    }

    //Links section
    private static String createdMessage = properties.getProperty("CreatedMessage");

    public static String getCreatedMessage() {
        return createdMessage;
    }
}



