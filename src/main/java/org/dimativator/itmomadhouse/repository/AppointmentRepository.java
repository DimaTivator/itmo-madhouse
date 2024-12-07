package org.dimativator.itmomadhouse.repository;

import org.dimativator.itmomadhouse.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
} 