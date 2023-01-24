package ApiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.apache.commons.codec.binary.Base64;


public class Authentication {

    @Test
    public void authenticateUser(){
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1";
        RequestSpecification request = RestAssured.given();
        String credentials ="AndreeaCazan:Mimi@@234";
        byte[] encodedCredentials = Base64.encodeBase64(credentials.getBytes());
        request.header("Authorization","Basic "+encodedCredentials);
        String load= """
                {
                   "userName": "AndreeaCazan",
                   "password": "Mimi@@234"
                 }
                """;
        request.header("Content-Type","application/json");
        Response response= request.body(load).post("Books");
        System.out.println("Status code is"+response.getStatusCode());
        response.prettyPrint();


    }
}
