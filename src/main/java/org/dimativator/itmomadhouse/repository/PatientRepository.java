package org.dimativator.itmomadhouse.repository;

import org.dimativator.itmomadhouse.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
} 