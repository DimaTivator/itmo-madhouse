package org.dimativator.itmomadhouse.repository;

import org.dimativator.itmomadhouse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
} 