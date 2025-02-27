package edu.ijse.crs.service;

import edu.ijse.crs.dao.CourseDao;
import edu.ijse.crs.dto.CourseDto;

import java.util.List;

public class CourseService {
    private final CourseDao courseDao;

    public CourseService() {
        this.courseDao = new CourseDao();
    }

    public boolean registerCourse(String title, int creditHours, String department, String prerequisites, int maxCapacity) {
        return courseDao.addCourse(title, creditHours, department, prerequisites, maxCapacity);
    }

    public boolean deleteCourse(int courseId) {
        return courseDao.deleteCourse(courseId);
    }

    public CourseDto getCourseById(int courseId) {
        return courseDao.getCourseById(courseId);
    }

    public List<String> getAllCourses() {
        return courseDao.getAllCourses();
    }

    public int getCourseIdByName(String name) {
        return courseDao.getCourseIdByName(name);
    }

    public String getPrerequisites(int courseId) {
        return courseDao.getPrerequisites(courseId);
    }
}