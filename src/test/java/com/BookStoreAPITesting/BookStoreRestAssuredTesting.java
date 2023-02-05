package com.BookStoreAPITesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class BookStoreRestAssuredTesting {

//BookStore - Method No.1 - GET
    @Test
    public void GetBooksDetails() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";

        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();
        // specify the method type (GET) and the parameters if any.
        //In this case the request does not take any parameters

        Response response = httpRequest.request(Method.GET, "");

        // Print the status and message body of the response received from the server
        System.out.println("Response=>" + response.prettyPrint());

        // Get the status code of the request.
        //If request is successful, status code will be 200
        int statusCode = response.getStatusCode();

        // Assert that correct status code is returned.
        Assert.assertEquals(200, statusCode);

        // Get the status line from the Response in a variable called statusLine
        String statusLine = response.getStatusLine();
        Assert.assertEquals("HTTP/1.1 200 OK",statusLine);

        // Access header with a given name.
        String contentType = response.header("Content-Type");
        System.out.println("Content-Type value: " + contentType);
        Assert.assertEquals(contentType /* actual value */, "application/json; charset=utf-8" /* expected value */);

        // Access header with a given name.
        String serverType = response.header("Server");
        System.out.println("Server value: " + serverType);
        Assert.assertEquals(serverType /* actual value */, "nginx/1.17.10 (Ubuntu)" /* expected value */);

        // Access header with a given name. Header = Content-Encoding
        String acceptLanguage = response.header("Content-Encoding");
        System.out.println("Content-Encoding: " + acceptLanguage);
    }


//BookStore - Method No.4 - GET

    @Test
    public void queryParameter() {
        //Defining the base URI
        RestAssured.baseURI= "https://bookstore.toolsqa.com/BookStore/v1";
        RequestSpecification httpRequest = RestAssured.given();
        //Passing the resource details
        Response res = httpRequest.queryParam("ISBN","9781449365035").get("/Book");
        //Retrieving the response body using getBody() method
        ResponseBody body = res.body();
        //Converting the response body to string object
        String rbdy = body.asString();
        //Creating object of JsonPath and passing the string response body as parameter
        JsonPath jpath = new JsonPath(rbdy);
        //Storing publisher name in a string variable
        String title = jpath.getString("title");
        System.out.println("The book title is - "+title);
    }


//ACCOUNT - Method No.1 - POST

    @Test
    public void UserRegistrationSuccessful()
    {
        RestAssured.baseURI ="https://demoqa.com/Account/v1";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("userName", "test test");
        requestParams.put("password", "Testtttrest@123");
        request.body(requestParams.toJSONString());
        Response response = request.post("/User");
        ResponseBody body = response.getBody();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());

    }

//BooksStore - Method No.2 - POST

    @Test
    public void PostNewUser()
    {
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification request = RestAssured.given();

        // JSONObject is a class that represents a Simple JSON.
        // We can add Key - Value pairs using the put method
        JSONObject requestParams = new JSONObject();
        requestParams.put("userId", "TQ123");
        requestParams.put("isbn", "9781449325862");

        // Add a header stating the Request body is a JSON
        request.header("Content-Type", "application/json"); // Add the Json to the body of the request
        request.body(requestParams.toJSONString()); // Post the request and check the response

        Response response = request.post("/BookStoreV1BooksPost");
        System.out.println("The status received: " + response.statusLine());
    }

//BooksStore - Method No.3 - DELETE
    @Test
    public void DeleteBook() {
        //Defining the base URI
        RestAssured.baseURI= "https://bookstore.toolsqa.com/BookStore/v1";
        RequestSpecification httpRequest = RestAssured.given();
        //Passing the resource details
        Response res = httpRequest.queryParam("ISBN","9781449365035").get("/Book");
        //Retrieving the response body using getBody() method
        ResponseBody body = res.body();
        //Converting the response body to string object
        String rbdy = body.asString();
        //Creating object of JsonPath and passing the string response body as parameter
        JsonPath jpath = new JsonPath(rbdy);
        //Storing publisher name in a string variable
        String title = jpath.getString("title");
        System.out.println("The book title is - "+title);
    }
}
