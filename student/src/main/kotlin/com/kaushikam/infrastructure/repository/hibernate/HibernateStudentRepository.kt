package com.kaushikam.infrastructure.repository.hibernate

import com.kaushikam.domain.model.student.Student
import com.kaushikam.domain.model.student.StudentRepository
import org.springframework.data.repository.Repository

interface HibernateStudentRepository: StudentRepository, Repository<Student, Long>