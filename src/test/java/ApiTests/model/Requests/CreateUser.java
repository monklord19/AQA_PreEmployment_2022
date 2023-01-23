package ApiTests.model.Requests;
public class CreateUser {

    public String name;
    public String job;

    public CreateUser() {
    }
    public CreateUser(String name, String job) {
        super();
        this.name = name;
        this.job = job;
    }

}