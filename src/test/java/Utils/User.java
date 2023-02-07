package Utils;
import java.util.Random;

public class User {
    private  String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String currentAddress;
    private String permanentAddress;
    private Integer age;
    private Integer salary;
    private String department;

    private String password;
    private String favoriteBook;
    private static final String[] books = {"9781449325862", "9781449331818","9781449337711","9781449365035","9781491904244","9781491950296","9781593275846", "9781593277574"};
    private static final String[] firstNames = {"Ionut", "Cosmin", "Mihaela", "Sara", "David"};
    private static final String[] lastNames = {"Popescu", "Ionescu", "Chiriac", "Baciu", "Cretu"};
    private static final String[] domains = {"gmail.com", "yahoo.com", "outlook.com"};
    private static final String[] departments = {"HR", "IT", "Support", "Testing"};

    public User() {
        Random rand = new Random();
        this.firstName = firstNames[rand.nextInt(firstNames.length)];
        this.lastName = lastNames[rand.nextInt(lastNames.length)];
        this.department = departments[rand.nextInt(departments.length)];
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() +Integer.toString(rand.nextInt(100))+ "@" + domains[rand.nextInt(domains.length)];
        this.currentAddress = "Strada Ion Creanga, nr. 10, Iasi";
        this.permanentAddress = "Bld. Mihail Sadoveanu, nr. 99, Iasi";
        this.age = rand.nextInt(21, 40);
        this.salary = rand.nextInt(3000,15000);
        this.password = firstName + "." + lastName + Integer.toString(rand.nextInt(1000)) + '!';
        this.userName = firstName + lastName + Integer.toString(rand.nextInt(10000));
    }
    public String getPassword() {
        return password;
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
    public Integer getAge() {return age;}

    public Integer getSalary() {return salary;}

    public String getDepartment() {return department;}

    public Object getUserName() { return  userName;}

    public String getRandomBook(){
        Random rand = new Random();
        return books[rand.nextInt(books.length)];
    }
}