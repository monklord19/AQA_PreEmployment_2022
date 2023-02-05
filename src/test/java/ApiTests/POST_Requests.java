package ApiTests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.binary.Base64;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;

public class POST_Requests {

    @Test
    public void AddUser(){
        RestAssured.baseURI = "https://demoqa.com/";
        File fileBody=new File("src/test/java/Util/PayloadUser.json");

        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type","application/json");
        Response response =httpRequest.body(fileBody).post("Account/v1/User");
        int statusCode = response.getStatusCode();
        System.out.println("Status is" +statusCode);
    }
    @Test
    public void AddBookWithBearerToken(){
        RestAssured.baseURI = "https://demoqa.com/";
        RequestSpecification request = RestAssured.given();
        String credentials ="""
                             {
                             "userName": "AndreeaCazan3",
                             "password": "Mimi234!"
                             }
                             """;
        request.header("Content-Type","application/json");

        Response responseFromToken =request.body(credentials).post("Account/v1/GenerateToken");
        responseFromToken.prettyPrint();

        String jsonString = responseFromToken.getBody().asString();
        String tokenGenerated = JsonPath.from(jsonString).get("token");

        request.header("Authorization","Bearer "+tokenGenerated)
                .header("Content-Type","application/json");

        String addBookDetails= """
                {
                  "userId": "05ba2493-9d31-4b35-8b79-32899aabdd4c",
                  "collectionOfIsbns": [
                    {
                      "isbn": "9781593275846"
                    }
                  ]
                }
                """;

        Response addBookResponse= request.body(addBookDetails).post("BookStore/v1/Books");
        System.out.println("Status code is"+addBookResponse.getStatusCode());
        Assertions.assertEquals(201,addBookResponse.getStatusCode());
        addBookResponse.prettyPrint();


    }
    @Test
    public void POSTBookWhithBasicAuthentification(){
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1";
        RequestSpecification request = RestAssured.given();
        String credentials ="AndreeaCazan3:Mimi234!";

        byte[] encodedCredentials = Base64.encodeBase64(credentials.getBytes());
        String encodedCredentialsasString = new String(encodedCredentials);

        request.header("Authorization","Basic "+encodedCredentialsasString);
        String load= """
                {
                  "userId": "05ba2493-9d31-4b35-8b79-32899aabdd4c",
                  "collectionOfIsbns": [
                    {
                      "isbn": "9781491904244"
                    }
                  ]
                }
                """;
        request.header("Content-Type","application/json");
        Response response= request.body(load).post("Books");
        System.out.println("Status code is"+response.getStatusCode());
        response.prettyPrint();


    }

}
