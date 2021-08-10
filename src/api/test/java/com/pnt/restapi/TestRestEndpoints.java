package com.pnt.restapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TestRestEndpoints {

    private String baseURI = RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/";

    private String employeesEndpoint = "employees";

    @Test
    public void getAllEmployees(){
        Response response = RestAssured.given().when().get(employeesEndpoint).then().assertThat().statusCode(200).extract().response();

        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
    }

    @Test
    public void getIndividualEmployee(){

    }
}
