package com.kaushikam.interfaces.http.rest.facade

import com.kaushikam.domain.model.student.Student

data class StudentDTO (
	val id: Long,
	val name: String,
	val age: Int,
	val standard: Int
) {
	companion object {
		@JvmStatic
		fun build(student: Student): StudentDTO {
			return StudentDTO (
				id = student.id!!,
				name = student.name,
				age = student.age,
				standard = student.standard
			)
		}
	}
}