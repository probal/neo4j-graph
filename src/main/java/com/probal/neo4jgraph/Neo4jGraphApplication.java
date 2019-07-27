package com.probal.neo4jgraph;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Neo4jGraphApplication {

	public static void main(String[] args) {
		SpringApplication.run(Neo4jGraphApplication.class, args);
	}

}
