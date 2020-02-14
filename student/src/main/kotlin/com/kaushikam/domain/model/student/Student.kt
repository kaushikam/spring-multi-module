package com.kaushikam.domain.model.student

import javax.persistence.*

@Entity
@Table(name = "student")
class Student (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    @Column(name = "name")
    val name: String,

    @Column(name = "age")
    val age: Int,

    @Column(name = "standard")
    val standard: Int
)