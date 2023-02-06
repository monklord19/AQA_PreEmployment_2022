package Backend.apiEngine.Requests;

public class CreateUserAccountRequest {
    public String userName;
    public String password;

    public CreateUserAccountRequest(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }
}
