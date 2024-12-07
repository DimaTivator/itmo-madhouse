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
} 