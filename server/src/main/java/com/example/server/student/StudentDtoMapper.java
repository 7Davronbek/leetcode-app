package com.example.server.student;

import com.example.server.common.mapper.GenericMapper;
import com.example.server.student.dto.StudentCreateDto;
import com.example.server.student.dto.StudentResponseDto;
import com.example.server.student.dto.StudentUpdateDto;
import com.example.server.student.entity.Student;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@Getter
@RequiredArgsConstructor
public class StudentDtoMapper extends GenericMapper<Student, StudentCreateDto, StudentResponseDto, StudentUpdateDto> {
    private final ModelMapper mapper;

    @Override
    public Student toEntity(StudentCreateDto studentCreateDto) {
        return mapper.map(studentCreateDto, Student.class);
    }

    @Override
    public StudentResponseDto toResponse(Student student) {
        return mapper.map(student, StudentResponseDto.class);
    }

    @Override
    public void toUpdate(StudentUpdateDto studentUpdateDto, Student student) {
        mapper.map(studentUpdateDto, student);
    }
}
