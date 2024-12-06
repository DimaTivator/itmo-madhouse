package org.dimativator.itmomadhouse.repository;

import org.dimativator.itmomadhouse.model.Spell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpellRepository extends JpaRepository<Spell, Long> {
} 