package com.example.demo.services;

import java.sql.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class SQLDatabaseConnection {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) {

        Connection connect = null;
        Statement s = null;

        //SQL Connect
        try {
            Class.forName("com.microsoft.sqlserver.jbdc.SQLServerDriver");
            connect =  DriverManager.getConnection("jdbc:oracle:thin:@10.62.38.222:1521/xepdb1;user=awdpowner;password=awd");

            s = connect.createStatement();

            //Query
            String sql = "select * from WR4u999s where screen_data like '%revisable%' ";

            ResultSet rec = s.executeQuery(sql);

            System.out.println(rec);


        } catch (Exception e){
            e.printStackTrace();
        }

        //Close Connection
        try {
            s.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}