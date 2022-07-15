package com.example.student.dto;

import com.example.student.model.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@NoArgsConstructor
public class StudentDto {


    private Integer studentId;
    private String firstName;
    private String lastName;
    private String studentAddress;
    private String studentEmail;

    public StudentDto toDto(Student student){
        StudentDto studentDto = new StudentDto();

        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setStudentAddress(student.getStudentAddress());
        studentDto.setStudentEmail(student.getStudentEmail());
        return studentDto;
    }

}
