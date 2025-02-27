
package edu.ijse.crs.controller;

import edu.ijse.crs.dto.StudentDto;
import edu.ijse.crs.service.StudentService;
import java.util.List;


public class StudentController {
    private StudentService studentService;

    public StudentController() {
        this.studentService = new StudentService();
    }

    public boolean addStudent(String name, String dob, String program, int year, String contactInfo) {
        return studentService.registerStudent(name, dob, program, year, contactInfo);
    }
    public boolean deleteStudent(int studentId) {
        return studentService.deleteStudent(studentId);
    }

    public StudentDto getStudentById(int studentId) {
        return studentService.getStudentById(studentId);
    }

    public List<String> getAllStudents() {
        return studentService.getAllStudents();
    }
}

