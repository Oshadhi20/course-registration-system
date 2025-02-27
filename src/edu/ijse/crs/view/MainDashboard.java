package edu.ijse.crs.view;

import javax.swing.*;
import java.awt.*;

public class MainDashboard extends JFrame {
    private JButton studentViewButton, courseViewButton, enrollmentViewButton, registrationViewButton, academicrecordViewButton;

    public MainDashboard() {
        setTitle("Course Registration System - Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome to Course Registration System", SwingConstants.CENTER);
        add(welcomeLabel, BorderLayout.NORTH);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10)); // 3 rows, 1 column

        studentViewButton = new JButton("Student Management");
        courseViewButton = new JButton("Course Management");
        enrollmentViewButton = new JButton("Enrollment Management");
        registrationViewButton = new JButton("Registration Management");
        academicrecordViewButton = new JButton("AcademicRecord Management");

        studentViewButton.addActionListener(e -> new StudentView().setVisible(true));
        courseViewButton.addActionListener(e -> new CourseView().setVisible(true));
        enrollmentViewButton.addActionListener(e -> new EnrollmentView().setVisible(true));
        registrationViewButton.addActionListener(e -> new RegistrationView().setVisible(true));
        academicrecordViewButton.addActionListener(e -> new AcademicRecordView().setVisible(true));

        buttonPanel.add(studentViewButton);
        buttonPanel.add(courseViewButton);
        buttonPanel.add(enrollmentViewButton);
        buttonPanel.add(registrationViewButton);
        buttonPanel.add(academicrecordViewButton);
        
        add(buttonPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainDashboard().setVisible(true));
    }
}