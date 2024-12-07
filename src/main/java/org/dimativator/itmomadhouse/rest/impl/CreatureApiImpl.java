package org.dimativator.itmomadhouse.rest.impl;

import lombok.RequiredArgsConstructor;
import org.dimativator.itmomadhouse.rest.CreatureApi;
import org.dimativator.itmomadhouse.dto.CreatureDto;
import org.dimativator.itmomadhouse.services.CreatureService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CreatureApiImpl implements CreatureApi {
    private final CreatureService creatureService;

    @Override
    public ResponseEntity<List<CreatureDto>> findAll() {
        return ResponseEntity.ok(creatureService.getAllCreatures());
    }

    @Override
    public ResponseEntity<CreatureDto> addCreature(CreatureDto creatureDto) {
        return ResponseEntity.ok(creatureService.addCreature(creatureDto));
    }

    @Override
    public ResponseEntity<CreatureDto> updateCreature(Long id, CreatureDto creatureDto) {
        return ResponseEntity.ok(creatureService.updateById(id, creatureDto));
    }

    @Override
    public ResponseEntity<Void> removeCreature(Long id) {
        creatureService.removeById(id);
        return ResponseEntity.ok().build();
    }
} 
