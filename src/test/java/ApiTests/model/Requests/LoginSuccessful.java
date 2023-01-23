package ApiTests.model.Requests;

public class LoginSuccessful {
    public String email;
    public String password;
    public LoginSuccessful(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }
}