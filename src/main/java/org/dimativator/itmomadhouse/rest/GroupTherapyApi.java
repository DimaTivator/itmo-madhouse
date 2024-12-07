package org.dimativator.itmomadhouse.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.dimativator.itmomadhouse.dto.GroupTherapyDto;
import java.util.List;

@RequestMapping("/api")
public interface GroupTherapyApi {
    @GetMapping("/group-therapies")
    ResponseEntity<List<GroupTherapyDto>> findAll();

    @PostMapping("/group-therapy")
    ResponseEntity<GroupTherapyDto> addGroupTherapy(@RequestBody GroupTherapyDto therapyDto);

    @PutMapping("/group-therapy/{id}")
    ResponseEntity<GroupTherapyDto> updateGroupTherapy(@PathVariable Long id, @RequestBody GroupTherapyDto therapyDto);

    @DeleteMapping("/group-therapy/{id}")
    ResponseEntity<Void> removeGroupTherapy(@PathVariable Long id);
}
