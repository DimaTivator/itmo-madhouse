package org.dimativator.itmomadhouse.rest.impl;

import lombok.RequiredArgsConstructor;
import org.dimativator.itmomadhouse.rest.UserApi;
import org.dimativator.itmomadhouse.dto.UserDto;
import org.dimativator.itmomadhouse.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserApiImpl implements UserApi {
    private final UserService userService;

    @Override
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
} 