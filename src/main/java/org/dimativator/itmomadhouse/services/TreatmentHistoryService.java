package org.dimativator.itmomadhouse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.dimativator.itmomadhouse.dto.TreatmentHistoryDto;
import org.dimativator.itmomadhouse.repository.TreatmentHistoryRepository;
import org.dimativator.itmomadhouse.mappers.TreatmentHistoryMapper;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TreatmentHistoryService {
    private final TreatmentHistoryRepository treatmentHistoryRepository;

    public List<TreatmentHistoryDto> getAllTreatmentHistories() {
        return treatmentHistoryRepository.findAll().stream()
            .map(TreatmentHistoryMapper::toDto)
            .toList();
    }
}