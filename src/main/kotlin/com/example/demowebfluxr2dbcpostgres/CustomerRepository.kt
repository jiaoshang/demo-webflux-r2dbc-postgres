package com.example.demowebfluxr2dbcpostgres

import com.example.demowebfluxr2dbcpostgres.domain.Customer
import org.springframework.data.r2dbc.repository.query.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Repository
interface CustomerRepository : ReactiveCrudRepository<Customer, Long> {
    //TODO delete by name performs slow
    @Query("delete from customer c where c.name = :name")
    fun deleteByName(name: String): Mono<Customer>

    @Query("select id, name from customer c where c.name = :name")
    fun findByName(name: String): Flux<Customer>
}