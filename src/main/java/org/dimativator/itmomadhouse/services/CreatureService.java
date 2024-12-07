package org.dimativator.itmomadhouse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.dimativator.itmomadhouse.repository.CreatureRepository;
import org.dimativator.itmomadhouse.dto.CreatureDto;
import org.dimativator.itmomadhouse.mappers.CreatureMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreatureService {
    private final CreatureRepository creatureRepository;

    public List<CreatureDto> getAllCreatures() {
        return creatureRepository.findAll().stream()
            .map(CreatureMapper::toDto)
            .toList();
    }

    public CreatureDto addCreature(CreatureDto creatureDto) {
        return CreatureMapper.toDto(
            creatureRepository.save(
                CreatureMapper.toEntity(creatureDto)
            )
        );
    }

    public CreatureDto updateById(Long id, CreatureDto creatureDto) {
        if (!creatureRepository.existsById(id)) {
            throw new RuntimeException("Creature not found with id: " + id);
        }
        creatureDto.setId(id);
        return CreatureMapper.toDto(
            creatureRepository.save(
                CreatureMapper.toEntity(creatureDto)
            )
        );
    }

    public void removeById(Long id) {
        creatureRepository.deleteById(id);
    }
}
