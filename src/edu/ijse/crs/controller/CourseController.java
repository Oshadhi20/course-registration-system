package edu.ijse.crs.controller;

import edu.ijse.crs.dto.CourseDto;
import edu.ijse.crs.service.CourseService;
import java.util.List;

public class CourseController {
    private CourseService courseService;

    public CourseController() {
        this.courseService = new CourseService();
    }
    public boolean addCourse(String title, int creditHours, String department, String prerequisites, int maxCapacity) {
        return courseService.registerCourse(title, creditHours, department, prerequisites, maxCapacity);
    }

    public boolean deleteCourse(int courseId) {
        return courseService.deleteCourse(courseId);
    }

    public CourseDto getCourseById(int courseId) {
        return courseService.getCourseById(courseId);
    }

    public List<String> getAllCourses() {
        return courseService.getAllCourses();
    }
}

    

      

