package edu.ijse.crs.dao;

import edu.ijse.crs.db.DBConnection;
import edu.ijse.crs.dto.StudentDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    
    public boolean addStudent(String name, String dob, String program, int year, String contactInfo) {
        String sql = "INSERT INTO Students (name, date_of_birth, program, year, contact_info) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, dob);
            stmt.setString(3, program);
            stmt.setInt(4, year);
            stmt.setString(5, contactInfo);
            
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStudent(int studentId) {
        String sql = "DELETE FROM Students WHERE student_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public StudentDto getStudentById(int studentId) {
        String sql = "SELECT * FROM Students WHERE student_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new StudentDto(
                        rs.getInt("student_id"),
                        rs.getString("name"),
                        rs.getString("date_of_birth"),
                        rs.getString("program"),
                        rs.getInt("year"),
                        rs.getString("contact_info")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getAllStudents() {
        List<String> students = new ArrayList<>();
        String sql = "SELECT name FROM Students";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                students.add(rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }
}

 
