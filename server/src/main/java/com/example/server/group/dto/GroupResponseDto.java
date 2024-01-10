package com.example.server.group.dto;

import com.example.server.group.entity.Group;
import com.example.server.user.dto.UserResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupResponseDto {
    private UUID id;
    private String name;
    private List<UserResponseDto> users;

    public GroupResponseDto(Group group) {
        this.id = group.getId();
        this.name = group.getName();
    }
}
