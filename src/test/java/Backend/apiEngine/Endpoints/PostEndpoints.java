package Backend.apiEngine.Endpoints;

import Backend.apiEngine.Requests.AddBooksRequest;
import Backend.apiEngine.Requests.CreateUserAccountRequest;
import Backend.apiEngine.Requests.ISBN;
import Backend.apiEngine.Routes.Routes;
import Configurations.BackendConfigs.BackendPropertiesReader;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.junit.Assert;

public class PostEndpoints  {
    public static Response createUserAccount() {
        String userName = BackendPropertiesReader.getInstance().getUserName();
        String password = BackendPropertiesReader.getInstance().getPassword();
        CreateUserAccountRequest requestBody=new CreateUserAccountRequest(userName,password);
        Routes createUserRoute = Routes.CreateUser;
        Response createUserResponse = CommonMethods.iSetTheRequestSpecifications().body(requestBody).when().post(createUserRoute.getUrl());
        return createUserResponse;
    }
    public static String getUserId() {
        //TODO nu stiu daca am gandit corect cu metoda asta, daca nu merge o sterg
        String responseAsString = PostEndpoints.createUserAccount().asString();
        Assert.assertTrue(responseAsString.contains("userID"));
        String userId = JsonPath.from(responseAsString).get("userID");
        System.out.println("USER ID IS : "+ userId);
        return userId;
    }

    public static Response authorizeUserAccount() {
        String userName = BackendPropertiesReader.getInstance().getUserName();
        String password = BackendPropertiesReader.getInstance().getPassword();
        JSONObject requestBody = new JSONObject();
        requestBody.put("userName", userName);
        requestBody.put("password", password);
        Routes authRoute = Routes.Authorize;
        Response response = CommonMethods.iSetTheRequestSpecifications().body(requestBody).when().post(authRoute.getUrl());
        return response;
    }

    public static Response generateToken() {
        String userName = BackendPropertiesReader.getInstance().getUserName();
        String password = BackendPropertiesReader.getInstance().getPassword();
        JSONObject requestBody = new JSONObject();
        requestBody.put("userName", userName);
        requestBody.put("password", password);
        Routes generateTokenRoute = Routes.GenerateToken;
        Response responseForToken = CommonMethods.iSetTheRequestSpecifications().body(requestBody).when().post(generateTokenRoute.getUrl());
        return responseForToken;
    }

    public static String getToken() {
        //TODO nici de asta nu sunt asa sigura
        String responseAsString = PostEndpoints.generateToken().asString();
        Assert.assertTrue(responseAsString.contains("token"));
        String token = JsonPath.from(responseAsString).get("token");
        System.out.println("TOKEN IS: " + token);
        return token;
    }

    public static Response addABook() {
        String userId = PostEndpoints.getUserId();
        AddBooksRequest addBooksRequest = new AddBooksRequest(userId, new ISBN("9781449331818"));
        Routes addBooksRoute = Routes.AddBooks;
        Response addBooksResponse = CommonMethods.iSetTheRequestSpecifications().body(addBooksRequest).post(addBooksRoute.getUrl());
        return addBooksResponse;
    }

}
