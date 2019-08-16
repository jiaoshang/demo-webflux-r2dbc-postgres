package com.example.demowebfluxr2dbcpostgres

import com.example.demowebfluxr2dbcpostgres.domain.Customer
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.test.context.junit4.SpringRunner
import reactor.core.publisher.Hooks
import reactor.test.StepVerifier


@RunWith(SpringRunner::class)
@SpringBootTest
class CustomerRespositoryIT {

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    @Autowired
    private lateinit var client: DatabaseClient


    @Before
    fun setup() {
        Hooks.onOperatorDebug()
        val dropTable = "DROP TABLE IF EXISTS customer;"
        val createTable = "CREATE TABLE IF NOT EXISTS customer ( id SERIAL PRIMARY KEY, name VARCHAR(100) NOT NULL);"
        val statements = listOf(dropTable, createTable)
        statements.forEach{client.execute().sql(it).fetch().all().blockFirst()}

    }

    @Test
    fun executeFindByName() {
        val david = Customer(null, "David")

        StepVerifier.create(
                customerRepository.save(david))
                .expectNextMatches(Customer::hasId)
                .verifyComplete()
        StepVerifier.create(
                customerRepository.findByName("David"))
                .expectNextCount(1)
                .verifyComplete()
    }

    @Test
    fun executeDeleteByName() {
        val david = Customer(null, "David")

        StepVerifier.create(
                customerRepository.save(david))
                .expectNextMatches(Customer::hasId)
                .verifyComplete()
        StepVerifier.create(
                customerRepository.findByName("David"))
                .expectNextCount(1)
                .verifyComplete()

        StepVerifier.create(
                customerRepository.deleteAll())
                .verifyComplete()
        StepVerifier.create(
                customerRepository.findByName("David"))
                .expectNextCount(0)
                .verifyComplete()
    }
}