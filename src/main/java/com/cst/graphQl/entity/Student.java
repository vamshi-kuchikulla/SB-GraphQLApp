package com.cst.graphQl.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(value = "student")
public class Student {
    @Id
    private String id;
    private String rollNumber;
    private String fullName;
    private String email;
    private String department;
    private String mobile;
    private int age;
    private String nationality;

}

