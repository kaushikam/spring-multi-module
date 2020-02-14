package com.kaushikam.application

import com.kaushikam.domain.model.student.Student

interface StudentManagementService {
    fun addStudent(student: Student)
    fun listStudents(): List<Student>
}