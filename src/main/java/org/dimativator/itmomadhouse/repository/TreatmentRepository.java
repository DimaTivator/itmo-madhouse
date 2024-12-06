package org.dimativator.itmomadhouse.repository;

import org.dimativator.itmomadhouse.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
} 