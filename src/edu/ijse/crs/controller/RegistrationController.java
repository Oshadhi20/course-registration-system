package edu.ijse.crs.controller;

import edu.ijse.crs.service.RegistrationService;

public class RegistrationController {
    private RegistrationService registrationService = new RegistrationService();

    public boolean registerStudent(int studentId, int courseId) {
        return registrationService.registerStudent(studentId, courseId);
    }

    public int getAvailableSeats(int courseId) {
        return registrationService.getAvailableSeats(courseId);
    }
}