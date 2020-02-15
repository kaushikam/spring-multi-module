package com.kaushikam.spring.config

import com.kaushikam.domain.model.student.Student
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration

@Configuration
@EntityScan(basePackageClasses = [ Student::class ])
class DomainConfig