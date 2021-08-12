package com.pnt.restapi;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadJsonFiles {

    public static JSONArray getJsonArray(String filePath) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(filePath));

        return jsonArray;

    }

    public static void main(String[] args) throws IOException, ParseException {
        JSONArray jsonArray = getJsonArray("src/api/test/java/com/pnt/restapi/SingleArray_SingleJson.json");

        JSONObject jsonData = (JSONObject) jsonArray.get(0);

        System.out.println(jsonArray);
        System.out.println(jsonData);
        System.out.println(jsonData.get("id"));
    }
}
