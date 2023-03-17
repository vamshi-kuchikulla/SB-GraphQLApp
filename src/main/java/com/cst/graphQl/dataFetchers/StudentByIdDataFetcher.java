package com.cst.graphQl.dataFetchers;

import com.cst.graphQl.entity.Student;
import com.cst.graphQl.repo.StudentRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentByIdDataFetcher implements DataFetcher<Student> {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student get(DataFetchingEnvironment environment) throws Exception {
        String rollNumber = environment.getArgument("rollNumber");
        return studentRepository.findByRollNumber(rollNumber).get();
    }
}
