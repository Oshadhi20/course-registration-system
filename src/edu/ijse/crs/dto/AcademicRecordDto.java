package edu.ijse.crs.dto;

public class AcademicRecordDto {
    private int studentId;
    private int courseId;
    private String grade;

    public AcademicRecordDto(int studentId, int courseId, String grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }

    public int getStudentId() { return studentId; }
    public int getCourseId() { return courseId; }
    public String getGrade() { return grade; }

    public void setGrade(String grade) { this.grade = grade; }
}
