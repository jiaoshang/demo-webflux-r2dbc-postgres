package com.example.demowebfluxr2dbcpostgres

import org.springframework.context.annotation.Configuration
import io.r2dbc.postgresql.PostgresqlConnectionConfiguration
import io.r2dbc.postgresql.PostgresqlConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.data.r2dbc.repository.support.R2dbcRepositoryFactory
import org.springframework.data.relational.core.mapping.RelationalMappingContext
import org.springframework.data.r2dbc.core.DatabaseClient
import io.r2dbc.spi.ConnectionFactory
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@Configuration
@EnableR2dbcRepositories
class DatabaseConfig {
    @Bean
    fun connectionFactory(): PostgresqlConnectionFactory = PostgresqlConnectionFactory(
            PostgresqlConnectionConfiguration.builder()
                    .host("localhost")
                    .database("postgres")
                    .username("name")
                    .password("pass")
                    .build())

    @Bean
    fun databaseClient(connectionFactory: ConnectionFactory): DatabaseClient = DatabaseClient.builder()
            .connectionFactory(connectionFactory)
            .build()
}