package com.example.demowebfluxr2dbcpostgres.domain

import org.springframework.data.annotation.Id

data class Customer(@Id val id: String, val name: String, val age: Int) {

    override fun toString(): String {
        return "Person [id=$id, name=$name, age=$age]"
    }
}