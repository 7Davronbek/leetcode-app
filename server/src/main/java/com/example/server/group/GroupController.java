package com.example.server.group;

import com.example.server.group.dto.GroupCreateDto;
import com.example.server.group.dto.GroupResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @PostMapping
    public ResponseEntity<GroupResponseDto> create(@Valid @RequestBody GroupCreateDto groupCreateDto) {
        GroupResponseDto groupResponseDto = groupService.create(groupCreateDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(groupResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<GroupResponseDto>> getAll() {
        List<GroupResponseDto> groups = groupService.getAll();

        return ResponseEntity
                .ok(groups);
    }

    @PostMapping("/{groupId}/add-user/{userId}")
    public ResponseEntity<GroupResponseDto> addUser(
            @PathVariable UUID groupId,
            @PathVariable UUID userId
    ) {
        GroupResponseDto groupResponseDto = groupService.addUser(groupId, userId);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(groupResponseDto);
    }
}
