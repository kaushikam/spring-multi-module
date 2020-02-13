package com.kaushikam.domain.model.student

interface StudentRepository {
    fun save(persisted: Student)
    fun findAll(): List<Student>
    fun findById(id: Long): Student?
    fun findByName(name: String): List<Student>
}