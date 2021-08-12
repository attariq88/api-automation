package com.pnt.restapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class TestRestEndpoints {

    private String baseURI = RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/";

    private String employeesEndpoint = "employees";
    private String employeeEndpoint = "employee/3";
    private String createEmployee = "create";
    private String updateEmployee = "update/5";
    private String deleteEmployee = "delete/5";


    @Test
    public void getAllEmployees(){
        Response response = RestAssured.given().when().get(employeesEndpoint).then().assertThat().statusCode(200).extract().response();

        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
    }

    @Test
    public void getIndividualEmployee(){
        Response response = RestAssured.given().when().get(employeeEndpoint).then().assertThat().statusCode(200).extract().response();

        System.out.println(response.asString());
        System.out.println(response.getStatusCode());

    }

    @Test
    public void createAnEmployee(){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","pnt");
        jsonObject.put("salary","10000");
        jsonObject.put("age","30");

        Response response = RestAssured.given().body(jsonObject.toString()).contentType(ContentType.JSON).when().post(createEmployee).then().assertThat().statusCode(200).extract().response();

        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
    }

    @Test
    public void updateEmployee(){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("salary","300000");

        Response response = RestAssured.given().body(jsonObject.toString()).contentType(ContentType.JSON).when().put(updateEmployee).then().assertThat().statusCode(200).extract().response();

        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
    }

    @Test
    public void deleteEmployee(){

        Response response = RestAssured.given().when().delete(deleteEmployee).then().assertThat().statusCode(200).extract().response();

        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
    }
}
