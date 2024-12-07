package org.dimativator.itmomadhouse.services;

import lombok.RequiredArgsConstructor;
import org.dimativator.itmomadhouse.dto.DoctorDto;
import org.dimativator.itmomadhouse.repository.DoctorRepository;
import org.dimativator.itmomadhouse.mappers.DoctorMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public List<DoctorDto> getAllDoctors() {
        return doctorRepository.findAll().stream()
            .map(DoctorMapper::toDto)
            .toList();
    }
} 