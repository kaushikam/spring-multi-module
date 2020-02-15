package com.kaushikam

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources

@SpringBootApplication
@PropertySources(
    PropertySource("classpath:test-application.properties")
)
class StudentTestApplication

fun main(args: Array<String>) {
    runApplication<StudentTestApplication>(*args)
}