package edu.ijse.crs.view;

import edu.ijse.crs.controller.RegistrationController;
import javax.swing.*;
import java.awt.*;


public class RegistrationView extends JFrame {
    private RegistrationController registrationController = new RegistrationController();
    private JTextField studentIdField, courseIdField;
    private JLabel availableSeatsLabel;
    private JButton checkSeatsButton, registerButton;

    public RegistrationView() {
        setTitle("Course Registration");
        setSize(400, 250);
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Row 1: Student ID
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Student ID:"), gbc);
        studentIdField = new JTextField(10);
        gbc.gridx = 1;
        add(studentIdField, gbc);

        // Row 2: Course ID
        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Course ID:"), gbc);
        courseIdField = new JTextField(10);
        gbc.gridx = 1;
        add(courseIdField, gbc);

        // Row 3: Available Seats
        availableSeatsLabel = new JLabel("Available Seats: ");
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        add(availableSeatsLabel, gbc);

        // Row 4: Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        checkSeatsButton = new JButton("Check Seats");
        registerButton = new JButton("Register");

        buttonPanel.add(checkSeatsButton);
        buttonPanel.add(registerButton);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        add(buttonPanel, gbc);

        // Event Listeners
        checkSeatsButton.addActionListener(e -> checkAvailableSeats());
        registerButton.addActionListener(e -> registerStudent());

        setVisible(true);
    }

    private void checkAvailableSeats() {
        int courseId = Integer.parseInt(courseIdField.getText().trim());
        int availableSeats = registrationController.getAvailableSeats(courseId);
        availableSeatsLabel.setText("Available Seats: " + availableSeats);
    }

    private void registerStudent() {
        int studentId = Integer.parseInt(studentIdField.getText().trim());
        int courseId = Integer.parseInt(courseIdField.getText().trim());
        boolean success = registrationController.registerStudent(studentId, courseId);

        JOptionPane.showMessageDialog(null, success ? "Registration Successful!" : "Registration Failed!");
        checkAvailableSeats();
    }

    public static void main(String[] args) {
        new RegistrationView();
    }
}