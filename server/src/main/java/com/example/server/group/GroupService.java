package com.example.server.group;

import com.example.server.group.dto.GroupCreateDto;
import com.example.server.group.dto.GroupResponseDto;
import com.example.server.group.entity.Group;
import com.example.server.user.UserRepository;
import com.example.server.user.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final EntityManager entityManager;

    @Transactional
    public GroupResponseDto create(GroupCreateDto groupCreateDto) {
        Group group = modelMapper.map(groupCreateDto, Group.class);
        group.setId(UUID.randomUUID());

        Group saved = groupRepository.save(group);
        return modelMapper.map(saved, GroupResponseDto.class);
    }

    @Transactional
    public List<GroupResponseDto> getAll() {
        return groupRepository
                .findAll()
                .stream()
                .map(group -> modelMapper.map(group, GroupResponseDto.class))
                .toList();
    }

    @Transactional
    public GroupResponseDto addUser(UUID groupId, UUID userId) {
        Group group = groupRepository.findById(groupId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();

        user.setGroup(group);
        userRepository.save(user);

        entityManager.flush();
        entityManager.clear();

        Group updatedGroup = groupRepository.findById(groupId).orElseThrow();
        return modelMapper.map(updatedGroup, GroupResponseDto.class);
    }
}
