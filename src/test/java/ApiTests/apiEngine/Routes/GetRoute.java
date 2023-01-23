package ApiTests.apiEngine.Routes;

public class GetRoute {
    //GET-ENDPOINTS
    private static final String endp_UsersList = "api/users?page=2";
    private static final String endp_SingleUser = "api/users/2";
    private static final String endp_singleUserNotFound = "api/users/23";
    private static final String endp_listResource = "api/unknown";
    private static final String endp_singleResource = "api/unknown/2";
    private static final String endp_singleResourceNotFound = "api/unknown/23";
    private static final String endp_delayedResponse = "api/users?delay=3";

    //GET
    public static String UsersList() {
        return endp_UsersList;
    }

    public static String SingleUser() {
        return endp_SingleUser;
    }

    public static String SingleUserNotFound() {
        return endp_singleUserNotFound;
    }

    public static String ListResource() {
        return endp_listResource;
    }

    public static String SingleResource() {
        return endp_singleResource;
    }

    public static String SingleResourceNotFound() {
        return endp_singleResourceNotFound;
    }

    public static String DelayedResponse() {
        return endp_delayedResponse;
    }
}
