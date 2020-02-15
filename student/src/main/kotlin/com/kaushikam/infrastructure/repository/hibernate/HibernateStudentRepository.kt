package com.kaushikam.infrastructure.repository.hibernate

import com.kaushikam.domain.model.student.Student
import com.kaushikam.domain.model.student.StudentRepository
import org.springframework.data.repository.Repository
import org.springframework.transaction.annotation.Transactional

@Transactional
interface HibernateStudentRepository: Repository<Student, Long>, StudentRepository