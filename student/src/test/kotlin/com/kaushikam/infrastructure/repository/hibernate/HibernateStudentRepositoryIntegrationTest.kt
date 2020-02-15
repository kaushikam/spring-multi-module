package com.kaushikam.infrastructure.repository.hibernate

import com.github.database.rider.core.api.dataset.DataSet
import com.github.database.rider.core.api.dataset.ExpectedDataSet
import com.github.database.rider.junit5.api.DBRider
import com.kaushikam.domain.model.student.Student
import com.kaushikam.domain.model.student.StudentRepository
import com.kaushikam.spring.config.ApplicationConfig
import com.kaushikam.spring.config.DomainConfig
import com.kaushikam.spring.config.PersistenceConfig
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@DBRider

@SpringBootTest(
    classes = [DomainConfig::class, PersistenceConfig::class, ApplicationConfig::class]
)
class HibernateStudentRepositoryIntegrationTest {

    @Autowired
    private lateinit var studentRepository: StudentRepository

    @Test
    @DataSet("datasets/sql/repository/student-repository/before-save.yml")
    @ExpectedDataSet("datasets/sql/repository/student-repository/after-save.yml")
    fun `test save student`() {
        val student = Student(name = "raju", age = 15, standard = 10)
        studentRepository.save(student)
        val saved = studentRepository.findAllByName("raju")
        assertNotNull(student.id)
        assertEquals(1, studentRepository.count())
        assertEquals(1, saved.size)
    }
}