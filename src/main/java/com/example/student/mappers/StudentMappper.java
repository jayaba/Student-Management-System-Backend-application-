package com.example.student.mappers;

import com.example.student.dto.StudentDto;
import com.example.student.model.Student;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMappper {

    StudentMappper INSTANCE = Mappers.getMapper(StudentMappper.class);

    StudentDto toDto(Student student);

    Student toEntity(StudentDto studentDto);
}
