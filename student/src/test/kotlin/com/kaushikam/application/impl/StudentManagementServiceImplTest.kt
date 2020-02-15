package com.kaushikam.application.impl

import com.github.database.rider.core.api.dataset.DataSet
import com.github.database.rider.core.api.dataset.ExpectedDataSet
import com.github.database.rider.spring.api.DBRider
import com.kaushikam.application.StudentManagementService
import com.kaushikam.domain.model.student.Student
import com.kaushikam.spring.config.ApplicationConfig
import com.kaushikam.spring.config.DomainConfig
import com.kaushikam.spring.config.PersistenceConfig
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals

@DBRider
@SpringBootTest (
	classes = [DomainConfig::class, PersistenceConfig::class, ApplicationConfig::class]
)
class StudentManagementServiceImplTest {
	@Autowired
	private lateinit var mgmtService: StudentManagementService

	@Test
	@DataSet("datasets/application/student-management/before-add.yml")
	@ExpectedDataSet("datasets/application/student-management/after-add.yml", ignoreCols = ["id"])
	fun `test add student`() {
		val student = Student(name = "raju", age = 15, standard = 10)
		mgmtService.addStudent(student)
	}

	@Test
	@DataSet("datasets/application/student-management/before-list.yml")
	fun `test list students`() {
		val students = mgmtService.listStudents()
		assertEquals(2, students.size)
	}
}
