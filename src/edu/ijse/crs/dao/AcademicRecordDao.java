package edu.ijse.crs.dao;

import edu.ijse.crs.db.DBConnection;
import edu.ijse.crs.dto.AcademicRecordDto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AcademicRecordDao {

    public List<AcademicRecordDto> getRecordsByStudent(int studentId) {
        String sql = "SELECT * FROM AcademicRecords WHERE student_id = ?";
        List<AcademicRecordDto> records = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                records.add(new AcademicRecordDto(
                    rs.getInt("student_id"),
                    rs.getInt("course_id"),
                    rs.getString("grade")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching academic records: " + e.getMessage());
        }
        return records;
    }

    public boolean addAcademicRecord(AcademicRecordDto record) {
        String sql = "INSERT INTO AcademicRecords (student_id, course_id, grade) VALUES (?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, record.getStudentId());
            stmt.setInt(2, record.getCourseId());
            stmt.setString(3, record.getGrade());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error adding academic record: " + e.getMessage());
        }
        return false;
    }

    public boolean updateAcademicRecord(int studentId, int courseId, String grade) {
        String sql = "UPDATE AcademicRecords SET grade = ? WHERE student_id = ? AND course_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, grade);
            stmt.setInt(2, studentId);
            stmt.setInt(3, courseId);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error updating grade: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteAcademicRecord(int studentId, int courseId) {
        String sql = "DELETE FROM AcademicRecords WHERE student_id = ? AND course_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error deleting academic record: " + e.getMessage());
        }
        return false;
    }
}

 