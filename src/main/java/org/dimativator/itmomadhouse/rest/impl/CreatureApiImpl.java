package org.dimativator.itmomadhouse.rest.impl;

import org.dimativator.itmomadhouse.rest.CreatureApi;
import org.dimativator.itmomadhouse.services.CreatureService;
import org.dimativator.itmomadhouse.dto.CreatureDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
public class CreatureApiImpl implements CreatureApi {
    private final CreatureService creatureService;

    @Autowired
    public CreatureApiImpl(CreatureService creatureService) {
        this.creatureService = creatureService;
    }

    @Override
    public ResponseEntity<List<CreatureDto>> findAll() {
        return ResponseEntity.ok(creatureService.getAllCreatures());
    }
} 
