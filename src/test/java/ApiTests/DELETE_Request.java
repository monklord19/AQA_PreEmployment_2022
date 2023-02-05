package ApiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class DELETE_Request {
    @Test
    public void deleteBookfromUser(){

        RestAssured.baseURI = "https://demoqa.com";
        RequestSpecification request = RestAssured.given();

        String removeBook= """
                {
                  "userId": "05ba2493-9d31-4b35-8b79-32899aabdd4c",
                  "isbn": "9781593275846"
                }
                """;

        request.header("Authorization","Basic QW5kcmVlYUNhemFuOk1pbWlAQDIzNA==")
                .header("Content-Type","application/json");

        Response response= request.body(removeBook)
                .delete("/BookStore/v1/Book");
        System.out.println(response.getStatusCode());
        Assertions.assertEquals(204,response.getStatusCode());
        response.prettyPrint();
    }
}
