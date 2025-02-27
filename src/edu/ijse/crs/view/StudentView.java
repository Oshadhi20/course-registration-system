
package edu.ijse.crs.view;

import edu.ijse.crs.service.StudentService;
import edu.ijse.crs.dto.StudentDto;

import javax.swing.*;
import java.awt.*;

public class StudentView extends JFrame {
    private JTextField idField, nameField, dobField, programField, yearField, contactField;
    private JButton addButton, deleteButton, searchButton;
    private StudentService studentService;

    public StudentView() {
        studentService = new StudentService();
        setTitle("Student Management");
        setSize(500, 350);
        setLayout(new GridLayout(4, 1));

        JPanel idNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idNamePanel.add(new JLabel("Student ID:"));
        idField = new JTextField(8);
        idNamePanel.add(idField);
        idNamePanel.add(new JLabel("Name:"));
        nameField = new JTextField(15);
        idNamePanel.add(nameField);
        add(idNamePanel);

        JPanel dobProgramPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dobProgramPanel.add(new JLabel("Date of Birth:"));
        dobField = new JTextField(10);
        dobProgramPanel.add(dobField);
        dobProgramPanel.add(new JLabel("Program:"));
        programField = new JTextField(12);
        dobProgramPanel.add(programField);
        add(dobProgramPanel);
        
        JPanel yearContactPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        yearContactPanel.add(new JLabel("Year:"));
        yearField = new JTextField(5);
        yearContactPanel.add(yearField);
        yearContactPanel.add(new JLabel("Contact Info:"));
        contactField = new JTextField(15);
        yearContactPanel.add(contactField);
        add(yearContactPanel);

      
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        addButton = new JButton("Add Student");
        addButton.addActionListener(e -> addStudent());
        buttonPanel.add(addButton);

        deleteButton = new JButton("Delete Student");
        deleteButton.addActionListener(e -> deleteStudent());
        buttonPanel.add(deleteButton);

        searchButton = new JButton("Search Student");
        searchButton.addActionListener(e -> searchStudent());
        buttonPanel.add(searchButton);
        add(buttonPanel);



        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void addStudent() {
        try {
            String name = nameField.getText();
            String dob = dobField.getText();
            String program = programField.getText();
            int year = Integer.parseInt(yearField.getText());
            String contact = contactField.getText();


            boolean success = studentService.registerStudent(name, dob, program, year, contact);
            if (success) {
                JOptionPane.showMessageDialog(this, "Student Added Successfully!");
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to Add Student!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid year!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteStudent() {
        try {
            int studentId = Integer.parseInt(idField.getText());
            boolean success = studentService.deleteStudent(studentId);
            if (success) {
                JOptionPane.showMessageDialog(this, "Student Deleted Successfully!");
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Student Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid Student ID!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchStudent() {
        try {
            int studentId = Integer.parseInt(idField.getText());
            StudentDto student = studentService.getStudentById(studentId);
            if (student != null) {
                nameField.setText(student.getName());
                dobField.setText(student.getDateOfBirth());
                programField.setText(student.getProgram());
                yearField.setText(String.valueOf(student.getYear()));
                contactField.setText(student.getContactInfo());
            } else {
                JOptionPane.showMessageDialog(this, "Student Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid Student ID!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        dobField.setText("");
        programField.setText("");
        yearField.setText("");
        contactField.setText("");
    }
}