package ApiTests;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;


public class FirstApiTests {

    @Test
    public void getEmpolyees(){
        RestAssured.baseURI  = "http://dummy.restapiexample.com/employees";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");
        Headers allHeaders = response.headers();
        for (Header header : allHeaders){
            System.out.println("Key:" + header.getName() + "Value" + header.getValue());
        }
        //given().when().get(endpoint).then().log().body();
    }

    @Test
    public void getSpecificEmployee(){
        String endpoint = "http://dummy.restapiexample.com/employee/719";
        var asd = given().when().get(endpoint).then().assertThat().body("status", equalTo("success"))
                .body("data.id", equalTo(1));
        asd.log().body();
    }

    @Test
    public void addEmployee(){
        String endpoint = "https://dummy.restapiexample.com/api/v1/create";
        String body = """
                {
                "name":"test",
                "salary":"123",
                "age":"23"
                }
                """;

        var response = given().body(body).when().post(endpoint).then().log().body();
        response.assertThat().body("status", equalTo("success"));
    }

    @Test
    public void addEmployee2(){
        String endpoint = "https://dummy.restapiexample.com/public/api/v1/update/21";
        String body = """
                 {
                "name":"test",
                "salary":"123",
                "age":"23"
                }
                """;

        var resp = given().body(body).when().put(endpoint).then().log().body();
        resp.assertThat().body("status", equalTo("success"));
    }

    @Test
    public void deleteEmplyee(){
        String endpoint ="http://dummy.restapiexample.com/delete/4118";
        given().when().delete(endpoint).then().log().body();
    }


}
