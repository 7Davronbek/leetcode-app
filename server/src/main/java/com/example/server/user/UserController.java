package com.example.server.user;

import com.example.server.user.dto.UserCreateDto;
import com.example.server.user.dto.UserResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@Valid @RequestBody UserCreateDto userCreateDto) {
        UserResponseDto userResponseDto = userService.create(userCreateDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAll(@RequestParam(required = false) String predicate) {
        List<UserResponseDto> users = userService.getAll(predicate);

        return ResponseEntity
                .ok(users);

//        1:35
    }
}
