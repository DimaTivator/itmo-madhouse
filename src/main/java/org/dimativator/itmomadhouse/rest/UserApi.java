package org.dimativator.itmomadhouse.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.dimativator.itmomadhouse.dto.UserDto;
import java.util.List;

@RequestMapping("/api")
public interface UserApi {
    @GetMapping("/users")
    ResponseEntity<List<UserDto>> findAll();
} 