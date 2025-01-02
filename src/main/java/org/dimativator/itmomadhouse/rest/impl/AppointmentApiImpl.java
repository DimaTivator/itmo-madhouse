package org.dimativator.itmomadhouse.rest.impl;

import lombok.RequiredArgsConstructor;
import org.dimativator.itmomadhouse.rest.AppointmentApi;
import org.dimativator.itmomadhouse.dto.AppointmentDto;
import org.dimativator.itmomadhouse.services.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AppointmentApiImpl implements AppointmentApi {
    private final AppointmentService appointmentService;

    @Override
    public ResponseEntity<List<AppointmentDto>> findAll() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @Override
    public ResponseEntity<AppointmentDto> addAppointment(AppointmentDto appointmentDto) {
        return ResponseEntity.ok(appointmentService.addAppointment(appointmentDto));
    }

    @Override
    public ResponseEntity<Void> removeAppointment(Long id) {
        appointmentService.removeById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<AppointmentDto> updateAppointment(Long id, AppointmentDto appointmentDto) {
        return ResponseEntity.ok(appointmentService.updateById(id, appointmentDto));
    }

    @Override
    public ResponseEntity<List<AppointmentDto>> getAllAppointmentsByDoctorId(Long doctorId) {
        return ResponseEntity.ok(appointmentService.getAllAppointmentsByDoctorId(doctorId));
    }
} 