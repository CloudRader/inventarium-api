package com.cloudrader.inventarium

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class InventariumApiApplication

fun main(args: Array<String>) {
	runApplication<InventariumApiApplication>(*args)
}
