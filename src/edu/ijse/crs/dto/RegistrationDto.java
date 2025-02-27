package edu.ijse.crs.dto;

public class RegistrationDto {
    private int studentId;
    private int courseId;
    private int availableSeats;
    private boolean prerequisitesMet;

    public RegistrationDto(int studentId, int courseId, int availableSeats, boolean prerequisitesMet) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.availableSeats = availableSeats;
        this.prerequisitesMet = prerequisitesMet;
    }

    public int getStudentId() { return studentId; }
    public int getCourseId() { return courseId; }
    public int getAvailableSeats() { return availableSeats; }
    public boolean isPrerequisitesMet() { return prerequisitesMet; }

    public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }
    public void setPrerequisitesMet(boolean prerequisitesMet) { this.prerequisitesMet = prerequisitesMet; }
}