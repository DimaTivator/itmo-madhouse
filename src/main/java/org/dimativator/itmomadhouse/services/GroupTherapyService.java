package org.dimativator.itmomadhouse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.dimativator.itmomadhouse.repository.GroupTherapyRepository;
import org.dimativator.itmomadhouse.dto.GroupTherapyDto;
import org.dimativator.itmomadhouse.mappers.GroupTherapyMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupTherapyService {
    private final GroupTherapyRepository groupTherapyRepository;

    public List<GroupTherapyDto> getAllGroupTherapies() {
        return groupTherapyRepository.findAll()
            .stream()
            .map(GroupTherapyMapper::toDto)
            .collect(Collectors.toList());
    }
}
