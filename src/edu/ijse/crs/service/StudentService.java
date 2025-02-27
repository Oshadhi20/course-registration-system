
package edu.ijse.crs.service;

import edu.ijse.crs.dao.StudentDao;
import edu.ijse.crs.dto.StudentDto;

import java.util.List;

public class StudentService {
    private final StudentDao studentDao;

    public StudentService() {
        this.studentDao = new StudentDao();
    }

    public boolean registerStudent(String name, String dob, String program, int year, String contactInfo) {
        return studentDao.addStudent(name, dob, program, year, contactInfo);
    }

    public boolean deleteStudent(int studentId) {
        return studentDao.deleteStudent(studentId);
    }

    public StudentDto getStudentById(int studentId) {
        return studentDao.getStudentById(studentId);
    }

    public List<String> getAllStudents() {
        return studentDao.getAllStudents();
    }
}