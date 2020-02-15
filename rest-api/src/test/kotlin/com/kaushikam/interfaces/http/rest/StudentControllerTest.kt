package com.kaushikam.interfaces.http.rest

import com.github.database.rider.core.api.dataset.DataSet
import com.github.database.rider.core.api.dataset.ExpectedDataSet
import com.github.database.rider.spring.api.DBRider
import com.kaushikam.StudentApplication
import com.kaushikam.interfaces.http.rest.facade.AddStudentDTO
import com.kaushikam.interfaces.http.rest.facade.StudentDTO
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import java.net.URI
import kotlin.test.assertEquals

@DBRider
@SpringBootTest(
	classes = [StudentApplication::class],
	webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class StudentControllerTest {

	@LocalServerPort
	var port: Int? = null

	@Autowired
	private lateinit var restTemplate: TestRestTemplate

	@Test
	@DataSet("datasets/interfaces/http/rest/student-controller/before-list.yml")
	fun `test list students`() {
		val url = createURLWithPort("/v1/students")
		val expected = mutableListOf(StudentDTO(1, "raju", 15, 10),
			StudentDTO(2, "shan", 12, 6))
		val response = restTemplate.getForEntity(URI(url), Array<StudentDTO>::class.java)
		Assertions.assertThat(response.body).containsExactly(*expected.toTypedArray())
	}

	@Test
	@DataSet("datasets/interfaces/http/rest/student-controller/before-add.yml")
	@ExpectedDataSet("datasets/interfaces/http/rest/student-controller/after-add.yml", ignoreCols = ["id"])
	fun `test add student`() {
		val request = AddStudentDTO (name = "raju", age = 15, standard = 10)
		val entity = HttpEntity(request, HttpHeaders())
		val expected = StudentDTO (id = 1, name = "raju", age = 15, standard = 10)
		val response = restTemplate.exchange(createURLWithPort("/v1/student"), HttpMethod.POST, entity, StudentDTO::class.java)
		assertEquals(expected, response.body)
	}

	private fun createURLWithPort(uri: String): String {
		return "http://localhost:$port$uri"
	}

}
