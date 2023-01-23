package ApiTests;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class FirstApiTestsMadalina {
   @Test
    public void getEmployees(){
       RestAssured.baseURI="https://dummy.restapiexample.com/api/v1/employees";
       RequestSpecification httpRequest=RestAssured.given();
       Response response=httpRequest.get("");
       Headers allHeaders=response.headers();
       for(Header header:allHeaders){
           System.out.println("Key:"+header.getName()+"Value"+header.getValue());
       }
    }
    @Test
    public void getSpecificEmployee(){
       String endpoint="https://dummy.restapiexample.com/api/v1/employee/1";
       var abc=given().when().get(endpoint).then().assertThat().body("status",equalTo("success")).body("data.id",equalTo(1));
abc.log().body();
    }
    @Test
    public void addEmployee(){
       String endp="https://dummy.restapiexample.com/api/v1/create";
       String body= """
               {
               "name":"test",
               "salary":"123",
               "age":"23"
               }
               """;
       var response=given().body(body).when().post(endp).then().log().body();
       response.assertThat().body("status",equalTo("success"));
    }
    @Test
    public void updateEmployee(){
       String endp="https://dummy.restapiexample.com/public/api/v1/update/21";
       String body= """
               {
               "name":"test",
               "salary":"123",
               "age":"23"
               }
               """;
       var response=given().body(body).when().put(endp).then().log().body();
       response.assertThat().body("status",equalTo("success"));
       response.assertThat().body("message",equalTo("Successfully! Record has been updated."));
    }
    @Test
    public void deleteEmployee(){
       String endpoint="https://dummy.restapiexample.com/public/api/v1/delete/2";
        given().when().delete(endpoint).then().log().body();
    }
}
