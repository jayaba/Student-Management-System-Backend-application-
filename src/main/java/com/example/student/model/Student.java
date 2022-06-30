package com.example.student.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Student_Table")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer studentId;
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    private String studentAddress;
    private String studentEmail;



}
