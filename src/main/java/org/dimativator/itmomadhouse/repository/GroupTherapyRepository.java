package org.dimativator.itmomadhouse.repository;

import org.dimativator.itmomadhouse.model.GroupTherapy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupTherapyRepository extends JpaRepository<GroupTherapy, Long> {
} 