package edu.ijse.crs.dto;

import java.time.LocalDateTime;

public class EnrollmentDto {
    private int enrollmentId;
    private int studentId;
    private int courseId;
    private String status; 
    private LocalDateTime enrollmentDate;

    public EnrollmentDto(int enrollmentId, int studentId, int courseId, String status, LocalDateTime enrollmentDate) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.status = status;
        this.enrollmentDate = enrollmentDate;
    }

    public int getEnrollmentId() { return enrollmentId; }
    public int getStudentId() { return studentId; }
    public int getCourseId() { return courseId; }
    public String getStatus() { return status; }
    public LocalDateTime getEnrollmentDate() { return enrollmentDate; }

    public void setStatus(String status) { this.status = status; }
}