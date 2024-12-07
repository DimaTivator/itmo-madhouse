package org.dimativator.itmomadhouse.services;

import lombok.RequiredArgsConstructor;
import org.dimativator.itmomadhouse.model.Treatment;
import org.dimativator.itmomadhouse.dto.TreatmentDto;
import org.dimativator.itmomadhouse.dto.AssignTherapyRequest;
import org.dimativator.itmomadhouse.repository.TreatmentRepository;
import org.dimativator.itmomadhouse.repository.ArtifactRepository;
import org.dimativator.itmomadhouse.repository.CreatureRepository;
import org.dimativator.itmomadhouse.repository.SpellRepository;
import org.dimativator.itmomadhouse.mappers.TreatmentMapper;
import org.dimativator.itmomadhouse.dto.PatientDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TreatmentService {
    private final TreatmentRepository treatmentRepository;
    private final ArtifactRepository artifactRepository;
    private final CreatureRepository creatureRepository;
    private final SpellRepository spellRepository;

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

    public TreatmentDto addTreatment(TreatmentDto treatmentDto) {
        return TreatmentMapper.toDto(
            treatmentRepository.save(
                TreatmentMapper.toEntity(treatmentDto)
            )
        );
    }

    public void createPersonolizedTreatments(PatientDto patientDto) {
        Treatment treatment = new Treatment();
        if (patientDto.getId() % 2 == 0) {
            if (creatureRepository.findByName("Goblin").isPresent()) {
                treatment.setCreature(creatureRepository.findByName("Goblin").get());
            }
        }
        else {
            if (artifactRepository.findByName("Potion of Healing").isPresent()) {
                treatment.setArtifact(artifactRepository.findByName("Potion of Healing").get());
            }
        }
    }

    public TreatmentDto updateById(Long id, TreatmentDto treatmentDto) {
        if (!treatmentRepository.existsById(id)) {
            throw new RuntimeException("Treatment not found with id: " + id);
        }
        treatmentDto.setId(id);
        return TreatmentMapper.toDto(
            treatmentRepository.save(
                TreatmentMapper.toEntity(treatmentDto)
            )
        );
    }

    public void removeById(Long id) {
        treatmentRepository.deleteById(id);
    }

    public TreatmentDto getById(Long id) {
        return TreatmentMapper.toDto(
            treatmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Treatment not found with id: " + id))
        );
    }
} 