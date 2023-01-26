package ApiTests;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FirstApiTest {
    @Test
    public void getEmployees() {
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/employees";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");
        Headers allHeaders = response.headers();
        for (Header header : allHeaders) {
            System.out.println("key" + header.getName() + "Value" + header.getValue());
        }


    }
    @Test
    public void getSpecificEmployee(){
        String endPoint = "https://dummy.restapiexample.com/api/v1/employee/1";
       var Employee =  given().when().get(endPoint).then().assertThat().body("status",equalTo("success")).body("data.id",equalTo(1));
       Employee.log().body();
    }

    @Test
    public void createEmployees() {
        String endPoint = "https://dummy.restapiexample.com/api/v1/create";
        String body = """
                {
                    "status": "success",
                    "data": {
                        "name": "test123",
                        "salary": "999",
                        "age": "24",
                        "id": 9551
                    }
                }
                                """;
        var response = given().body(body).when().post(endPoint).then().log().body();
        response.assertThat().body("status", equalTo("success"));
    }
    @Test
    public void updateEmployees() {
        String endpoint = "https://dummy.restapiexample.com/api/v1/update/21";
        String body = """	
                {
                    "status": "success",
                    "data": {
                        "name": "test123",
                        "salary": "999",
                        "age": "24",
                        "id": 9551
                    }
                }
                                """;
        var update = given().body(body).when().put(endpoint).then().log().body();
        update.assertThat().body("status", equalTo("success"));
    }

    @Test
    public void putRequest(){

        //update title in body
        String b = "{" + " \"title\": \"RestApiExample\"}";
        //base URL
        RestAssured.baseURI = "https://dummy.restapiexample.com/";
        given().header("Content-type", "application/json")
                //adding put method
                .body(b).when().put("/public/api/v1/update/21").then().log().all()
                //verify status code as 200
                .assertThat().statusCode(200);

    }

    @Test
    public void deteleEmployee(){
        String endPoint = "https://dummy.restapiexample.com/public/api/v1/delete/2";
        given().when().delete(endPoint).then().log().body();
    }
}
