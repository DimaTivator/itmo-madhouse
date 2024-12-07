package org.dimativator.itmomadhouse.repository;

import java.util.Optional;
import org.dimativator.itmomadhouse.model.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, Long> {
    Optional<Artifact> findByName(String name);
}
