package com.example.demowebfluxr2dbcpostgres

import com.example.demowebfluxr2dbcpostgres.domain.Customer
import org.springframework.data.r2dbc.repository.query.Query
import reactor.core.publisher.Mono
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux




interface CustomerRepository : ReactiveCrudRepository<Customer, Long> {
    @Query("DELETE FROM customer")
    fun deleteAllById(): Mono<Customer>

    @Query("select id, name, age from customer c where c.name = :name")
    fun findByName(name: String): Flux<Customer>
}