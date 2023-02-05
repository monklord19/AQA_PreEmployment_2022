package ApiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PUT_request {
    @Test
    public void updateBook(){

        RestAssured.baseURI = "https://demoqa.com";
        RequestSpecification request = RestAssured.given();
        request.header("Authorization","Basic QW5kcmVlYUNhemFuOk1pbWlAQDIzNA==")
                .header("Content-Type","application/json");
        String replacementBody= """
                {
                  "userId": "05ba2493-9d31-4b35-8b79-32899aabdd4c",
                  "isbn": "9781593275846"
                }
                """;
        Response replaceBookResponse= request.body(replacementBody)
                .put("/BookStore/v1/Books/9781491950296");
        Assertions.assertEquals(200,replaceBookResponse.getStatusCode());
        replaceBookResponse.prettyPrint();
    }

}
