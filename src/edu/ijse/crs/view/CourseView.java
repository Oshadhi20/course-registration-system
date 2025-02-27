
package edu.ijse.crs.view;

import edu.ijse.crs.controller.CourseController;
import edu.ijse.crs.dto.CourseDto;

import javax.swing.*;
import java.awt.*;

public class CourseView extends JFrame {
    private JTextField idField, titleField, creditHoursField, departmentField, prerequisitesField, maxCapacityField;
    private JButton addButton, deleteButton, searchButton;
    private CourseController courseController;

    public CourseView() {
        courseController = new CourseController();
        setTitle("Course Management");
        setSize(500, 350);
        setLayout(new GridLayout(5, 1)); 

        JPanel idTitlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idTitlePanel.add(new JLabel("Course ID:"));
        idField = new JTextField(8);
        idTitlePanel.add(idField);
        idTitlePanel.add(new JLabel("Title:"));
        titleField = new JTextField(15);
        idTitlePanel.add(titleField);
        add(idTitlePanel);

        JPanel creditDeptPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        creditDeptPanel.add(new JLabel("Credit Hours:"));
        creditHoursField = new JTextField(5);
        creditDeptPanel.add(creditHoursField);
        creditDeptPanel.add(new JLabel("Department:"));
        departmentField = new JTextField(15);
        creditDeptPanel.add(departmentField);
        add(creditDeptPanel);

        JPanel prereqCapacityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        prereqCapacityPanel.add(new JLabel("Prerequisites:"));
        prerequisitesField = new JTextField(15);
        prereqCapacityPanel.add(prerequisitesField);
        prereqCapacityPanel.add(new JLabel("Max Capacity:"));
        maxCapacityField = new JTextField(5);
        prereqCapacityPanel.add(maxCapacityField);
        add(prereqCapacityPanel);

        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        addButton = new JButton("Add Course");
        addButton.addActionListener(e -> addCourse());
        buttonPanel.add(addButton);

        deleteButton = new JButton("Delete Course");
        deleteButton.addActionListener(e -> deleteCourse());
        buttonPanel.add(deleteButton);

        searchButton = new JButton("Search Course");
        searchButton.addActionListener(e -> searchCourse());
        buttonPanel.add(searchButton);
        add(buttonPanel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void addCourse() {
        try {
            String title = titleField.getText();
            int creditHours = Integer.parseInt(creditHoursField.getText());
            String department = departmentField.getText();
            String prerequisites = prerequisitesField.getText();
            int maxCapacity = Integer.parseInt(maxCapacityField.getText());

            boolean success = courseController.addCourse(title, creditHours, department, prerequisites, maxCapacity);
            if (success) {
                JOptionPane.showMessageDialog(this, "Course Added Successfully!");
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to Add Course!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteCourse() {
        try {
            int courseId = Integer.parseInt(idField.getText());
            boolean success = courseController.deleteCourse(courseId);
            if (success) {
                JOptionPane.showMessageDialog(this, "Course Deleted Successfully!");
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Course Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid Course ID!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchCourse() {
        try {
            int courseId = Integer.parseInt(idField.getText());
            CourseDto course = courseController.getCourseById(courseId);
            if (course != null) {
                titleField.setText(course.getTitle());
                creditHoursField.setText(String.valueOf(course.getCreditHours()));
                departmentField.setText(course.getDepartment());
                prerequisitesField.setText(course.getPrerequisites());
                maxCapacityField.setText(String.valueOf(course.getMaxCapacity()));
            } else {
                JOptionPane.showMessageDialog(this, "Course Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid Course ID!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        idField.setText("");
        titleField.setText("");
        creditHoursField.setText("");
        departmentField.setText("");
        prerequisitesField.setText("");
        maxCapacityField.setText("");
    }
}