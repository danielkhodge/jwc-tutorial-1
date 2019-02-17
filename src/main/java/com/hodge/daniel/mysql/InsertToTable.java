package com.hodge.daniel.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertToTable {
    public static void main(String[] args) {
        try {
            Class.forName("com.hodge.daniel.mysql");
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.134:3306/dan", "root", "Dkenneth1!");
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("INSERT into HELLO (ID, age, firstname, lastname) VALUES (3, 10, 'Arnold', 'Smith')");
            if (i < 1) {
                System.err.println("Failed. 0 updates");
            }
            else{
                System.out.println("Success");
            }

        }
        catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();

            if (ex instanceof SQLException) {
                int errorCode = ((SQLException) ex).getErrorCode();
                System.err.println("Sql Error Code: " + errorCode);
            }

        }
    }
}
