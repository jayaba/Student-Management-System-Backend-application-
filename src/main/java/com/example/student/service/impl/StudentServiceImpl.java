package com.example.student.service.impl;

import com.example.student.dto.StudentDto;
import com.example.student.mappers.StudentMappper;
import com.example.student.model.Student;
import com.example.student.repository.StudentDao;
import com.example.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {




//   private final StudentMappper studentMappper;



   @Autowired
    private  StudentDao studentDao;

//
//    @Autowired
//    private final StudentDto studentDto;

//    @Autowired
//    public StudentServiceImpl(StudentMappper studentMappper, StudentDao studentDao) {
//        this.studentMappper = studentMappper;
//        this.studentDao = studentDao;
//
//    }


    @Override
    public String addStudent(StudentDto studentDto) {
        Student student = new Student();
       student.setFirstName(studentDto.getFirstName());
       student.setLastName(studentDto.getLastName());
       student.setStudentAddress(studentDto.getStudentAddress());
       student.setStudentEmail(studentDto.getStudentEmail());
        Student save = studentDao.save(student);
       return "saved";
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> all = studentDao.findAll();

        List<StudentDto> studentDtoList = new ArrayList<>();

        all.stream().map(student -> {
            StudentDto studentDto = new StudentDto();
            studentDto.setFirstName(student.getFirstName());
            studentDto.setLastName(student.getLastName());
            studentDto.setStudentAddress(student.getStudentAddress());
            studentDto.setStudentEmail(student.getStudentEmail());
            studentDto.setStudentId(student.getStudentId());
            studentDtoList.add(studentDto);
            return studentDtoList;
        }).collect(Collectors.toList());
        return studentDtoList;
    }

    @Override
    public StudentDto getStudentByStudentId(Integer studentId) {
        Optional<Student> studentDaoById = studentDao.findById(studentId);
        StudentDto studentDto = new StudentDto();
        if (studentDaoById.isPresent()){

            studentDto.setStudentId(studentDaoById.get().getStudentId());
            studentDto.setFirstName(studentDaoById.get().getFirstName());
            studentDto.setLastName(studentDaoById.get().getLastName());
            studentDto.setStudentAddress(studentDaoById.get().getStudentAddress());
            studentDto.setStudentEmail(studentDaoById.get().getStudentEmail());
         return studentDto;
        }else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void deleteStudent(Integer studentId) {
        Optional<Student> byId = studentDao.findById(studentId);
        if (byId.isPresent()){
            studentDao.delete(byId.get());
        }
    }
}
