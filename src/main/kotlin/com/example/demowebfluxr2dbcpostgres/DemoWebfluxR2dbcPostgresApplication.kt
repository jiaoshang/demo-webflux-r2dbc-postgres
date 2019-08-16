package com.example.demowebfluxr2dbcpostgres

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoWebfluxR2dbcPostgresApplication

fun main(args: Array<String>) {
    // TODO Spring Boot R2DBC Starter can be simpler
    runApplication<DemoWebfluxR2dbcPostgresApplication>(*args)
}
