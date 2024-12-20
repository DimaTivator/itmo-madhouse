package org.dimativator.itmomadhouse.repository;

import org.dimativator.itmomadhouse.model.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long> {
} 