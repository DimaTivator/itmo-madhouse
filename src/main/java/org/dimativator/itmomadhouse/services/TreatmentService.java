package org.dimativator.itmomadhouse.services;

import lombok.RequiredArgsConstructor;
import org.dimativator.itmomadhouse.dto.TreatmentDto;
import org.dimativator.itmomadhouse.dto.AssignTherapyRequest;
import org.dimativator.itmomadhouse.repository.TreatmentRepository;
import org.dimativator.itmomadhouse.mappers.TreatmentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TreatmentService {
    private final TreatmentRepository treatmentRepository;
    
    @PersistenceContext
    private EntityManager entityManager;

    public List<TreatmentDto> getAllTreatments() {
        return treatmentRepository.findAll().stream()
            .map(TreatmentMapper::toDto)
            .toList();
    }

    @Transactional
    public void assignTherapy(AssignTherapyRequest request) {
        entityManager.createNativeQuery(
            "CALL assign_therapy(" +
            ":patient_id, :doctor_id, :artifact_id, " +
            ":spell_id, :creature_id, :treatment_date)")
            .setParameter("patient_id", request.getPatientId())
            .setParameter("doctor_id", request.getDoctorId())
            .setParameter("artifact_id", request.getArtifactId())
            .setParameter("spell_id", request.getSpellId())
            .setParameter("creature_id", request.getCreatureId())
            .setParameter("treatment_date", request.getTreatmentDate())
            .executeUpdate();
    }
} 