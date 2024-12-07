package org.dimativator.itmomadhouse.services;

import lombok.RequiredArgsConstructor;

import org.dimativator.itmomadhouse.dto.AuthDto;
import org.dimativator.itmomadhouse.dto.RegisteredUserDto;
import org.dimativator.itmomadhouse.dto.SignUpDto;
import org.dimativator.itmomadhouse.model.User;
import org.dimativator.itmomadhouse.repository.UserRepository;
import org.dimativator.itmomadhouse.jwt.UserAuthProvider;
import org.dimativator.itmomadhouse.mappers.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserAuthProvider userAuthProvider;
    
    public RegisteredUserDto register(SignUpDto signUpDto) {
        final User user = UserMapper.toEntity(signUpDto);
        user.setPassword(encodePassword(signUpDto.getPassword()));
        user.setRole(signUpDto.getRole());
        userRepository.save(user);
        final RegisteredUserDto registeredUserDto = UserMapper.toRegisteredUserDto(user);
        registeredUserDto.setToken(userAuthProvider.createToken(user.getLogin(), user.getRole()));
        return registeredUserDto;
    }

    public RegisteredUserDto authorize(AuthDto authDto) {
        final User user = userRepository.findByLogin(authDto.getLogin())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "No such user"));
        final String requestPassword = encodePassword(authDto.getPassword());

        if (requestPassword.equals(user.getPassword())) {
            final RegisteredUserDto registeredUserDto = UserMapper.toRegisteredUserDto(user);
            registeredUserDto.setToken(userAuthProvider.createToken(user.getLogin(), user.getRole()));
            return registeredUserDto;
        }

        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Bad credentials");
    }

    public User getUserByToken(String token) {
        final String login = userAuthProvider.getLoginFromJwt(token);
        return userRepository.findByLogin(login)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "No such user"));
    }

    public User getUserByLogin(String login) {
        return userRepository.findByLogin(login)
                .orElse(null);
    }

    public List<String> getAllUserNames() {
        return userRepository.findAll().stream().map(User::getLogin).toList();
    }

    private String encodePassword(String password) {
        try {
            final MessageDigest messageDigest = MessageDigest.getInstance("SHA-384");
            return new String(messageDigest.digest(password.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("Couldn't encode password", e);
        }
    }
} 