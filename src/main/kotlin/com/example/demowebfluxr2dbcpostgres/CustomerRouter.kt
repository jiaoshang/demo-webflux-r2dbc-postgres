package com.example.demowebfluxr2dbcpostgres

import com.example.demowebfluxr2dbcpostgres.domain.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class CustomerRouter() {

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    @Bean
    fun getAllCustomersRoute(): RouterFunction<ServerResponse> =
            router { GET("/customers")
            {
                ok().body(customerRepository.findAll(), Customer::class.java)
            } }
}