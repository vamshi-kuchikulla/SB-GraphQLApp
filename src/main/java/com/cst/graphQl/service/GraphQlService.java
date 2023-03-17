package com.cst.graphQl.service;

import com.cst.graphQl.dataFetchers.AllStudentDataFetcher;
import com.cst.graphQl.dataFetchers.StudentByIdDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class GraphQlService {
    @Value("classpath:student.graphql")
    Resource resource;
    private GraphQL graphQL;
    @Autowired
    private AllStudentDataFetcher allStudentDataFetcher;
    @Autowired
    private StudentByIdDataFetcher studentByIdDataFetcher;

    @PostConstruct
    public void loadSchema() throws IOException {
        //get the schema
        File schemaFile = resource.getFile();
        //
        TypeDefinitionRegistry registry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(registry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("allStudents", allStudentDataFetcher)
                        .dataFetcher("Student", studentByIdDataFetcher))
                .build();
    }

    public GraphQL getGraphQL() {
        return graphQL;
    }
}
