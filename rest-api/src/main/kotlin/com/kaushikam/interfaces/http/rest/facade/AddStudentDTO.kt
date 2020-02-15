package com.kaushikam.interfaces.http.rest.facade

import com.kaushikam.domain.model.student.Student

data class AddStudentDTO (
	val name: String,
	val age: Int,
	val standard: Int
) {
	fun toStudent(): Student {
		return Student(name = name, age = age, standard = standard)
	}
}