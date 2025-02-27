package edu.ijse.crs.service;
import edu.ijse.crs.dao.RegistrationDao;

public class RegistrationService {
    private RegistrationDao registrationDao = new RegistrationDao();

    public boolean registerStudent(int studentId, int courseId) {
        return registrationDao.registerStudent(studentId, courseId);
    }

    public int getAvailableSeats(int courseId) {
        return registrationDao.getAvailableSeats(courseId);
    }
}