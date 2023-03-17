package com.cst.graphQl.service;

import com.cst.graphQl.dto.StudentRequest;
import com.cst.graphQl.dto.StudentResponse;
import com.cst.graphQl.entity.Student;
import com.cst.graphQl.handler.StudentNotFoundException;
import com.cst.graphQl.repo.StudentRepository;
import com.cst.graphQl.util.ValueMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<StudentResponse> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(ValueMapper::studentEntityToDto).collect(Collectors.toList());
    }

    public StudentResponse createStudent(StudentRequest studentRequest) {
        Student student = ValueMapper.studentDtoToEntity(studentRequest);
        Student savedStudent = studentRepository.save(student);
        return ValueMapper.studentEntityToDto(savedStudent);
    }

    public StudentResponse getStudentById(String rollNumber) {
        StudentResponse studentResponse =null;
       Optional<Student>  student = studentRepository.findByRollNumber(rollNumber);
       if(student.isPresent()){
           studentResponse = ValueMapper.studentEntityToDto(student.get());
       }else {
           throw new StudentNotFoundException("Student not found for this id :: " + rollNumber);
       }
      return studentResponse;
    }
}
