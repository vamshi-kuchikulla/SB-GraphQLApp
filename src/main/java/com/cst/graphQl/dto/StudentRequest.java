package com.cst.graphQl.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRequest {

    @NotNull(message = "rollNumber shouldn't be null")
    private String rollNumber;
    @NotNull(message = "fullName shouldn't be null")
    private String fullName;
    @Email(message = "invalid email address")
    private String email;
    @Pattern(regexp = "^\\d{10}$",message = "invalid mobile number entered ")
    private String mobile;
    @Min(18)
    @Max(60)
    private int age;
    @NotBlank
    private String nationality;
    @NotEmpty
    private String department;
}
