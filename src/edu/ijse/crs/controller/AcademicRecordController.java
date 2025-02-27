package edu.ijse.crs.controller;

import edu.ijse.crs.dto.AcademicRecordDto;
import edu.ijse.crs.service.AcademicRecordService;
import java.util.List;

public class AcademicRecordController {
    private AcademicRecordService academicRecordService = new AcademicRecordService();

    public List<AcademicRecordDto> getStudentRecords(int studentId) {
        return academicRecordService.getAcademicRecordsByStudent(studentId);
    }

    public boolean addAcademicRecord(AcademicRecordDto record) {
        return academicRecordService.addAcademicRecord(record);
    }

    public boolean updateAcademicRecord(int studentId, int courseId, String grade) {
        return academicRecordService.updateAcademicRecord(studentId, courseId, grade);
    }

    public boolean deleteAcademicRecord(int studentId, int courseId) {
        return academicRecordService.deleteAcademicRecord(studentId, courseId);
    }
}
