package edu.ijse.crs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.ijse.crs.db.DBConnection;

public class RegistrationDao {

    public boolean checkPrerequisites(int studentId, int courseId) {
        String sql = "SELECT prerequisites FROM Courses WHERE course_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String prerequisites = rs.getString("prerequisites");
                if (prerequisites == null || prerequisites.isEmpty()) {
                    return true; 
                }

                String[] requiredCourses = prerequisites.split(",");
                for (String requiredCourse : requiredCourses) {
                    if (!hasCompletedCourse(studentId, Integer.parseInt(requiredCourse.trim()))) {
                        return false; 
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean hasCompletedCourse(int studentId, int prerequisiteCourseId) {
        String sql = "SELECT COUNT(*) FROM AcademicRecords WHERE student_id = ? AND course_id = ? AND grade IS NOT NULL";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentId);
            stmt.setInt(2, prerequisiteCourseId);
            ResultSet rs = stmt.executeQuery();

            return rs.next() && rs.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getAvailableSeats(int courseId) {
        String sql = "SELECT max_capacity - COUNT(e.student_id) AS available_seats " +
                     "FROM Courses c LEFT JOIN Enrollments e ON c.course_id = e.course_id " +
                     "WHERE c.course_id = ? GROUP BY c.max_capacity";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();

            return rs.next() ? rs.getInt("available_seats") : 0; 
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean registerStudent(int studentId, int courseId) {
        if (!checkPrerequisites(studentId, courseId)) {
            System.out.println("Registration failed: Prerequisites not met.");
            return false;
        }

        if (getAvailableSeats(courseId) <= 0) {
            System.out.println("Registration failed: No available seats.");
            return false;
        }

        String sql = "INSERT INTO Enrollments (student_id, course_id, enrollment_date) VALUES (?, ?, NOW())";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);

            return stmt.executeUpdate() > 0; 

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}