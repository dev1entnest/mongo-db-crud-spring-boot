package com.example.crud.mongodb.controller;

import com.example.crud.mongodb.model.Student;
import com.example.crud.mongodb.repository.StudentRepository;
import com.example.crud.mongodb.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @PostMapping("/s")
    public Student createStudent(@Valid @RequestBody Student student){
        student.setId(sequenceGeneratorService.generateSequence(Student.SEQUENCE_NAME));
        return studentRepository.save(student);
    }
}
