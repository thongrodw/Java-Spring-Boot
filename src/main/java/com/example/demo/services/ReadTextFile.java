package com.example.demo.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class ReadTextFile {
    public static void main(String[] args) {

        Connection connect = null;
        Statement s = null;

        //SQL Connect
        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
            connect =  DriverManager.getConnection("jdbc:oracle:thin:@10.62.38.222:1521/xepdb1","awdpowner","awd");
            s = connect.createStatement();

            //Query
            String sql = "select * from WR4u999s where screen_data like '%revisable%' ";

            ResultSet rec = s.executeQuery(sql);

            System.out.println(rec);

            s.close();
            connect.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
