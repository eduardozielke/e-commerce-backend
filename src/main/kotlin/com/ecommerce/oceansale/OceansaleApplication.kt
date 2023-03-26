package com.ecommerce.oceansale

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication
class OceansaleApplication

fun main(args: Array<String>) {
	runApplication<OceansaleApplication>(*args)
}
