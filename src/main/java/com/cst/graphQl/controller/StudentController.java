package com.cst.graphQl.controller;

import com.cst.graphQl.dto.StudentRequest;
import com.cst.graphQl.dto.StudentResponse;
import com.cst.graphQl.service.GraphQlService;
import com.cst.graphQl.service.StudentService;
import graphql.ExecutionResult;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    private final GraphQlService graphQlService;

    public StudentController(StudentService studentService, GraphQlService graphQlService) {
        this.studentService = studentService;
        this.graphQlService = graphQlService;
    }
    @PostMapping
    public ResponseEntity<Object> getAllStudents(@RequestBody String query) {
        ExecutionResult execute = graphQlService.getGraphQL().execute(query);
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<StudentResponse> createStudent(@Valid @RequestBody StudentRequest studentRequest) {
        StudentResponse response = studentService.createStudent(studentRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentResponse>> getAll() {
       List<StudentResponse> list = studentService.getAllStudent();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public  ResponseEntity<StudentResponse> getStudentById(@PathVariable(value="id") String rollNumber){
      StudentResponse response = studentService.getStudentById(rollNumber);
      return  ResponseEntity.ok().body(response);
    }
}
