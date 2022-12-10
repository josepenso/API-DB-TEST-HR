package com.cydeo.test;





import com.cydeo.testbase.TestBaseHR;
import com.cydeo.utility.DB_Util;

import org.testng.annotations.Test;

import java.sql.*;


public class DB_TEST   extends TestBaseHR {
    String dbUrl="jdbc:oracle:thin:@3.83.178.177:1521:XE";
    String dbUsername="hr";
    String dbPassword="hr";
    Connection conn;
    Statement statement;

    ResultSet result;

    @Test
    public void test1() throws SQLException {

   DB_Util.createConnection(dbUrl,dbUsername,dbPassword);

        result= statement.executeQuery("select * DEPARTMENTS where MANAGER_ID is not null");


        while (result.next()){
            System.out.println(result.getString(1)+ result.getString(2)+result.getString(3));
        }


    }



    @Test
    public void test2(){

        DB_Util.runQuery("select FIRST_NAME\n" +
                "from Employees");

        System.out.println(DB_Util.getRowDataAsList(1).get(0));


    }







}
