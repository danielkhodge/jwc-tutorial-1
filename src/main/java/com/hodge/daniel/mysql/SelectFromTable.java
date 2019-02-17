package com.hodge.daniel.mysql;

import java.sql.*;

public class SelectFromTable {
    public static void main(String[] args){
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.134:3306/dan", "root", "Dkenneth1!");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM dan.HELLO");
            while (rs.next()) {
                System.out.print(String.format("%1$" + 6 + "s", rs.getInt("ID")));
                System.out.print(String.format("%1$" + 6 + "s", rs.getInt("age")));
                System.out.print(String.format("%1$" + 20 + "s", rs.getString("firstname")));
                System.out.println(String.format("%1$" + 20 + "s", rs.getString("lastname")));
            }
        }
        catch (/*ClassNotFoundException | */SQLException ex) {
            ex.printStackTrace();

            if (ex instanceof SQLException) {
                int errorCode = ((SQLException) ex).getErrorCode();
                System.err.println("Sql Error Code: " + errorCode);
            }
        }
    }
}
