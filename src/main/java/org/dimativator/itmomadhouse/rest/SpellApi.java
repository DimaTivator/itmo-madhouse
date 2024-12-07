package org.dimativator.itmomadhouse.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.dimativator.itmomadhouse.dto.SpellDto;
import java.util.List;

@RequestMapping("/api")
public interface SpellApi {
    @GetMapping("/spells")
    ResponseEntity<List<SpellDto>> findAll();

    @GetMapping("/spell/{id}")
    ResponseEntity<SpellDto> getSpell(@PathVariable Long id);

    @PostMapping("/spell")
    ResponseEntity<SpellDto> addSpell(@RequestBody SpellDto spellDto);

    @PutMapping("/spell/{id}")
    ResponseEntity<SpellDto> updateSpell(@PathVariable Long id, @RequestBody SpellDto spellDto);

    @DeleteMapping("/spell/{id}")
    ResponseEntity<Void> removeSpell(@PathVariable Long id);
} 