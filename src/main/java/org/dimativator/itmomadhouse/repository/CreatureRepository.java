package org.dimativator.itmomadhouse.repository;

import org.dimativator.itmomadhouse.model.Creature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatureRepository extends JpaRepository<Creature, Long> {
} 