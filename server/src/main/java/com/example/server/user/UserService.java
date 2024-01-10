package com.example.server.user;

import com.example.server.user.dto.UserCreateDto;
import com.example.server.user.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDto create(UserCreateDto userCreateDto) {
    }
}
