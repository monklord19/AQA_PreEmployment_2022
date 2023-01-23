package ApiTests.apiEngine.endpoints;

import ApiTests.apiEngine.Routes.DeleteRoute;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteEndpoints {
    private static final String BASE_URL="https://reqres.in/";
    public static Response deleteUser(){
        RestAssured.baseURI =BASE_URL;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.when().delete(DeleteRoute.Delete());
        return response;
    }
}
