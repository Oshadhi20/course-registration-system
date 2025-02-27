package edu.ijse.crs.controller;

import edu.ijse.crs.service.EnrollmentService;

public class EnrollmentController {
    private EnrollmentService enrollmentService = new EnrollmentService();

    public boolean enrollStudent(int studentId, int courseId) {
        return enrollmentService.enrollStudent(studentId, courseId);
    }

    public boolean dropStudentCourse(int studentId, int courseId) {
        return enrollmentService.dropStudentCourse(studentId, courseId);
    }
}