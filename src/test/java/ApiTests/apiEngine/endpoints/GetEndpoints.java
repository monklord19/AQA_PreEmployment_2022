package ApiTests.apiEngine.endpoints;

import ApiTests.apiEngine.Routes.GetRoute;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetEndpoints {
    private static final String BASE_URL="https://reqres.in/";
    public static Response getUsersList(){
        RestAssured.baseURI =BASE_URL;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.when().get(GetRoute.UsersList());
       return response;
    }
    public static Response getSingleUser(){
        RestAssured.baseURI =BASE_URL;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.when().get(GetRoute.SingleUser());
        return response;
    }
    public static Response getSingleUserNotFound(){
        RestAssured.baseURI =BASE_URL;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.when().get(GetRoute.SingleUserNotFound());
        return response;
    }
    public static Response getListResource(){
        RestAssured.baseURI =BASE_URL;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.when().get(GetRoute.ListResource());
        return response;
    }
    public static Response getSingleResource(){
        RestAssured.baseURI =BASE_URL;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.when().get(GetRoute.SingleResource());
        return response;
    }
    public static Response getSingleResourceNotFound(){
        RestAssured.baseURI =BASE_URL;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.when().get(GetRoute.SingleResourceNotFound());
        return response;
    }
    public static Response getDelayedResponse(){
        RestAssured.baseURI =BASE_URL;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.when().get(GetRoute.DelayedResponse());
        return response;
    }

}
