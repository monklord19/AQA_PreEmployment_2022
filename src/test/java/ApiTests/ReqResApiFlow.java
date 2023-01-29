package ApiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

import java.io.*;
import java.util.ArrayList;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ReqResApiFlow {

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


    public void getJsonFile() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/main/resources/API-JSON/ListUsers.json");
        Object obj = jsonParser.parse(reader);
        JSONObject empjsonobj = (JSONObject) obj;
        String page =  (String.valueOf(empjsonobj.get("page")));
        String perPage =  (String.valueOf(empjsonobj.get("per_page")));
        String total =  (String.valueOf(empjsonobj.get("total")));
        String totalPages =  (String.valueOf(empjsonobj.get("total_pages")));


        System.out.println("Page " + page);
        System.out.println("Per_Page " +perPage);
        System.out.println("Total " +total);
        System.out.println("Total_Pages " +totalPages);

        JSONArray array = (JSONArray)empjsonobj.get("data");

        for (int i=0;i<array.size();i++)
        {
            JSONObject data = (JSONObject) array.get(i);

            String id=(String.valueOf(data.get("id")));
            String email=(String.valueOf(data.get("email")));
            String first_name =(String.valueOf(data.get("first_name")));
            String last_name =(String.valueOf(data.get("last_name")));
            String avatar=(String.valueOf(data.get("avatar")));

            System.out.println("Data of " +i + "is....");
            System.out.println("Id " + id);
            System.out.println("email " + email);
            System.out.println("first_name " + first_name);
            System.out.println("last_name " + last_name);
            System.out.println("avatar " + avatar);


        }

    }
    public void getUserInfo(){
        baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users?page=2";

        Response response = given().contentType(ContentType.JSON).log().all()
                .get("/7");
        response.prettyPrint();

        JsonPath extractor = response.jsonPath();
        String firstName = extractor.get("first_name");
        String lastName = extractor.get("last_name");
        String id = extractor.get("id");
        String email = extractor.get("email");
        String avatar = extractor.get("avatar");

        ArrayList<String> data = extractor.get("data");

        System.out.println("First name is " + firstName);
        System.out.println("Last name is " + lastName);
        System.out.println("Id is " + id);
        System.out.println("Email adress is " + email);
        System.out.println("Avatar link is " + avatar);

        for (String d : data){
            System.out.println(d);
        }

    }

    public void userIdentity() {
        given().get("https://reqres.in/api/users/7").then().body("data.id", equalTo(7)).log().all();
    }
    public void Users() {
        given().get("https://reqres.in/api/users?page=2").then().body("data.id[1]", equalTo(8)).log().all();
    }

    public void craftEmployee(){
        JSONObject request = new JSONObject();
        request.put("name", "Iulian");
        request.put("job", "AQA");
        System.out.println(JSONObject.toJSONString(request));
        given().body(request.toJSONString()).when().post("https://reqres.in/api/users");

    }

    public void updateEmployees(){
        JSONObject request = new JSONObject();
        request.put("name", "Pitiriciu");
        request.put("job", "AQA");
        System.out.println(JSONObject.toJSONString(request));
        given().body(request.toJSONString()).when().put("https://reqres.in/api/users/2");
    }

    public void updateEmployee(){
        JSONObject request = new JSONObject();
        request.put("name", "Pitiriciu");
        request.put("job", "AQA");
        System.out.println(JSONObject.toJSONString(request));
        given().body(request.toJSONString()).when().patch("https://reqres.in/api/users/2");
    }
    public void deteleEmployee(){
        String endPoint = "https://reqres.in/api/users/2";
        given().when().delete(endPoint).then().log().body();
    }




}


