package ApiTests.steps;

import ApiTests.apiEngine.endpoints.PutEndpoints;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.junit.Test;

public class ReqresPATCH {
    @Test
    public void updateUser(){
        Response resp= PutEndpoints.update();
        String body=resp.asPrettyString();
        System.out.println(body);
        ValidatableResponse vr;
        vr = resp.then();
        vr.statusCode(Matchers.equalTo(200));
        vr.time(Matchers.lessThanOrEqualTo((long) 2000));
        vr.header("Content-Type",Matchers.containsString("application/json; charset=utf-8"));
        vr.body("name",Matchers.equalTo("morpheus"));
    }
}
