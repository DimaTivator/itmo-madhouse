package org.dimativator.itmomadhouse.rest.impl;

import org.dimativator.itmomadhouse.dto.AuthDto;
import org.dimativator.itmomadhouse.dto.RegisteredUserDto;
import org.dimativator.itmomadhouse.dto.SignUpDto;
import org.dimativator.itmomadhouse.rest.AuthApi;
import org.dimativator.itmomadhouse.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthApiImpl implements AuthApi {
    private final UserService userService;

    @Override
    public ResponseEntity<RegisteredUserDto> register(SignUpDto signUpDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(signUpDto));
    }

    @Override
    public ResponseEntity<RegisteredUserDto> authorize(AuthDto authDto) {
        return ResponseEntity.ok(userService.authorize(authDto));
    }
}