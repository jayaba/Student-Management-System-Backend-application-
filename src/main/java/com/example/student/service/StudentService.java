package com.example.student.service;

import com.example.student.dto.StudentDto;

import java.util.List;

public interface StudentService {
    String addStudent(StudentDto studentDto);

    List<StudentDto> getAllStudent();

    StudentDto getStudentByStudentId(Integer studentId);

    void deleteStudent(Integer studentId);
}
