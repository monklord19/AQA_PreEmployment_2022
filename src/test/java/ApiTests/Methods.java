package ApiTests;

import ApiTests.apiEngine.Requests.AuthorizationRequest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class Methods {
    public static RequestSpecification iSetTheRequestSpecifications() {
        String BASE_URL = BackendPropertiesReader.getInstance().getBaseUrl();
        RestAssured.baseURI = BASE_URL;
        RequestSpecification requestSpecificationSettings;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(BASE_URL);
        builder.addHeader("Content-Type:", " application/json");
        requestSpecificationSettings = builder.build();
        RequestSpecification request=RestAssured.given().spec(requestSpecificationSettings);
        return request;
    }

    public static Response createUser() {
        String userName = BackendPropertiesReader.getInstance().getUserName();
        String password = BackendPropertiesReader.getInstance().getPassword();
        AuthorizationRequest authRequestBody = new AuthorizationRequest(userName, password);
        Routes createUserRoute = Routes.CreateUser;
        Response createUserResponse = Methods.iSetTheRequestSpecifications().body(authRequestBody).post(createUserRoute.getUrl());
        Assert.assertEquals(201,createUserResponse.getStatusCode());
        return createUserResponse;
    }

    public static String getUserId() {
        String responseAsString = Methods.createUser().asString();
        Assert.assertTrue(responseAsString.contains("userID"));
        String userId = JsonPath.from(responseAsString).get("userID");
        return userId;
    }

    public String generateAndGetToken() {
        String userName = BackendPropertiesReader.getInstance().getUserName();
        String password = BackendPropertiesReader.getInstance().getPassword();
        AuthorizationRequest authRequestBody = new AuthorizationRequest(userName, password);
        Routes generateTokenRoute = Routes.GenerateToken;
        Response responseForToken = Methods.iSetTheRequestSpecifications().body(authRequestBody).post(generateTokenRoute.getUrl());
        String responseAsString = responseForToken.asString();
        Assert.assertTrue(responseAsString.contains("token"));
        String token = JsonPath.from(responseAsString).get("token");
        return token;
    }

    public void AuthorizedSuccessful() {
        String userName = BackendPropertiesReader.getInstance().getUserName();
        String password = BackendPropertiesReader.getInstance().getPassword();
        AuthorizationRequest authRequestBody = new AuthorizationRequest(userName, password);
        Routes authRoute = Routes.Authorize;
        Response response = Methods.iSetTheRequestSpecifications().body(authRequestBody).post(authRoute.getUrl());
        Assert.assertTrue(response.asString().contains("true"));
        Assert.assertEquals(response.getStatusCode(),200);
    }
    public static Response getAllBooks(){
        Routes getAllBooksRoute=Routes.GetBooks;
       Response getAllBooksResponse= Methods.iSetTheRequestSpecifications().get(getAllBooksRoute.getUrl());
       return getAllBooksResponse;
    }
    public static String getBooksISBN(){
String allBooksResponseAsString=Methods.getAllBooks().asString();
        List<Map<String,String>> books=JsonPath.from(allBooksResponseAsString).get("books");
        Assert.assertTrue(books.size()>0);
        String bookISBN=books.get(0).get("isbn");
        return bookISBN;

    }
}
