package com.kaushikam.application.impl

import com.kaushikam.application.StudentManagementService
import com.kaushikam.domain.model.student.Student
import com.kaushikam.domain.model.student.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentManagementServiceImpl @Autowired constructor (
    val studentRepository: StudentRepository
): StudentManagementService {
    override fun addStudent(student: Student) {
        studentRepository.save(student)
    }

    override fun listStudents(): List<Student> {
        return studentRepository.findAll()
    }
}