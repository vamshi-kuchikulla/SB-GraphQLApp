package com.cst.graphQl.dataFetchers;

import com.cst.graphQl.entity.Student;
import com.cst.graphQl.repo.StudentRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllStudentDataFetcher implements DataFetcher<List<Student>> {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> get(DataFetchingEnvironment environment) throws Exception {
        return studentRepository.findAll();
    }
}
