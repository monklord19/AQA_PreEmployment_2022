package ApiTests;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.groovy.json.internal.Value;
import org.junit.Test;
import org.junit.runner.Request;
import org.openqa.selenium.devtools.v107.fetch.model.AuthChallengeResponse;

import static io.ous.jtoml.impl.Token.TokenType.Key;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class FirstApiTests {

    @Test
    public void getEmployees() {
        String endpoint = "http://dummy.restapiexample.com/employees";
        given().when().get(endpoint).then().log().body();

    }

    @Test
    public void getSpecificEmployee() {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employee/1";
        RequestSpecification httpRequest = given();
        Response response = httpRequest.get("");
        Headers allHeaders = response.headers();
        for (Header header : allHeaders) {
            System.out.println("Key:" + header.getName() + "Value" + header.getValue());
        }
    }

    @Test
    public void addEmployee() {
        String endpoint = "http://dummy.restapiexample.com/api/v1/create";
        String body = """
                {     
                        "name": "test",
                        "salary": "123",
                        "age": "23",
                        "id": 25
                }                 
                """;
        var response = given().body(body).when().post(endpoint).then().log().body();
        response.assertThat().body("message", equalTo("Successfully! Record has been added."));
    }

    @Test
    public void updateEmployee() {
        String endpoint = "https://dummy.restapiexample.com/public/api/v1/update/4118";
        String body = """
                {
                "name": "test",
                "salary": "123",
                "age": "23"
                } 
                """;
        var response = given().body(body).when().post(endpoint).then().log().body();
        response.assertThat().body("status", equalTo("success"));
    }

    @Test
    public void delete() {
        String endpoint = "https://dummy.restapiexample.com/delete/4118";
        given().when().delete(endpoint).then().log().body();




    }
}
