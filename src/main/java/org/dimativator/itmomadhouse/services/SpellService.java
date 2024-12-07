package org.dimativator.itmomadhouse.services;

import lombok.RequiredArgsConstructor;
import org.dimativator.itmomadhouse.dto.SpellDto;
import org.dimativator.itmomadhouse.repository.SpellRepository;
import org.dimativator.itmomadhouse.mappers.SpellMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpellService {
    private final SpellRepository spellRepository;

    public List<SpellDto> getAllSpells() {
        return spellRepository.findAll().stream()
            .map(SpellMapper::toDto)
            .toList();
    }

    public SpellDto addSpell(SpellDto spellDto) {
        return SpellMapper.toDto(
            spellRepository.save(
                SpellMapper.toEntity(spellDto)
            )
        );
    }

    public SpellDto updateById(Long id, SpellDto spellDto) {
        if (!spellRepository.existsById(id)) {
            throw new RuntimeException("Spell not found with id: " + id);
        }
        spellDto.setId(id);
        return SpellMapper.toDto(
            spellRepository.save(
                SpellMapper.toEntity(spellDto)
            )
        );
    }

    public void removeById(Long id) {
        spellRepository.deleteById(id);
    }

    public SpellDto getById(Long id) {
        return SpellMapper.toDto(
            spellRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Spell not found with id: " + id))
        );
    }
} 