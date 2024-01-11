package com.example.server.student;

import com.example.server.common.mapper.GenericMapper;
import com.example.server.common.service.GenericService;
import com.example.server.student.dto.StudentCreateDto;
import com.example.server.student.dto.StudentResponseDto;
import com.example.server.student.dto.StudentUpdateDto;
import com.example.server.student.entity.Student;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Getter
@RequiredArgsConstructor
public class StudentService extends GenericService<UUID, Student, StudentResponseDto, StudentCreateDto, StudentUpdateDto> {
    private final StudentRepository repository;
    private final Class<Student> entityClass = Student.class;
    private final StudentDtoMapper studentDtoMapper;

    @Override
    @Transactional
    protected GenericMapper<Student, StudentCreateDto, StudentResponseDto, StudentUpdateDto> getMapper() {
        return null;
    }

    @Override
    @Transactional
    protected StudentResponseDto internalCreate(StudentCreateDto studentCreateDto) {
        Student entity = studentDtoMapper.toEntity(studentCreateDto);
        UUID id = UUID.randomUUID();
        entity.setId(id);

        Student saved = repository.save(entity);

        return studentDtoMapper.toResponse(saved);
    }

    @Override
    @Transactional
    protected StudentResponseDto internalUpdate(StudentUpdateDto studentUpdateDto, UUID uuid) {
        Student student = repository
                .findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Student with id: %s not found".formatted(uuid)));
        studentDtoMapper.toUpdate(studentUpdateDto, student);

        Student saved = repository.save(student);

        return studentDtoMapper.toResponse(saved);
    }
}
