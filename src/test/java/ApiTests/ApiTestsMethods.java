package ApiTests;

import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


public class ApiTestsMethods extends ReqResApiFlow {

    @Before
    @Test
    public void testResponseTime(){
        getStatus();
        getResponseTime();
    }
    @After
    public void testResponseTimeAfterExecution(){
        getStatus();
        getResponseTime();

    }
    @Test public void readJsonFile() throws IOException, ParseException {
        getJsonFile();

    }
    @Test
    public void UsersInfo() {
        getUserInfo();
    }
    @Test
    public void UserCalls(){
        Users();

    }
    @Test
    public void UserCallsIdentity(){
        userIdentity();

    }

    @Test
    public void UserCrafting(){
        craftEmployee();


    }
    @Test
    public void UserCallsUpdate(){
        updateEmployees();
        updateEmployee();
    }

    @Test
    public void DeleteEmployees(){
        deteleEmployee();
    }




}
