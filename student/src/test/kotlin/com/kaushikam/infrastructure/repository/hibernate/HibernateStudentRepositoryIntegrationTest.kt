package com.kaushikam.infrastructure.repository.hibernate

import com.github.database.rider.core.api.dataset.DataSet
import com.github.database.rider.core.api.dataset.ExpectedDataSet
import com.github.database.rider.core.configuration.ConnectionConfig
import com.github.database.rider.core.configuration.DBUnitConfig
import com.github.database.rider.junit5.DBUnitExtension
import com.kaushikam.StudentTestApplication
import com.kaushikam.domain.model.student.Student
import com.kaushikam.domain.model.student.StudentRepository
import mu.KotlinLogging
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.transaction.annotation.Transactional
import kotlin.test.assertNotNull

private val logger = KotlinLogging.logger {  }

@SpringBootTest(
    classes = [StudentTestApplication::class]
)
@ExtendWith(SpringExtension::class, DBUnitExtension::class)
class HibernateStudentRepositoryIntegrationTest {

    @Autowired
    private lateinit var studentRepository: StudentRepository

    @Test
    @DataSet("datasets/sql/repository/student-repository/before-save.yml")
    //@ExpectedDataSet("datasets/sql/repository/student-repository/after-save.yml", ignoreCols = ["ID"])
    fun `test save student`() {
        val student = Student(name = "raju", age = 15, standard = 10)
        studentRepository.save(student)
        logger.info { "Student id is ${student.id}" }
        assertNotNull(student.id)
    }
}