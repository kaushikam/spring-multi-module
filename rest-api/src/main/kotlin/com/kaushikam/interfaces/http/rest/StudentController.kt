package com.kaushikam.interfaces.http.rest

import com.kaushikam.application.StudentManagementService
import com.kaushikam.interfaces.http.rest.facade.AddStudentDTO
import com.kaushikam.interfaces.http.rest.facade.StudentDTO
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

private val logger = KotlinLogging.logger {  }

@RestController
class StudentController @Autowired constructor (
	private val mgmtService: StudentManagementService
) {
	@PostMapping("/v1/student")
	fun addStudent(
		@RequestBody
		request: AddStudentDTO
	): ResponseEntity<StudentDTO> {
		logger.info { "Request for adding student: $request" }
		val student = request.toStudent()
		mgmtService.addStudent(student)
		logger.info { "Student got added and id is $student.id" }
		val response = StudentDTO.build(student)
		return ResponseEntity(response, HttpStatus.CREATED)
	}

	@GetMapping("/v1/students")
	fun listStudents(): ResponseEntity<List<StudentDTO>> {
		logger.info { "Listing students" }
		val students = mgmtService.listStudents()
		logger.info { "Total number of students is ${students.size}" }
		val list = mutableListOf<StudentDTO>()
		students.forEach { student ->
			val dto = StudentDTO.build(student)
			list.add(dto)
		}
		return ResponseEntity(list, HttpStatus.OK)
	}
}