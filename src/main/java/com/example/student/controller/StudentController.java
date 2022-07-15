package com.example.student.controller;

import com.example.student.dto.StudentDto;
import com.example.student.model.Student;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<String> addStudent(@RequestBody StudentDto studentDto){
        String saveStudent = studentService.addStudent(studentDto);

        return new ResponseEntity<>(saveStudent, HttpStatus.CREATED);
    }

    @GetMapping("all") //git test
    public ResponseEntity<List<StudentDto>> getAllStudent(){
        List<StudentDto> allStudent = studentService.getAllStudent();
        return new ResponseEntity<>(allStudent,HttpStatus.OK);
    }

    @GetMapping("getById/{studentId}")
    public ResponseEntity<StudentDto> getStudentByStudentId(@PathVariable Integer studentId){
        StudentDto studentByStudentId = studentService.getStudentByStudentId(studentId);
        return new ResponseEntity<>(studentByStudentId,HttpStatus.OK);
    }

    @DeleteMapping("delete/{studentId}")
    public void DeleteStudentByStudentId(@PathVariable Integer studentId){
        studentService.deleteStudent(studentId);
    }
}
