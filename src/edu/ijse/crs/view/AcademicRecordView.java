package edu.ijse.crs.view;

import edu.ijse.crs.controller.AcademicRecordController;
import edu.ijse.crs.dto.AcademicRecordDto;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AcademicRecordView extends JFrame {
    private AcademicRecordController academicRecordController = new AcademicRecordController();
    private JTextField studentIdField, courseIdField, gradeField;
    private JTextArea recordsArea;
    private JButton fetchButton, addButton, updateButton, deleteButton;


public AcademicRecordView() {
    setTitle("Academic Records");
    setSize(700, 500);
    setLayout(new GridBagLayout());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5); 

    gbc.gridx = 0; gbc.gridy = 0;
    add(new JLabel("Student ID:"), gbc);
    studentIdField = new JTextField(10);
    gbc.gridx = 1;
    add(studentIdField, gbc);

    fetchButton = new JButton("Fetch Records");
    gbc.gridx = 2;
    add(fetchButton, gbc);

    gbc.gridx = 0; gbc.gridy = 1;
    add(new JLabel("Course ID & Grade:"), gbc);
    courseIdField = new JTextField(5);
    gradeField = new JTextField(5);
    JPanel courseGradePanel = new JPanel(new FlowLayout());
    courseGradePanel.add(courseIdField);
    courseGradePanel.add(new JLabel("Grade:"));
    courseGradePanel.add(gradeField);
    gbc.gridx = 1; gbc.gridwidth = 2;
    add(courseGradePanel, gbc);

    JPanel buttonPanel = new JPanel(new FlowLayout());
    addButton = new JButton("Add");
    updateButton = new JButton("Update");
    deleteButton = new JButton("Delete");
    buttonPanel.add(addButton);
    buttonPanel.add(updateButton);
    buttonPanel.add(deleteButton);

    gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 3;
    add(buttonPanel, gbc);

    recordsArea = new JTextArea(10, 40);
    recordsArea.setEditable(false);
    gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 3;
    add(new JScrollPane(recordsArea), gbc);

    fetchButton.addActionListener(e -> fetchRecords());
    addButton.addActionListener(e -> addRecord());
    updateButton.addActionListener(e -> updateRecord());
    deleteButton.addActionListener(e -> deleteRecord());

    setVisible(true);
}

private void fetchRecords() {
    int studentId = Integer.parseInt(studentIdField.getText().trim());
    List<AcademicRecordDto> records = academicRecordController.getStudentRecords(studentId);

    recordsArea.setText("");
    for (AcademicRecordDto record : records) {
        recordsArea.append("Course ID: " + record.getCourseId() + " | Grade: " + record.getGrade() + "\n");
    }
}

private void addRecord() {
    int studentId = Integer.parseInt(studentIdField.getText().trim());
    int courseId = Integer.parseInt(courseIdField.getText().trim());
    String grade = gradeField.getText().trim();
    boolean success = academicRecordController.addAcademicRecord(new AcademicRecordDto(studentId, courseId, grade));
    JOptionPane.showMessageDialog(null, success ? "Record Added!" : "Failed to Add Record.");
    fetchRecords();
}

private void updateRecord() {
    int studentId = Integer.parseInt(studentIdField.getText().trim());
    int courseId = Integer.parseInt(courseIdField.getText().trim());
    String grade = gradeField.getText().trim();
    boolean success = academicRecordController.updateAcademicRecord(studentId, courseId, grade);
    JOptionPane.showMessageDialog(null, success ? "Grade Updated!" : "Update Failed.");
    fetchRecords();
}

private void deleteRecord() {
    int studentId = Integer.parseInt(studentIdField.getText().trim());
    int courseId = Integer.parseInt(courseIdField.getText().trim());
    boolean success = academicRecordController.deleteAcademicRecord(studentId, courseId);
    JOptionPane.showMessageDialog(null, success ? "Record Deleted!" : "Delete Failed.");
    fetchRecords();
}

public static void main(String[] args) {
    new AcademicRecordView();
}
}