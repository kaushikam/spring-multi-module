package com.kaushikam.domain.model.student

import javax.persistence.*

@Entity
@Table(name = "student")
class Student (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    val name: String,

    val age: Int,

    val standard: Int
)