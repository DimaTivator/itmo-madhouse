package org.dimativator.itmomadhouse.repository;

import org.dimativator.itmomadhouse.model.TreatmentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentHistoryRepository extends JpaRepository<TreatmentHistory, Long> {
    
}
