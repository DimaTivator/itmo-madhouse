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

    public GroupTherapyDto addGroupTherapy(GroupTherapyDto therapyDto) {
        return GroupTherapyMapper.toDto(
            groupTherapyRepository.save(
                GroupTherapyMapper.toEntity(therapyDto)
            )
        );
    }

    public GroupTherapyDto updateById(Long id, GroupTherapyDto therapyDto) {
        if (!groupTherapyRepository.existsById(id)) {
            throw new RuntimeException("Group therapy not found with id: " + id);
        }
        therapyDto.setId(id);
        return GroupTherapyMapper.toDto(
            groupTherapyRepository.save(
                GroupTherapyMapper.toEntity(therapyDto)
            )
        );
    }

    public void removeById(Long id) {
        groupTherapyRepository.deleteById(id);
    }
}
