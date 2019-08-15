package com.example.demowebfluxr2dbcpostgres

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.core.DatabaseClient

@SpringBootApplication
class DemoWebfluxR2dbcPostgresApplication

fun main(args: Array<String>) {
	runApplication<DemoWebfluxR2dbcPostgresApplication>(*args)
	// TODO Spring Boot R2DBC Starter can be simpler, but 0.1.0.M1 is not stable

}
