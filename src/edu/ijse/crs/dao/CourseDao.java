package edu.ijse.crs.dao;

import edu.ijse.crs.db.DBConnection;
import edu.ijse.crs.dto.CourseDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {

    public boolean addCourse(String title, int creditHours, String department, String prerequisites, int maxCapacity) {
        String sql = "INSERT INTO Courses (title, credit_hours, department, prerequisites, max_capacity) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, title);
            stmt.setInt(2, creditHours);
            stmt.setString(3, department);
            stmt.setString(4, prerequisites);
            stmt.setInt(5, maxCapacity);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCourse(int courseId) {
        String sql = "DELETE FROM Courses WHERE course_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, courseId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public CourseDto getCourseById(int courseId) {
        String sql = "SELECT * FROM Courses WHERE course_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, courseId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new CourseDto(
                        rs.getInt("course_id"),
                        rs.getString("title"),
                        rs.getInt("credit_hours"),
                        rs.getString("department"),
                        rs.getString("prerequisites"),
                        rs.getInt("max_capacity")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getAllCourses() {
        List<String> courses = new ArrayList<>();
        String sql = "SELECT title FROM Courses";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                courses.add(rs.getString("title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    public int getCourseIdByName(String name) {
        String sql = "SELECT course_id FROM Courses WHERE title = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("course_id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Return -1 if course not found
    }

    public String getPrerequisites(int courseId) {
        String sql = "SELECT prerequisites FROM Courses WHERE course_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, courseId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("prerequisites");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}