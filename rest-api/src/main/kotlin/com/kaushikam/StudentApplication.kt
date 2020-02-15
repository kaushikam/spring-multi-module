package com.kaushikam

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
class StudentApplication: SpringBootServletInitializer()

fun main(args: Array<String>) {
	runApplication<StudentApplication>(*args)
}