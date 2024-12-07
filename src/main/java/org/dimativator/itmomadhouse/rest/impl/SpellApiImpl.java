package org.dimativator.itmomadhouse.rest.impl;

import lombok.RequiredArgsConstructor;
import org.dimativator.itmomadhouse.rest.SpellApi;
import org.dimativator.itmomadhouse.dto.SpellDto;
import org.dimativator.itmomadhouse.services.SpellService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SpellApiImpl implements SpellApi {
    private final SpellService spellService;

    @Override
    public ResponseEntity<List<SpellDto>> findAll() {
        return ResponseEntity.ok(spellService.getAllSpells());
    }

    @Override
    public ResponseEntity<SpellDto> getSpell(Long id) {
        return ResponseEntity.ok(spellService.getById(id));
    }

    @Override
    public ResponseEntity<SpellDto> addSpell(SpellDto spellDto) {
        return ResponseEntity.ok(spellService.addSpell(spellDto));
    }

    @Override
    public ResponseEntity<SpellDto> updateSpell(Long id, SpellDto spellDto) {
        return ResponseEntity.ok(spellService.updateById(id, spellDto));
    }

    @Override
    public ResponseEntity<Void> removeSpell(Long id) {
        spellService.removeById(id);
        return ResponseEntity.ok().build();
    }
} 