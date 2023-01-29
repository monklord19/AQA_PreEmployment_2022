package ApiTests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.IOUtils;
import org.json.JSONTokener;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MethodsFlow {
    public void getStatus() {

        int status = given().when().get("https://reqres.in").getStatusCode();
        if (status == 200 || status == 201) {
            System.out.println("Status is " + status + " OK");
            Assert.assertTrue(true);

        }else if (status == 204) {
            System.out.println("Success status but no content" + status);
            Assert.assertTrue(true);

        }else if (status == 400 || status == 401 || status == 403 || status == 404) {
            System.out.println("Status is" + status + "invalid request to go through");
            Assert.assertTrue(true);
        }else {
            System.out.println("Unknown request");
        }

    }


    public void getResponseTime() {
        long startTime = System.nanoTime();
        Response response = RestAssured.get("https://reqres.in");
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        if (duration < 300) {
            System.out.println("Response time " + duration + " ms");
            Assert.assertEquals(200, response.getStatusCode());
        } else{

            System.out.println("Invalid response to go through");

        }
    }
    public void RegistrationSuccessful() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("UserName", "test123@gmail.com");
        requestParams.put("Password", "passwordtest123");

        request.body(requestParams.toJSONString());
        Response response = request.post("/api/users?page=2");
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    public void userIdentity() {
        given().get("https://reqres.in/api/users/7").then().body("data.id", equalTo(7)).log().all();
    }
    public void Users() {
        given().get("https://reqres.in/api/users?page=2").then().body("data.id[1]", equalTo(8)).log().all();
    }
    //POST METHOD using jsonOBJECT
    public void createUser(){
        JSONObject json = new JSONObject();
        int randomID = new Random().nextInt(1000);
        json.put("id",randomID);
        json.put("name","myName" + randomID);
        json.put("job","job" + randomID);

        RestAssured.baseURI = "https://reqres.in";
        given()
                .header("Content-Type","application/json")
                .and()
                .body(json.toJSONString())
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .and()
                .log().all();


    }
    //POST METHOD using Java Class Object

    public void createUser0(){
        int randomID = new Random().nextInt(1000);

        JsonInputData jsonInputData = new JsonInputData(randomID +"name" + randomID, "job" + randomID);


        RestAssured.baseURI = "https://reqres.in";
         given()
                .header("Content-Type","application/json")
                .and()
                .body(jsonInputData)
            .when()
                .post("/api/users")
            .then()
                .statusCode(201)
                .and()
                .log().all();

    }
    //POST METHOD using String
    public void createUser1(){

        RestAssured.baseURI = "https://reqres.in";
       Response response =  given()
                .header("Content-Type","application/json")
                .and()
                .body("{" +
                        "\"name\": \"morpheus\", " +
                "\"job\": \"leader\" " +
                "}")
            .when()
                .post("/api/users")
            .then()
                .statusCode(201)
                .and()
                .log().all()
               .extract().response();
        JsonPath jsonPath = new JsonPath(response.asString());
        System.out.println(jsonPath);

    }
    //POST METHOD using Json file
    public void createUser2() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(new File("src/main/resources/API-JSON/CreateUser.json"));

        RestAssured.baseURI = "https://reqres.in";
        given()
                .header("Content-Type","application/json")
                .and()
                .body(IOUtils.toString(fileInputStream,"UTF-8"))
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .and()
                .log().all();


    }
    public void updateUsers(){
        JSONObject request = new JSONObject();
        request.put("name", "Pitiriciu");
        request.put("job", "AQA");
        System.out.println(JSONObject.toJSONString(request));
        given().body(request.toJSONString()).when().put("https://reqres.in/api/users/2");
    }
    public void updateUser(){
        JSONObject request = new JSONObject();
        request.put("name", "Pitiriciu");
        request.put("job", "AQA");
        System.out.println(JSONObject.toJSONString(request));
        given().body(request.toJSONString()).when().patch("https://reqres.in/api/users/2");
    }
    public void deleteUser(){
        String endPoint = "https://reqres.in/api/users/2";
        given().when().delete(endPoint).then().log().body();
        System.out.println("USER DELETED");
    }


}
