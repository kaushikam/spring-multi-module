package com.kaushikam.domain.model.student

interface StudentRepository {
    fun save(persisted: Student)
    fun findAll(): List<Student>
    fun findById(id: Long): Student?
    fun findAllByName(name: String): List<Student>
    fun count(): Long
}