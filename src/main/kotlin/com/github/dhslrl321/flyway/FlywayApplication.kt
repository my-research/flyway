package com.github.dhslrl321.flyway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FlywayApplication

fun main(args: Array<String>) {
	runApplication<FlywayApplication>(*args)
}
