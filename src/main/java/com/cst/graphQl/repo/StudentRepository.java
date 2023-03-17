package com.cst.graphQl.repo;

import com.cst.graphQl.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, Integer> {
    public Optional<Student> findByRollNumber(String rollNumber);
}
