package com.kaushikam

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.test.context.TestPropertySource

@SpringBootApplication
@TestPropertySource(locations = ["classpath:test-application.properties"])
class StudentTestApplication

fun main(args: Array<String>) {
    runApplication<StudentTestApplication>(*args)
}