package org.dimativator.itmomadhouse.services;

import org.dimativator.itmomadhouse.dto.DischargeReportDto;
import org.dimativator.itmomadhouse.mappers.DischargeReportMapper;
import org.dimativator.itmomadhouse.repository.DischargeReportRepository;
import org.dimativator.itmomadhouse.repository.PatientRepository;
import org.dimativator.itmomadhouse.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import org.dimativator.itmomadhouse.dto.DischargePatientRequest;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
@RequiredArgsConstructor
public class DischargeReportService {
    private final DischargeReportRepository dischargeReportRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<DischargeReportDto> getAllDischargeReports() {
        return dischargeReportRepository.findAll().stream()
            .map(DischargeReportMapper::toDto)
            .toList();
    }

    @Transactional
    public void dischargePatient(DischargePatientRequest request) {
        entityManager.createNativeQuery(
            "CALL discharge_patient(" +
            "CAST(:patient_id AS INTEGER), " +
            "CAST(:doctor_id AS INTEGER), " +
            "CAST(:report AS TEXT))")
            .setParameter("patient_id", request.getPatientId())
            .setParameter("doctor_id", request.getDoctorId())
            .setParameter("report", request.getReport())
            .executeUpdate();
    }
}
