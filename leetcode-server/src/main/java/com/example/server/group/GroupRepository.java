package com.example.server.group;

import com.example.server.group.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface GroupRepository extends JpaRepository<Group, UUID> {
}
