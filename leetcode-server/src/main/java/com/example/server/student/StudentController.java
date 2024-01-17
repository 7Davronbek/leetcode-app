package com.example.server.student;

import com.example.server.student.dto.StudentCreateDto;
import com.example.server.student.dto.StudentResponseDto;
import com.example.server.student.dto.StudentUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentResponseDto> createStudent(@RequestBody @Valid StudentCreateDto studentCreateDto) {
        StudentResponseDto studentResponseDto = studentService.create(studentCreateDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentResponseDto);
    }

    @GetMapping
    public ResponseEntity<Page<StudentResponseDto>> getStudents(
            @RequestParam(required = false) String predicate,
            Pageable pageable
    ) {
        Page<StudentResponseDto> studentResponseDtos = studentService.get(predicate, pageable);
        return ResponseEntity.ok(studentResponseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> getStudent(@PathVariable UUID id) {
        StudentResponseDto studentResponseDto = studentService.get(id);
        return ResponseEntity.ok(studentResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDto> updateStudent(
            @RequestBody StudentUpdateDto studentUpdateDto,
            @PathVariable UUID id
    ) {
        StudentResponseDto updated = studentService.update(studentUpdateDto, id);
        return ResponseEntity
                .ok(updated);
    }

    @GetMapping("/{id}")
    public void deleteStudent(@PathVariable UUID id) {
        studentService.delete(id);
    }
}
