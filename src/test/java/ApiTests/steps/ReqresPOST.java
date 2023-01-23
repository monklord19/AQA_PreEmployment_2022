package ApiTests.steps;

import ApiTests.apiEngine.endpoints.PostEndpoints;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.junit.Test;


public class ReqresPOST {
    @Test
    public void createUser() {

//        String BASE_URL = "https://reqres.in/";
//        String BASE_PATH = "api/users";
//        RestAssured.baseURI = BASE_URL;
//        RestAssured.basePath = BASE_PATH;
//        RequestSpecification httpRequest = RestAssured.given();
//        CreateUser createUser = new CreateUser("morpheus", "leader");
//        // JSONObject is a class that represents a Simple JSON.
//        // We can add Key - Value pairs using the put method
//        //JSONObject requestParams=new JSONObject();
//        //requestParams.put("name","morpheus");
//        //requestParams.put("job","leader");
//        //add a header stating the request body is a JSON
//        httpRequest.header("Content-Type", "application/json");
//        Response response = httpRequest.body(createUser).when().post(BASE_PATH);
//        String responseAsString = response.asPrettyString();
//        System.out.println(responseAsString);
//        ValidatableResponse vr;
//        vr = response.then();
//        vr.statusCode(Matchers.equalTo(201));
//        vr.time(Matchers.lessThanOrEqualTo((long) 2000));
//        vr.header("Content-Type", Matchers.containsString("application/json; charset=utf-8"));
        Response createUserResponse = PostEndpoints.createUser();
        String body = createUserResponse.asPrettyString();
        System.out.println(body);
        ValidatableResponse vr;
        vr = createUserResponse.then();
        vr.statusCode(Matchers.equalTo(201));
        vr.time(Matchers.lessThanOrEqualTo((long) 2000));
        vr.header("Content-Type", Matchers.containsString("application/json; charset=utf-8"));
    }
    @Test
    public void registerSuccessful(){
        Response registerUserResponse = PostEndpoints.registerSuccessful();
        String body = registerUserResponse.asPrettyString();
        System.out.println(body);
        ValidatableResponse vr;
        vr = registerUserResponse.then();
        vr.statusCode(Matchers.equalTo(200));
        vr.time(Matchers.lessThanOrEqualTo((long) 2000));
        vr.header("Content-Type", Matchers.containsString("application/json; charset=utf-8"));
    }
    @Test
    public void registerUnsuccessful(){
        Response registerUserResponse = PostEndpoints.registerUnsuccessful();
        String body = registerUserResponse.asPrettyString();
        System.out.println(body);
        ValidatableResponse vr;
        vr = registerUserResponse.then();
        vr.statusCode(Matchers.equalTo(400));
        vr.time(Matchers.lessThanOrEqualTo((long) 2000));
        vr.header("Content-Type", Matchers.containsString("application/json; charset=utf-8"));
    }
    @Test
    public void loginSuccessful(){
        Response registerUserResponse = PostEndpoints.loginSuccessful();
        String body = registerUserResponse.asPrettyString();
        System.out.println(body);
        ValidatableResponse vr;
        vr = registerUserResponse.then();
        vr.statusCode(Matchers.equalTo(200));
        vr.time(Matchers.lessThanOrEqualTo((long) 2000));
        vr.header("Content-Type", Matchers.containsString("application/json; charset=utf-8"));
    }
    @Test
    public void loginUnsuccessful(){
        Response registerUserResponse = PostEndpoints.loginUnsuccessful();
        String body = registerUserResponse.asPrettyString();
        System.out.println(body);
        ValidatableResponse vr;
        vr = registerUserResponse.then();
        vr.statusCode(Matchers.equalTo(400));
        vr.time(Matchers.lessThanOrEqualTo((long) 2000));
        vr.header("Content-Type", Matchers.containsString("application/json; charset=utf-8"));
    }
}
