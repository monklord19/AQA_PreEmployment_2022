package ApiTests.pageObjects;

public class RestApiPage {

    public static String baseUrl = "https://reqres.in/api";

    public static String getUserUrl = baseUrl + "/users/2";
    public static String getUserNotFoundUrl = baseUrl + "/user/23";
    public static String postUserUrl = baseUrl + "/user";
    public static String putUserUrl = baseUrl + "/user/2";
    public static String deleteUserUrl = baseUrl + "/user/2";

}
