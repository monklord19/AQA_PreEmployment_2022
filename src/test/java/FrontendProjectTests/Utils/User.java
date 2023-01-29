package FrontendProjectTests.Utils;
import java.util.Random;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String currentAddress;
    private String permanentAddress;

    private static final String[] firstNames = {"Ionut", "Cosmin", "Mihaela", "Sara", "David"};
    private static final String[] lastNames = {"Popescu", "Ionescu", "Chiriac", "Baciu", "Cretu"};
    private static final String[] domains = {"gmail.com", "yahoo.com", "outlook.com"};

    public User() {
        Random rand = new Random();

        this.firstName = firstNames[rand.nextInt(firstNames.length)];
        this.lastName = lastNames[rand.nextInt(lastNames.length)];
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() +Integer.toString(rand.nextInt(100))+ "@" + domains[rand.nextInt(domains.length)];
        this.currentAddress = "Strada Ion Creanga, nr. 10, Iasi";
        this.permanentAddress = "Bld. Mihail Sadoveanu, nr. 99, Iasi";
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCurrentAddress() {
        return this.currentAddress;
    }

    public String getPermanentAddress() {
        return this.permanentAddress;
    }
}