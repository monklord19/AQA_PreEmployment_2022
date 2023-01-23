package ApiTests.apiEngine.Routes;
public class PostRoute {
    //POST ENDPOINTS
    private static final String endp_createUser="api/users";
    private static final String endp_register="api/register";
    private static final String endp_login="api/login";
    //POST
    public static String CreateUser() {
        return endp_createUser;
    }
    public static String Register() {return endp_register;}
    public static String Login() {
        return endp_login;
    }


}
