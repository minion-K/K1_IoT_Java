package org.example.z_project.phr_solution.service;

import org.example.z_project.phr_solution.dto.heath_record.request.RecordCreateRequestDto;
import org.example.z_project.phr_solution.dto.heath_record.response.RecordListResponseDto;

import java.util.List;
import java.util.Map;

public interface HealthRecordService {
    void createRecord(RecordCreateRequestDto dto);
    List<RecordListResponseDto> getAllRecords();
    List<RecordListResponseDto> filterRecordsByDiagnosis(String diagnosis);
    void deleteRecord(Long id);
    Map<String, Long> filterRecordByDiagnosisCount();
    List<RecordListResponseDto> filterRecordsByAge(int minAge);
    List<RecordListResponseDto> filterDate(String from, String to);
}
