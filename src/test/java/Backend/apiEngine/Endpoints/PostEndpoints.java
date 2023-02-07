package Backend.apiEngine.Endpoints;

import Backend.apiEngine.Requests.AddBooksRequest;
import Backend.apiEngine.Requests.CreateUserAccountRequest;
import Backend.apiEngine.Requests.ISBN;
import Backend.apiEngine.Routes.Routes;
import Configurations.BackendConfigs.BackendPropertiesReader;
import io.restassured.response.Response;

public class PostEndpoints {
    public static Response createUserAccount() {
        String userName = BackendPropertiesReader.getInstance().getUserName();
        String password = BackendPropertiesReader.getInstance().getPassword();
        CreateUserAccountRequest requestBody=new CreateUserAccountRequest(userName,password);
        Routes createUserRoute = Routes.CreateUser;
        Response createUserResponse =CommonMethods.iSetTheRequestSpecifications().body(requestBody).when().post(createUserRoute.getUrl());
        String userId =createUserResponse.getBody().jsonPath().getString("userID");
        System.out.println("UserID IS: "+userId);
        return createUserResponse;
    }


    public static Response authorizeUserAccount() {
        String userName = BackendPropertiesReader.getInstance().getUserName();
        String password = BackendPropertiesReader.getInstance().getPassword();
        CreateUserAccountRequest requestBody = new CreateUserAccountRequest(userName, password);
        Routes authRoute = Routes.Authorize;
        Response response = CommonMethods.iSetTheRequestSpecifications().body(requestBody).when().post(authRoute.getUrl());
        return response;
    }

    public static Response generateToken() {
        String userName = BackendPropertiesReader.getInstance().getUserName();
        String password = BackendPropertiesReader.getInstance().getPassword();
        CreateUserAccountRequest requestBody = new CreateUserAccountRequest(userName, password);
        Routes generateTokenRoute = Routes.GenerateToken;
        Response responseForToken = CommonMethods.iSetTheRequestSpecifications().body(requestBody).when().post(generateTokenRoute.getUrl());
        return responseForToken;
    }

    public static Response addABook() {
        String userId = PostEndpoints.getUserId();
        AddBooksRequest addBooksRequest = new AddBooksRequest(userId, new ISBN("9781449365035"));
        Routes addBooksRoute = Routes.AddBooks;
        Response addBooksResponse = CommonMethods.iSetTheRequestSpecifications().body(addBooksRequest).when().post(addBooksRoute.getUrl());
        return addBooksResponse;
    }
    public static String getUserId() {
        String userId =PostEndpoints.createUserAccount().getBody().jsonPath().getString("userID");
        System.out.println("UserID IS: "+userId);
        return userId;
    }

    public static String getToken() {
        String token =PostEndpoints.generateToken().getBody().jsonPath().getString("token");
        System.out.println("TOKEN IS: "+ token);
        return token;
    }

}
