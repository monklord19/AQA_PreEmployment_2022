package ApiTests.steps;

import ApiTests.apiEngine.endpoints.GetEndpoints;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.junit.Test;

public class ReqresGET {

    @Test
    public void getUsersList() {
        Response getUserList= GetEndpoints.getUsersList();
        String body=getUserList.asPrettyString();
        System.out.println(body);
    //ASSERTS
        ValidatableResponse v = getUserList.then();
        v.statusCode(Matchers.equalTo(200));
        v.statusLine(Matchers.equalTo("HTTP/1.1 200 OK"));
        v.time(Matchers.lessThanOrEqualTo((long) 2000));
        v.body("page",Matchers.equalTo(2));
    }
    @Test
    public void getSingleUser() {
        Response getSingleUser=GetEndpoints.getSingleUser();
        String body=getSingleUser.asPrettyString();
        System.out.println(body);
        ValidatableResponse v = getSingleUser.then();
        v.statusCode(Matchers.equalTo(200));
        v.statusLine(Matchers.equalTo("HTTP/1.1 200 OK"));
        v.time(Matchers.lessThanOrEqualTo((long) 2000));
        v.body("data.email",Matchers.equalTo("janet.weaver@reqres.in"));
    }
    @Test
    public void singleUserNotFound() {
        Response resp=GetEndpoints.getSingleUserNotFound();
        String body=resp.asPrettyString();
        System.out.println(body);
        ValidatableResponse v = resp.then();
        v.statusCode(Matchers.equalTo(404));
        v.time(Matchers.lessThanOrEqualTo((long) 2000));
    }
    @Test
    public void listResource() {
        Response resp=GetEndpoints.getListResource();
        String body=resp.asPrettyString();
        System.out.println(body);
        ValidatableResponse v = resp.then();
        v.statusCode(Matchers.equalTo(200));
        v.time(Matchers.lessThanOrEqualTo((long) 2000));
        v.body("data[3].name",Matchers.equalTo("aqua sky"));
    }
    @Test
    public void singleResource() {
        Response resp=GetEndpoints.getSingleResource();
        String body = resp.asPrettyString();
        System.out.println(body);
        ValidatableResponse v = resp.then();
        v.statusCode(Matchers.equalTo(200));
        v.time(Matchers.lessThanOrEqualTo((long) 2000));
        v.body("data.name",Matchers.equalTo("fuchsia rose"));
    }
    @Test
    public void singleResourceNotFound(){
        Response resp=GetEndpoints.getSingleResourceNotFound();
        String body = resp.asPrettyString();
        System.out.println(body);
        ValidatableResponse v = resp.then();
        v.statusCode(Matchers.equalTo(404));
        v.time(Matchers.lessThanOrEqualTo((long) 2000));
    }
    @Test
    public void delayedResponse(){
        Response resp=GetEndpoints.getDelayedResponse();
        String body=resp.asPrettyString();
        System.out.println(body);
        ValidatableResponse v = resp.then();
        v.statusCode(Matchers.equalTo(200));
        v.time(Matchers.lessThanOrEqualTo((long) 5000));
        v.body("data[2].email",Matchers.equalTo("emma.wong@reqres.in"));
    }


}
