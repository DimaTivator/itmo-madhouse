package org.dimativator.itmomadhouse.services;

import lombok.RequiredArgsConstructor;
import org.dimativator.itmomadhouse.dto.UserDto;
import org.dimativator.itmomadhouse.repository.UserRepository;
import org.dimativator.itmomadhouse.mappers.UserMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
            .map(UserMapper::toDto)
            .toList();
    }
} 