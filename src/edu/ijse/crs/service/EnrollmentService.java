package edu.ijse.crs.service;

import edu.ijse.crs.dao.EnrollmentDao;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EnrollmentService {
    private EnrollmentDao enrollmentDao = new EnrollmentDao();
    private static final int ENROLLMENT_PERIOD_DAYS = 14; // Enrollment window

    public boolean enrollStudent(int studentId, int courseId) {
        if (isWithinEnrollmentPeriod()) {
            return enrollmentDao.enrollStudent(studentId, courseId);
        } else {
            System.out.println("Enrollment failed: Enrollment period is over.");
            return false;
        }
    }

    public boolean dropStudentCourse(int studentId, int courseId) {
        if (isWithinEnrollmentPeriod()) {
            return enrollmentDao.dropStudentCourse(studentId, courseId);
        } else {
            System.out.println("Drop failed: Enrollment period is over.");
            return false;
        }
    }

    private boolean isWithinEnrollmentPeriod() {
        LocalDate semesterStart = LocalDate.of(2025, 2, 1); // Change based on semester
        long daysSinceStart = ChronoUnit.DAYS.between(semesterStart, LocalDate.now());
        return daysSinceStart <= ENROLLMENT_PERIOD_DAYS;
    }
}

