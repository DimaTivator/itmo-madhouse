package org.dimativator.itmomadhouse.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.dimativator.itmomadhouse.dto.CreatureDto;
import java.util.List;

@RequestMapping("/api")
public interface CreatureApi {
    @GetMapping("/creatures")
    ResponseEntity<List<CreatureDto>> findAll();

    @PostMapping("/creature")
    ResponseEntity<CreatureDto> addCreature(@RequestBody CreatureDto creatureDto);

    @PutMapping("/creature/{id}")
    ResponseEntity<CreatureDto> updateCreature(@PathVariable Long id, @RequestBody CreatureDto creatureDto);

    @DeleteMapping("/creature/{id}")
    ResponseEntity<Void> removeCreature(@PathVariable Long id);
}
