package com.example.server.user;

import com.example.server.user.dto.UserCreateDto;
import com.example.server.user.dto.UserResponseDto;
import com.example.server.user.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public UserResponseDto create(UserCreateDto userCreateDto) {
        User user = modelMapper.map(userCreateDto, User.class);
        user.setId(UUID.randomUUID());

        User saved = userRepository.save(user);
        return modelMapper.map(saved, UserResponseDto.class);
    }

    public List<UserResponseDto> getAll() {

        return userRepository
                .findAll()
                .stream()
                .map(UserResponseDto::new)
                .toList();
    }
}
