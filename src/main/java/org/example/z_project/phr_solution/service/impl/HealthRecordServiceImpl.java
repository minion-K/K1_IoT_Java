package org.example.z_project.phr_solution.service.impl;

import org.example.z_project.phr_solution.dto.heath_record.request.RecordCreateRequestDto;
import org.example.z_project.phr_solution.dto.heath_record.response.RecordListResponseDto;
import org.example.z_project.phr_solution.entity.HealthRecord;
import org.example.z_project.phr_solution.entity.Patient;
import org.example.z_project.phr_solution.repository.HealthRecordRepository;
import org.example.z_project.phr_solution.repository.PatientRepository;
import org.example.z_project.phr_solution.service.HealthRecordService;
import org.example.z_project.phr_solution.util.DateValidator;

import javax.swing.*;
import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class HealthRecordServiceImpl implements HealthRecordService {
    private final HealthRecordRepository recordRepository;
    private final PatientRepository patientRepository;

    private static long currentId = 1;

    public HealthRecordServiceImpl() {
        this.recordRepository = HealthRecordRepository.getInstance();
        this.patientRepository = PatientRepository.getInstance();
    }

    private Long generatedRecordId() {
        return currentId++;
    }

//    환자 고유 ID 유효성 입증
    private void validPatientId(Long patientId) {
//        환자 존재 여부 확인
        Optional<Patient> foundPatient = patientRepository.findById(patientId);
        if(foundPatient.isEmpty()) {
            throw new IllegalArgumentException("해당 ID의 환자를 찾을 수 없습니다. [ ID ]: " + patientId);
        }
    }

    @Override
    public void createRecord(RecordCreateRequestDto dto) {
        try {
            validPatientId(dto.getPatientId());

//            날짜 형식 유효성 검사
            DateValidator.validateOrThrow(dto.getDateOfVisit());

            HealthRecord record = new HealthRecord(generatedRecordId(), dto.getPatientId(), dto.getDateOfVisit(), dto.getDiagnosis(), dto.getTreatment());

            recordRepository.save(record);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<RecordListResponseDto> getAllRecords() {
        List<RecordListResponseDto> dtos = null;

        try {
            List<HealthRecord> records = recordRepository.findAll();
            dtos = records.stream()
                    .map(record -> new RecordListResponseDto(record.getId(),record.getPatientId(), record.getDateOfVisit()
                            , record.getDiagnosis(), record.getTreatment(), new Date()))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return dtos;
    }

    @Override
    public List<RecordListResponseDto> filterRecordsByDiagnosis(String diagnosis) {
        List<RecordListResponseDto> dtos = null;

        try {
            List<HealthRecord> records = recordRepository.findAll();

            dtos = records.stream()
                    .filter(record -> record.getDiagnosis().contains(diagnosis))
                    .map(record -> new RecordListResponseDto(
                            record.getId(), record.getPatientId(), record.getDateOfVisit(), record.getDiagnosis()
                            , record.getTreatment(), new Date()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return dtos;
    }

    @Override
    public void deleteRecord(Long id) {
        try {
            HealthRecord record = recordRepository.findById(id)
                    .orElseThrow(() -> new IllegalAccessError("해당 ID의 건강 기록이 존재하지 않습니다. [ ID ]: " + id));
            recordRepository.delete(record);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Map<String, Long> filterRecordByDiagnosisCount() {
        List<HealthRecord> records = recordRepository.findAll();

        return records.stream()
                .collect(Collectors.groupingBy(HealthRecord::getDiagnosis, Collectors.counting()));
    }

    @Override
    public List<RecordListResponseDto> filterRecordsByAge(int minAge) {
        List<HealthRecord> records = recordRepository.findAll();

        return records.stream()
                .filter(record -> {
                    Optional<Patient> patient = patientRepository.findById(record.getPatientId());
                    return patient.isPresent() && patient.get().getAge() >= minAge;
                })
                .map(r -> new RecordListResponseDto(r.getId(), r.getPatientId(), r.getDateOfVisit()
                        , r.getDiagnosis(), r.getTreatment(), new Date()))
                .collect(Collectors.toList());
    }

    @Override
    public List<RecordListResponseDto> filterDate(String from, String to) {

        return List.of();
    }

}
