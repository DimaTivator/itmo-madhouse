package org.dimativator.itmomadhouse.repository;

import org.dimativator.itmomadhouse.model.DischargeReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DischargeReportRepository extends JpaRepository<DischargeReport, Long> {
    
}
