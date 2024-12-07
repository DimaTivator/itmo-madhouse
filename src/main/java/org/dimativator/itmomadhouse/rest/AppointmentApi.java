package org.dimativator.itmomadhouse.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.dimativator.itmomadhouse.dto.AppointmentDto;
import java.util.List;

@RequestMapping("/api")
public interface AppointmentApi {
    @GetMapping("/appointments")
    ResponseEntity<List<AppointmentDto>> findAll();

    @PostMapping("/appointment")
    ResponseEntity<AppointmentDto> addAppointment(@RequestBody AppointmentDto appointmentDto);

    @DeleteMapping("/appointment/{id}")
    ResponseEntity<Void> removeAppointment(@PathVariable Long id);

    @PutMapping("/appointment/{id}")
    ResponseEntity<AppointmentDto> updateAppointment(@PathVariable Long id, @RequestBody AppointmentDto appointmentDto);
} 