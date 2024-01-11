package com.example.server.student;

import com.example.server.common.repository.GenericRepository;
import com.example.server.student.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface StudentRepository extends GenericRepository<Student, UUID> {
}
