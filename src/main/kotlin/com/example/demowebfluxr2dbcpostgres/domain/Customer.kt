package com.example.demowebfluxr2dbcpostgres.domain

import org.springframework.data.annotation.Id

data class Customer(@Id val id: Int?, val name: String) {

    fun hasId(): Boolean = id != null

    override fun toString(): String {
        return "Customer [id=$id, name=$name]"
    }
}