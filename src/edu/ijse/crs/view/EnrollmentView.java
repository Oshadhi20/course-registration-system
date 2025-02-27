
package edu.ijse.crs.view;

import edu.ijse.crs.controller.EnrollmentController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnrollmentView extends JFrame {
    private EnrollmentController enrollmentController = new EnrollmentController();
    private JComboBox<String> courseDropdown;
    private JButton enrollButton, dropButton;
    private JTextField studentIdField;

    public EnrollmentView() {
        setTitle("Enrollment System");
        setSize(500, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel studentLabel = new JLabel("Student ID:");
        studentLabel.setBounds(20, 20, 100, 25);
        add(studentLabel);

        studentIdField = new JTextField();
        studentIdField.setBounds(120, 20, 150, 25);
        add(studentIdField);

        JLabel courseLabel = new JLabel("Course:");
        courseLabel.setBounds(20, 60, 100, 25);
        add(courseLabel);

        courseDropdown = new JComboBox<>();
        courseDropdown.setBounds(120, 60, 200, 25);
        add(courseDropdown);
        loadCourses();

        enrollButton = new JButton("Enroll");
        enrollButton.setBounds(50, 120, 100, 30);
        add(enrollButton);
        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentIdText = studentIdField.getText().trim();
                if (studentIdText.isEmpty() || !studentIdText.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Invalid Student ID! Please enter a numeric value.");
                    return;
                }        
                int studentId = Integer.parseInt(studentIdText);
                int courseId = courseDropdown.getSelectedIndex() + 1; 
                boolean success = enrollmentController.enrollStudent(studentId, courseId);
        
                JOptionPane.showMessageDialog(null, success ? "Enrollment Successful!" : "Enrollment Failed.");
            }
        });

        dropButton = new JButton("Drop");
        dropButton.setBounds(200, 120, 100, 30);
        add(dropButton);
        dropButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentIdText = studentIdField.getText().trim();

                if (studentIdText.isEmpty() || !studentIdText.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Invalid Student ID! Please enter a numeric value.");
                    return;
                }        
                int studentId = Integer.parseInt(studentIdText);
                int courseId = courseDropdown.getSelectedIndex() + 1;
                boolean success = enrollmentController.dropStudentCourse(studentId, courseId);
        
                JOptionPane.showMessageDialog(null, success ? "Course Dropped!" : "Drop Failed.");
            }
        });

        setVisible(true);
    }

    private void loadCourses() {
    
        courseDropdown.addItem("Database Systems");
        courseDropdown.addItem("Software Engineering");
        courseDropdown.addItem("Cyber Security");
        courseDropdown.addItem("Data Structures");
        courseDropdown.addItem("Artificial Intelligence");
        courseDropdown.addItem("Operating Systems");
        courseDropdown.addItem("Networking");

    }
}
     