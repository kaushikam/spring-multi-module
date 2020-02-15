package com.kaushikam.spring.config

import com.kaushikam.application.impl.StudentManagementServiceImpl
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources

@Configuration
@PropertySources(
	PropertySource("classpath:test-application.properties")
)
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = [StudentManagementServiceImpl::class])
class ApplicationConfig