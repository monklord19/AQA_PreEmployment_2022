package ApiTests.steps;

import ApiTests.apiEngine.endpoints.PostEndpoints;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.junit.Test;


public class ReqresPOST {
    @Test
    public void createUser() {
        Response createUserResponse = PostEndpoints.createUser();
        String body = createUserResponse.asPrettyString();
        System.out.println(body);
        ValidatableResponse vr;
        vr = createUserResponse.then();
        vr.statusCode(Matchers.equalTo(201));
        vr.time(Matchers.lessThanOrEqualTo((long) 2000));
        vr.header("Content-Type", Matchers.containsString("application/json; charset=utf-8"));
    }
    @Test
    public void registerSuccessful(){
        Response registerUserResponse = PostEndpoints.registerSuccessful();
        String body = registerUserResponse.asPrettyString();
        System.out.println(body);
        ValidatableResponse vr;
        vr = registerUserResponse.then();
        vr.statusCode(Matchers.equalTo(200));
        vr.time(Matchers.lessThanOrEqualTo((long) 2000));
        vr.header("Content-Type", Matchers.containsString("application/json; charset=utf-8"));
    }
    @Test
    public void registerUnsuccessful(){
        Response registerUserResponse = PostEndpoints.registerUnsuccessful();
        String body = registerUserResponse.asPrettyString();
        System.out.println(body);
        ValidatableResponse vr;
        vr = registerUserResponse.then();
        vr.statusCode(Matchers.equalTo(400));
        vr.time(Matchers.lessThanOrEqualTo((long) 2000));
        vr.header("Content-Type", Matchers.containsString("application/json; charset=utf-8"));
    }
    @Test
    public void loginSuccessful(){
        Response registerUserResponse = PostEndpoints.loginSuccessful();
        String body = registerUserResponse.asPrettyString();
        System.out.println(body);
        ValidatableResponse vr;
        vr = registerUserResponse.then();
        vr.statusCode(Matchers.equalTo(200));
        vr.time(Matchers.lessThanOrEqualTo((long) 2000));
        vr.header("Content-Type", Matchers.containsString("application/json; charset=utf-8"));
    }
    @Test
    public void loginUnsuccessful(){
        Response registerUserResponse = PostEndpoints.loginUnsuccessful();
        String body = registerUserResponse.asPrettyString();
        System.out.println(body);
        ValidatableResponse vr;
        vr = registerUserResponse.then();
        vr.statusCode(Matchers.equalTo(400));
        vr.time(Matchers.lessThanOrEqualTo((long) 2000));
        vr.header("Content-Type", Matchers.containsString("application/json; charset=utf-8"));
    }
}
