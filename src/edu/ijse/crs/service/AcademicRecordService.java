package edu.ijse.crs.service;

import edu.ijse.crs.dao.AcademicRecordDao;
import edu.ijse.crs.dto.AcademicRecordDto;
import java.util.List;

public class AcademicRecordService {
    private AcademicRecordDao academicRecordDao = new AcademicRecordDao();

    public List<AcademicRecordDto> getAcademicRecordsByStudent(int studentId) {
        return academicRecordDao.getRecordsByStudent(studentId);
    }

    public boolean addAcademicRecord(AcademicRecordDto record) {
        return academicRecordDao.addAcademicRecord(record);
    }

    public boolean updateAcademicRecord(int studentId, int courseId, String grade) {
        return academicRecordDao.updateAcademicRecord(studentId, courseId, grade);
    }

    public boolean deleteAcademicRecord(int studentId, int courseId) {
        return academicRecordDao.deleteAcademicRecord(studentId, courseId);
    }
}
