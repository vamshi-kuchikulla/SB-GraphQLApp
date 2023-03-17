package com.cst.graphQl.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponse {
    private String id;
    private String rollNumber;
    private String fullName;
    private String email;
    private String department;
    private String mobile;
    private int age;
    private String nationality;
}
