package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;

public class DataUtil extends BaseClass{

    @DataProvider
    public Object[][] dataProvider() {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject;

        //Read JSONFile

        Object obj = null;
        try {
            obj = parser.parse(new FileReader("src/main/resources/StaticVariables.json"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();

        }

        jsonObject = (JSONObject) obj;

        //extract array data from JSONobject

        assert jsonObject != null;
        JSONArray formInfo = (JSONArray) jsonObject.get("form info");

        //String array to store JSONArray data
        String[] dataArray = new String[formInfo.size()];

        //JSONObject to read each JSONarray object

        JSONObject formInfoData;
        String website, username, password;

        //Get data from JSONarray and tore in String array

        for (int i = 0; i<formInfo.size(); i++){
            formInfoData = (JSONObject) formInfo.get(i);
        website = (String) formInfoData.get("https://open.spotify.com/");
        username = (String) formInfoData.get("test123");
        password = (String) formInfoData.get("password123");

        dataArray[i] = website + "," + username + "," + password;

    }
        return new String[][]{dataArray};

}

}
