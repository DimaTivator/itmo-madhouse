package org.dimativator.itmomadhouse.rest.impl;

import lombok.RequiredArgsConstructor;
import org.dimativator.itmomadhouse.rest.UserApi;
import org.dimativator.itmomadhouse.services.UserService;
import org.springframework.http.ResponseEntity;
import org.dimativator.itmomadhouse.model.Role;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserApiImpl implements UserApi {
    private final UserService userService;

    @Override
    public ResponseEntity<List<String>> getAllUserNames() {
        return ResponseEntity.ok(userService.getAllUserNames());
    }

    @Override
    public ResponseEntity<Role> getRole(String token) {
        return ResponseEntity.ok(userService.getUserByToken(token.split(" ")[1]).getRole());
    }
} 