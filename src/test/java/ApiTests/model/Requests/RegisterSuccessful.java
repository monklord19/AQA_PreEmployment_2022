package ApiTests.model.Requests;

public class RegisterSuccessful {
    public String email;
    public String password;
    public RegisterSuccessful(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }
}
