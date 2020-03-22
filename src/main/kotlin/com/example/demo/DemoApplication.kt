package com.example.demo

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@SpringBootApplication
class DemoApplication(val orderRepository: OrderRepository): CommandLineRunner {
	override fun run(vararg args: String) {
		println("Hello from Spring Boot!")
		println("Order count: ${orderRepository.count()}")
	}
}

@Repository
interface OrderRepository : CrudRepository<Order, Long>

@Table("orders")
data class Order(@Id val id: Long? = null, val orderName: String)

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
