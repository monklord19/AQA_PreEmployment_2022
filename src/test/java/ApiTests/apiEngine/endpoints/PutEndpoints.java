package ApiTests.apiEngine.endpoints;

import ApiTests.apiEngine.Routes.PutRoute;
import ApiTests.model.Requests.UpdateUser;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutEndpoints {
    private static final String BASE_URL="https://reqres.in/";
    public static Response update(){
        RestAssured.baseURI = BASE_URL;
        RequestSpecification httpRequest = RestAssured.given();
        UpdateUser updateUser=new UpdateUser("morpheus","zion resident");
        httpRequest.header("Content-Type", "application/json");
        Response response = httpRequest.body(updateUser).when().put(PutRoute.Update());
       return response;
    }
}
