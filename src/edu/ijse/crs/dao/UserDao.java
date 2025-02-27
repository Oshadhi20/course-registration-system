/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.crs.dao;

import edu.ijse.crs.db.DBConnection;
import edu.ijse.crs.util.PasswordUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */

public class UserDao{
    public boolean validateUser(String username, String password) {
        String sql = "SELECT password_hash FROM Users WHERE username = ?";
         try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, username);               
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedHashedPassword = rs.getString("password_hash"); 
                String enteredHashedPassword = PasswordUtil.hashPassword(password); 

                if (storedHashedPassword.equals(enteredHashedPassword)) {
                    System.out.println("User authenticated: " + username);
                    return true;
                } else {
                    System.out.println("Invalid password for user: " + username);
                }
            } else {
                System.out.println("User not found: " + username);
            }

        } catch (SQLException e) {
            System.err.println("SQL Error in validateUser: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public void testDBConnection() {
        try (Connection connection = DBConnection.getConnection()) {
            if (connection != null) {
                System.out.println("Database Connected Successfully!");
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        userDao.testDBConnection();
    }
}    