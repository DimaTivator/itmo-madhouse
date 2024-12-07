package org.dimativator.itmomadhouse.services;

import lombok.RequiredArgsConstructor;
import org.dimativator.itmomadhouse.dto.AppointmentDto;
import org.dimativator.itmomadhouse.repository.AppointmentRepository;
import org.dimativator.itmomadhouse.mappers.AppointmentMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public List<AppointmentDto> getAllAppointments() {
        return appointmentRepository.findAll().stream()
            .map(AppointmentMapper::toDto)
            .toList();
    }

    public AppointmentDto addAppointment(AppointmentDto appointmentDto) {
        return AppointmentMapper.toDto(
            appointmentRepository.save(
                AppointmentMapper.toEntity(appointmentDto)
            )
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
} 