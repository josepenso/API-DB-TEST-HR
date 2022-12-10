package com.cydeo.testbase;

import com.cydeo.utility.DB_Util;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.baseURI;

public class TestBaseHR {
    String url="http://3.83.178.177:1000/ords/hr/";
    String urlHr="jdbc:oracle:thin:@3.83.178.177:1521:XE";
    String username="hr";
    String password="hr";

    @BeforeClass
    public void setUpClass(){
        baseURI=url;

        DB_Util.createConnection(urlHr,username,password);



    }

    @AfterClass
    public void teardown(){
        DB_Util.destroy();
    }





}

