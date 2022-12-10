package com.cydeo.test;

import com.cydeo.testbase.TestBaseHR;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import  static org.hamcrest.MatcherAssert.*;

public class API_GET extends TestBaseHR {

    private    String endPoint;
    private    int actualStatusCode;
    private Response response;
    private  String contentType;
    private JsonPath jsonPath;
    private String id="/{id}";
    private String search;

    @Test
    public void tes1(){

        endPoint="employees/";
        given().accept(ContentType.JSON)
                .when().get(endPoint)
                .then().assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and().contentType(ContentType.JSON.toString());




    }













}
