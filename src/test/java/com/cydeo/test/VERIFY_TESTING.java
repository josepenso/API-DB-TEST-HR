package com.cydeo.test;

import com.cydeo.pojos.Employee;
import com.cydeo.testbase.TestBaseHR;
import com.cydeo.utility.DB_Util;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import  static org.hamcrest.MatcherAssert.*;

public class VERIFY_TESTING  extends TestBaseHR {
    private    String endPoint;
    private    int actualStatusCode;
    private Response response;
    private  String contentType;
    private JsonPath jsonPath;
    private String id="/{id}";




    @Test
    public void test1(){
        /*

        verify employee_id 100
        first_name is "Steven"
         given accept content Type.Json
        when query id 1000/{id}
        when get employees/
        verify status code is OK
        verify content type is application/json


         */

        //API TESTING
       endPoint="employees";
       jsonPath= given().accept(ContentType.JSON)
               .when().queryParam("q","{\"employee_id\":100}")
               .when().get(endPoint)
               .then().assertThat()
               .statusCode(HttpStatus.SC_OK)
               .and().contentType(ContentType.JSON.toString()).extract().jsonPath();
        Employee employee1API=jsonPath.getObject("items[0]", Employee.class);

        //verify employee_id is 100 API response
        assertThat(employee1API.getEmployeeId(),is("100"));

       //DB TESTING
        DB_Util.runQuery("select employee_id,first_name,last_name,salary from employees where employee_id = 100");
        List<String>employee1DB=DB_Util.getRowDataAsList(1);

        //verify employee_id is 100
        assertThat(employee1DB.get(0),is("100"));



        //verify employee_id from DB is equals to employee_id from API response
        assertThat(employee1DB.get(0),is(employee1API.getEmployeeId()));

        //verify employee_name is "Steven" API against DB

        assertThat(employee1API.getFirstName(),is(employee1DB.get(1)));

        System.out.println(employee1API+ "DATA FROM HTTP response");
        System.out.println(employee1DB+ "DATA FROM DATABASE");


    }

}
