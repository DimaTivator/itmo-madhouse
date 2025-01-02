package org.dimativator.itmomadhouse.services;

import lombok.RequiredArgsConstructor;
import org.dimativator.itmomadhouse.dto.AppointmentDto;
import org.dimativator.itmomadhouse.repository.AppointmentRepository;
import org.dimativator.itmomadhouse.repository.DoctorRepository;
import org.dimativator.itmomadhouse.repository.PatientRepository;
import org.dimativator.itmomadhouse.mappers.AppointmentMapper;
import org.dimativator.itmomadhouse.model.Appointment;
import org.dimativator.itmomadhouse.model.Doctor;
import org.dimativator.itmomadhouse.model.Patient;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public List<AppointmentDto> getAllAppointments() {
        return appointmentRepository.findAll().stream()
            .map(AppointmentMapper::toDto)
            .toList();
    }

    public AppointmentDto addAppointment(AppointmentDto appointmentDto) {
        Doctor doctor = doctorRepository.findById(appointmentDto.getDoctor().getId()).orElseThrow(() -> new RuntimeException("Doctor not found with id: " + appointmentDto.getDoctor().getId()));
        Patient patient = patientRepository.findById(appointmentDto.getPatient().getId()).orElseThrow(() -> new RuntimeException("Patient not found with id: " + appointmentDto.getPatient().getId()));
        Appointment appointment = Appointment.builder()
            .doctor(doctor)
            .patient(patient)
            .appointmentDate(appointmentDto.getAppointmentDate())
            .status(appointmentDto.getStatus())
            .notes(appointmentDto.getNotes())
            .build();
        return AppointmentMapper.toDto(
            appointmentRepository.save(appointment)
        );
    }

    public void removeById(Long id) {
        appointmentRepository.deleteById(id);
    }

    public AppointmentDto updateById(Long id, AppointmentDto appointmentDto) {
        if (!appointmentRepository.existsById(id)) {
            throw new RuntimeException("Appointment not found with id: " + id);
        }
        appointmentDto.setId(id);
        return AppointmentMapper.toDto(
            appointmentRepository.save(
                AppointmentMapper.toEntity(appointmentDto)
            )
        );
    }

    public List<AppointmentDto> getAllAppointmentsByDoctorId(Long doctorId) {
        return appointmentRepository.findAllByDoctorId(doctorId).stream()
            .map(AppointmentMapper::toDto)
            .toList();
    }
} 