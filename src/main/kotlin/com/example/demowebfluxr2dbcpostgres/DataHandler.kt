package com.example.demowebfluxr2dbcpostgres

import org.springframework.stereotype.Component
import com.example.demowebfluxr2dbcpostgres.domain.Customer
import org.jetbrains.annotations.NotNull
import reactor.core.publisher.Mono
import org.springframework.transaction.annotation.Transactional



@Component
class DataHandler {
    @NotNull
    private val repository: CustomerRepository? = null
    
    @Transactional
    fun save(customer: Customer):Mono<Customer> {
        return repository!!.save(customer)
    }
}