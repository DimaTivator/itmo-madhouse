package org.dimativator.itmomadhouse.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.dimativator.itmomadhouse.model.Role;
import java.util.List;

@RequestMapping("/api")
public interface UserApi {
    @GetMapping("/users")
    ResponseEntity<List<String>> getAllUserNames();

    @GetMapping("/user/role/current")
    ResponseEntity<Role> getRole(@RequestHeader("Authorization") String token);
} 