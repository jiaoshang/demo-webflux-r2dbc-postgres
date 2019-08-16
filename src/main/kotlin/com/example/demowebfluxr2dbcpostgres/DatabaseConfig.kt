package com.example.demowebfluxr2dbcpostgres

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration
import io.r2dbc.postgresql.PostgresqlConnectionFactory
import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@Configuration
@EnableR2dbcRepositories
class DatabaseConfig: AbstractR2dbcConfiguration() {
    @Bean
    override fun connectionFactory(): PostgresqlConnectionFactory = PostgresqlConnectionFactory(
            PostgresqlConnectionConfiguration.builder()
                    .host("localhost")
                    .port(5432)
                    .database("postgres")
                    .username("name")
                    .password("pass")
                    .build())

    @Bean
    fun databaseClient(connectionFactory: ConnectionFactory): DatabaseClient = DatabaseClient.builder()
            .connectionFactory(connectionFactory)
            .build()
}