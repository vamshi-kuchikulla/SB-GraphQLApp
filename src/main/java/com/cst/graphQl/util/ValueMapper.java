package com.cst.graphQl.util;

import com.cst.graphQl.dto.StudentRequest;
import com.cst.graphQl.dto.StudentResponse;
import com.cst.graphQl.entity.Student;

public class ValueMapper {
    public static Student studentDtoToEntity(StudentRequest studentRequest) {
        Student student = Student.builder()
                .rollNumber(studentRequest.getRollNumber())
                .fullName(studentRequest.getFullName())
                .email(studentRequest.getEmail())
                .department(studentRequest.getDepartment())
                .nationality(studentRequest.getNationality())
                .mobile(studentRequest.getMobile())
                .age(studentRequest.getAge()).build();
        return student;
    }

    public static StudentResponse studentEntityToDto(Student student) {
        StudentResponse studentResponse = StudentResponse.builder()
                .id(student.getId())
                .rollNumber(student.getRollNumber())
                .fullName(student.getFullName())
                .email(student.getEmail())
                .department(student.getDepartment())
                .nationality(student.getNationality())
                .mobile(student.getMobile())
                .age(student.getAge()).build();
        return studentResponse;
    }
}
