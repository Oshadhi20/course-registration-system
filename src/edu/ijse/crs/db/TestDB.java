package edu.ijse.crs.db;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDB {
     public static void main(String[] args) {
        try {
            Connection connection = DBConnection.getConnection();
            if (connection != null) {
                System.out.println("Database Connected Successfully!");
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
