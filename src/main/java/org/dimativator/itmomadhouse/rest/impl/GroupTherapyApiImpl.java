package org.dimativator.itmomadhouse.rest.impl;

import lombok.RequiredArgsConstructor;
import org.dimativator.itmomadhouse.rest.GroupTherapyApi;
import org.dimativator.itmomadhouse.dto.GroupTherapyDto;
import org.dimativator.itmomadhouse.services.GroupTherapyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class GroupTherapyApiImpl implements GroupTherapyApi {
    private final GroupTherapyService groupTherapyService;

    @Override
    public ResponseEntity<List<GroupTherapyDto>> findAll() {
        return ResponseEntity.ok(groupTherapyService.getAllGroupTherapies());
    }

    @Override
    public ResponseEntity<GroupTherapyDto> addGroupTherapy(GroupTherapyDto therapyDto) {
        return ResponseEntity.ok(groupTherapyService.addGroupTherapy(therapyDto));
    }

    @Override
    public ResponseEntity<GroupTherapyDto> updateGroupTherapy(Long id, GroupTherapyDto therapyDto) {
        return ResponseEntity.ok(groupTherapyService.updateById(id, therapyDto));
    }

    @Override
    public ResponseEntity<Void> removeGroupTherapy(Long id) {
        groupTherapyService.removeById(id);
        return ResponseEntity.ok().build();
    }
} 