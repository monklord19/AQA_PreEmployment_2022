package ApiTests.apiEngine.endpoints;

import ApiTests.apiEngine.Routes.PostRoute;
import ApiTests.model.Requests.*;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PostEndpoints {
    private static final String BASE_URL="https://reqres.in/";
    public static Response createUser(){
        RestAssured.baseURI = BASE_URL;
        RequestSpecification httpRequest = RestAssured.given();
        CreateUser createUser = new CreateUser("morpheus", "leader");
        //add a header stating the request body is a JSON
        httpRequest.header("Content-Type", "application/json");
        Response response = httpRequest.body(createUser).when().post(PostRoute.CreateUser());
        return response;
    }
    public static Response registerSuccessful() {
        PrintStream log;
        try {
            log = new PrintStream(new FileOutputStream("logging.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        RestAssured.baseURI = BASE_URL;
        //logging request and response to a txt file
        RequestSpecification httpRequest = RestAssured.given().filter(RequestLoggingFilter.logRequestTo(log)).filter(ResponseLoggingFilter.logResponseTo(log));
        RegisterSuccessful rs=new RegisterSuccessful("eve.holt@reqres.in","pistol");
        httpRequest.header("Content-Type", "application/json");
        Response response = httpRequest.body(rs).when().post(PostRoute.Register());
        return response;
    }
    public static Response registerUnsuccessful(){
        RestAssured.baseURI = BASE_URL;
        RequestSpecification httpRequest = RestAssured.given();
        RegisterUnsuccessfull ru=new RegisterUnsuccessfull("sydney@fife");
        httpRequest.header("Content-Type", "application/json");
        Response response = httpRequest.body(ru).when().post(PostRoute.Register());
        return response;
    }
    public static Response loginSuccessful(){
        RestAssured.baseURI = BASE_URL;
        RequestSpecification httpRequest = RestAssured.given();
        LoginSuccessful ls=new LoginSuccessful("eve.holt@reqres.in","cityslicka");
        httpRequest.header("Content-Type", "application/json");
        Response response = httpRequest.body(ls).when().post(PostRoute.Login());
        return response;
    }
    public static Response loginUnsuccessful(){
        RestAssured.baseURI = BASE_URL;
        RequestSpecification httpRequest = RestAssured.given();
        LoginUnsuccessful lu=new LoginUnsuccessful("peter@klaven");
        httpRequest.header("Content-Type", "application/json");
        Response response = httpRequest.body(lu).when().post(PostRoute.Login());
        return response;
    }
}
