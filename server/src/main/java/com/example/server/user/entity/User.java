package com.example.server.user.entity;

import com.example.server.group.entity.Group;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`user`")
public class User {
    @Id
    private UUID id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}
