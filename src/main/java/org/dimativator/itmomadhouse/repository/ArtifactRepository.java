package org.dimativator.itmomadhouse.repository;

import org.dimativator.itmomadhouse.model.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, Long> {
    
}